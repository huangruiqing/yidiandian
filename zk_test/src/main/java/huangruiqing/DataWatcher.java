package huangruiqing;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @ClassName DataWatcher
 * @Description // 实现 Watcher接口  监听到节点值的变化
 * @Author huangrq
 * @Date 2018/12/19 15:14
 */
public class DataWatcher implements Watcher, Runnable {
    private static String hostPort = "localhost:2181";
    private static String zooDataPath = "/zktest";
    byte zoo_data[] = null;
    ZooKeeper zk;


    public DataWatcher() {
        try {
            zk = new ZooKeeper(hostPort, 2000, this);
            if (zk != null) {
                try {
                    //Create the znode if it doesn't exist, with the following code:
                    if (zk.exists(zooDataPath, this) == null) {
                       String res = zk.create(zooDataPath, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                        System.out.println(">>>>>>不存在 /zktest 新增一个/zktest");
                    }
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printData() throws InterruptedException, KeeperException {
        zoo_data = zk.getData(zooDataPath, this, null);
        String zString = new String(zoo_data);
        // The following code prints the current content of the znode to the console:
        System.out.printf("\nCurrent Data @ ZK Path %s: %s", zooDataPath, "update>>>value:["+zString+"]");
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.printf(
                "\nEvent Received: %s", event.toString());
        //We will process only events of type NodeDataChanged
        if (event.getType() == Event.EventType.NodeDataChanged) {
            try {
                printData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
            throws InterruptedException, KeeperException {
        DataWatcher dataWatcher = new DataWatcher();
        dataWatcher.printData();
        dataWatcher.run();
    }
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
