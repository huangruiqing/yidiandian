package huangruiqing;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName Queue3
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/1/14 15:32
 */
public class Queue3 {

    private Object data = null;//共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get() {
        rwl.readLock().lock();//上读锁，其他线程只能读不能写
        System.out.println(Thread.currentThread().getName() + " be ready to read data!----[read start]");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "have read data :" + data + " ---[read end]");
        rwl.readLock().unlock(); //释放读锁，最好放在finnaly里面
    }

    public void put(Object data) {

        rwl.writeLock().lock();//上写锁，不允许其他线程读也不允许写
        System.out.println(Thread.currentThread().getName() + " be ready to write data!----[write start]");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName() + " have write data: " + data + " ---[write end]");

        rwl.writeLock().unlock();//释放写锁

    }
}
