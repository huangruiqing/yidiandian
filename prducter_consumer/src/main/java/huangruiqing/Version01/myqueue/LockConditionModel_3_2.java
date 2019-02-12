package huangruiqing.Version01.myqueue;

import huangruiqing.Version01.service.IModel;
import huangruiqing.Version01.service.impl.AbstractConsumer;
import huangruiqing.Version01.service.impl.AbstractProducer;
import huangruiqing.Version01.task.Task;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockConditionModel_3_2
 * @Description 那么思路就简单了：需要两个锁 CONSUME_LOCK与PRODUCE_LOCK，CONSUME_LOCK控制消费者线程并发出队，
 * PRODUCE_LOCK控制生产者线程并发入队；相应需要两个条件变量NOT_EMPTY与NOT_FULL，
 * OT_EMPTY负责控制消费者线程的状态（阻塞、运行），NOT_FULL负责控制生产者线程的状态（阻塞、运行）。
 * 以此让优化消费者与消费者（或生产者与生产者）之间是串行的；消费者与生产者之间是并行的。
 * @Author huangrq
 * @Date 2019/1/10 14:06
 */
public class LockConditionModel_3_2 implements IModel {

    private final Lock CONSUMER_LOCK = new ReentrantLock();
    private final Condition NOT_EMPTY = CONSUMER_LOCK.newCondition();

    private final Lock PRODUCER_LOCK = new ReentrantLock();
    private final Condition NOT_FULL = PRODUCER_LOCK.newCondition();
    private final Buffer<Task> buffer = new Buffer<Task>();
    private AtomicInteger bufLen = new AtomicInteger(0);
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public LockConditionModel_3_2(int cap) {
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
            int newBufSize = -1;
            CONSUMER_LOCK.lockInterruptibly();
            try {
                while (bufLen.get() == 0) {
                    System.out.println("buffer is empty...");
                    NOT_EMPTY.await();
                }
                Task task = buffer.poll();
                System.out.println(Thread.currentThread().getName() + "-> consumer before:" + bufLen.get());
                newBufSize = bufLen.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + "-> consumer after:" + bufLen.get());
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("consume: " + task.getNo());
                if (newBufSize > 0) {
                    NOT_EMPTY.signalAll();
                }
            } finally {
                CONSUMER_LOCK.unlock();
            }
            if (newBufSize < cap) {
                PRODUCER_LOCK.lockInterruptibly();
                try {
                    NOT_FULL.signalAll();
                } finally {
                    PRODUCER_LOCK.unlock();
                }
            }
        }
    }

    private class ProducerImpl extends AbstractProducer {

        @Override
        public void product() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            int newBufSize = -1;
            PRODUCER_LOCK.lockInterruptibly();
            try {
                while (bufLen.get() == cap) {
                    System.out.println("buffer is full...");
                    NOT_FULL.await();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println(Thread.currentThread().getName() + "-> producer before:" + bufLen.get());
                newBufSize = bufLen.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "-> producer after:" + bufLen.get());
                System.out.println("produce: " + task.getNo());
                if (newBufSize < cap) {
                    NOT_FULL.signalAll();
                }
            } finally {
                PRODUCER_LOCK.unlock();
            }
            if (newBufSize > 0) {
                CONSUMER_LOCK.lockInterruptibly();
                try {
                    NOT_EMPTY.signalAll();
                } finally {
                    CONSUMER_LOCK.unlock();
                }
            }
        }
    }

    /**
     * 需要注意的是，由于需要同时在UnThreadSafe的缓冲区 buffer 上进行消费与生产，
     * 我们不能使用实现二、三中使用的队列了，需要自己实现一个简单的缓冲区
     * Buffer。Buffer要满足以下条件：
     * 在头部出队，尾部入队
     * 在poll()方法中只操作head
     * 在offer()方法中只操作tail
     *
     * @param <E>
     */
    private static class Buffer<E> {
        private Node head;
        private Node tail;

        Buffer() {
            // dummy node
            head = tail = new Node(null);
        }

        public void offer(E e) {
            tail.next = new Node(e);
            tail = tail.next;
        }

        public E poll() {
            head = head.next;
            E e = head.item;
            head.item = null;
            return e;
        }

        private class Node {
            E item;
            Node next;

            Node(E item) {
                this.item = item;
            }
        }
    }

    public static void main(String[] args) {
        IModel model = new LockConditionModel_3_2(3);
        for (int i = 0; i < 2; i++) {
            //   new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}