package huangruiqing;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyZKWatcher
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/24 20:09
 */
public class MyZKWatcher implements Watcher ,Runnable{

    /**
     * 定义原子变量
     */
    AtomicInteger seq = new AtomicInteger();
    /**
     * 用于等待zookeeper连接建立之后 通知阻塞程序继续向下执行
     */
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private String hostPath = "127.0.0.1:2181";
    private  String zooPath = "/zktest";
    private ZooKeeper zk = new ZooKeeper(hostPath,2000,this);

    public MyZKWatcher() throws IOException {
        zk = this.getZKInstance();
        try {
            if(zk.exists(zooPath,this) == null){
                zk.create(zooPath,"context".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ZooKeeper getZKInstance () {
        return zk;
    }


    @Override
    public void process(WatchedEvent event) {

        System.out.printf(">>>>>>> zookeeper path :%s ,WatchedEvent : %s \n" ,event.getPath(),event.getType().name());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (event == null) {
            return;
        }

        // 连接状态
        Event.KeeperState keeperState = event.getState();
        // 事件类型
        Event.EventType eventType = event.getType();
        // 受影响的path
        String path = event.getPath();
        //原子对象seq 记录进入process的次数
        String logPrefix = "【Watcher-" + this.seq.incrementAndGet() + "】";

        System.out.println(logPrefix + "收到Watcher通知");
        System.out.println(logPrefix + "连接状态:\t" + keeperState.toString());
        System.out.println(logPrefix + "事件类型:\t" + eventType.toString());

        if (Event.KeeperState.SyncConnected == keeperState) {
            // 成功连接上ZK服务器
            if (Event.EventType.None == eventType) {
                System.out.println(logPrefix + "成功连接上ZK服务器");
                connectedSemaphore.countDown();
            }
            //创建节点
            else if (Event.EventType.NodeCreated == eventType) {
                System.out.println(logPrefix + "节点创建");

            }
            //更新节点
            else if (Event.EventType.NodeDataChanged == eventType) {
                System.out.println(logPrefix + "节点数据更新");
            }
            //更新子节点
            else if (Event.EventType.NodeChildrenChanged == eventType) {
                System.out.println(logPrefix + "子节点变更");
            }
            //删除节点
            else if (Event.EventType.NodeDeleted == eventType) {
                System.out.println(logPrefix + "节点 " + path + " 被删除");
            } else {
                System.out.println(logPrefix + "其他事件：" + eventType);
            }
        } else if (Event.KeeperState.Disconnected == keeperState) {
            System.out.println(logPrefix + "与ZK服务器断开连接");
        } else if (Event.KeeperState.AuthFailed == keeperState) {
            System.out.println(logPrefix + "权限检查失败");
        } else if (Event.KeeperState.Expired == keeperState) {
            System.out.println(logPrefix + "会话失效");
        } else {
            System.out.println(logPrefix + "其他状态：" + keeperState);
        }
    }

    public static void main(String[] args) throws IOException {
        MyZKWatcher myZKWatcher = new MyZKWatcher();
        myZKWatcher.run();
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (true) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
