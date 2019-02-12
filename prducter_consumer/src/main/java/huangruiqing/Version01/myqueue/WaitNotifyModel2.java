package huangruiqing.Version01.myqueue;

import huangruiqing.Version01.service.IModel;
import huangruiqing.Version01.service.impl.AbstractConsumer;
import huangruiqing.Version01.service.impl.AbstractProducer;
import huangruiqing.Version01.task.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName WaitNotifyModel2
 * @Description // wait && notify
 * 如果不能将并发与容量控制都封装在缓冲区中，就只能由消费者与生产者完成。
 * 最简单的方案是使用朴素的wait && notify机制
 * @Author huangrq
 * @Date 2019/1/10 10:23
 */
public class WaitNotifyModel2 implements IModel {

    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> buffer = new LinkedList<Task>();
    private final int cap;
    private final AtomicInteger incrTaskNo = new AtomicInteger(0);

    public WaitNotifyModel2(int cap) {
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer {
        @Override
        public void consumer() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == 0) {
                    BUFFER_LOCK.wait();
                }
                Task task = buffer.poll();
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("consume: " + task.getNo());
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    private class ProducerImpl extends AbstractProducer {

        @Override
        public void product() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == cap) {
                    BUFFER_LOCK.wait();
                }
                Task task = new Task(incrTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("produce: " + task.getNo());
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        IModel model = new WaitNotifyModel2(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
