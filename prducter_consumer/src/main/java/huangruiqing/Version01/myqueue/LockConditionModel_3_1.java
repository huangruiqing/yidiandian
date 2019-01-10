package huangruiqing.Version01.myqueue;

import huangruiqing.Version01.service.IModel;
import huangruiqing.Version01.service.impl.AbstractConsumer;
import huangruiqing.Version01.service.impl.AbstractProducer;
import huangruiqing.Version01.task.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockConditionModel_3_1
 * @Description  我们要保证理解wait && notify机制。
 * 实现时可以使用Object类提供的wait()方法与notifyAll()方法，
 * 但更推荐的方式是使用java.util.concurrent包提供的Lock && Condition。
 * @Author huangrq
 * @Date 2019/1/10 11:31
 */
public class LockConditionModel_3_1 implements IModel {

    private final Lock BUFFER_LOCK = new ReentrantLock();
    private final Condition BUFFER_COND = BUFFER_LOCK.newCondition();
    private final Queue<Task> buffer = new LinkedList<>();
    private final  int cap;
    private final AtomicInteger incTaskNo = new AtomicInteger(0);
    public LockConditionModel_3_1(int cap) {
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
            BUFFER_LOCK.lockInterruptibly();
            try {
                while (buffer.size() == 0) {
                    BUFFER_COND.await();
                }
                Task task = buffer.poll();
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("consume: " + task.getNo());
                BUFFER_COND.signalAll();
            } finally {
                BUFFER_LOCK.unlock();
            }
        }
    }
    private class ProducerImpl extends AbstractProducer {
        @Override
        public void product() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            BUFFER_LOCK.lockInterruptibly();
            try {
                while (buffer.size() == cap) {
                    BUFFER_COND.await();
                }
                Task task = new Task(incTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("produce: " + task.getNo());
                BUFFER_COND.signalAll();
            } finally {
                BUFFER_LOCK.unlock();
            }
        }
    }
    public static void main(String[] args) {
        IModel model = new LockConditionModel_3_1(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
