package huangruiqing.Version01.myqueue;

import huangruiqing.Version01.service.IModel;
import huangruiqing.Version01.service.impl.AbstractConsumer;
import huangruiqing.Version01.service.impl.AbstractProducer;
import huangruiqing.Version01.task.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName BlockingQueueModel
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/1/9 17:52
 */
public class BlockingQueueModel implements IModel {

    private final BlockingQueue<Task> queue;
    private AtomicInteger incrTaskNo = new AtomicInteger(0);

    public BlockingQueueModel(int cap) {
        this.queue = new LinkedBlockingQueue<>(cap);
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
            Task task = queue.take();

            // 固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume: " + task.getNo());
        }
    }

    private class ProducerImpl extends AbstractProducer {

        @Override
        public void product() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(incrTaskNo.getAndIncrement());
            /*if(task.getNo()==6){//生产着停止生产
                while(!Thread.currentThread().isInterrupted()){
                    try {
                        Thread.sleep(1000);
                    }catch(InterruptedException ex)
                    {
                        Thread.interrupted();
                    }
                }
                Thread.currentThread().interrupt();
            }else{
                queue.put(task);
                System.out.println("produce: " + task.getNo());
            }*/
            queue.put(task);
            System.out.println("produce: " + task.getNo());

        }
    }

    public static void main(String[] args) {
        IModel model = new BlockingQueueModel(3);
        for (int i = 0; i < 1; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 1; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
