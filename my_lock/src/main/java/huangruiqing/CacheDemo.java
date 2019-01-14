package huangruiqing;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName CacheDemo
 * @Description // 缓存器
 * @Author huangrq
 * @Date 2019/1/14 15:42
 */
public class CacheDemo {

    private static Map<String, Object> map = new HashMap<String, Object>();//缓存器
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        System.out.println(new CacheDemo().get("1"));
        System.out.println(new CacheDemo().get("2"));
        System.out.println(new CacheDemo().get("1"));
        System.out.println(new CacheDemo().get("2"));
    }
    public Object get(String id){
        Object value = null;
        rwl.readLock().lock();//首先开启读锁，从缓存中去取
        try{
            System.out.println("map:"+map.toString());
            value = map.get(id);
            if(value == null){  //如果缓存中没有释放读锁，上写锁
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if(value == null){
                        System.out.println("get value from datasource");
                        value = "aaa"+id;  //此时可以去数据库中查找，这里简单的模拟一下
                        map.put(id,value);
                    }
                }finally{
                    rwl.writeLock().unlock(); //释放写锁
                }
                rwl.readLock().lock(); //然后再上读锁
            }
        }finally{
            rwl.readLock().unlock(); //最后释放读锁
        }
        return value;
    }

}
