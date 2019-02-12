package huangruiqing;

/**
 * @ClassName DataUpdater
 * @Description // 实现watcher 修改 znode的value
 * @Author huangrq
 * @Date 2018/12/19 15:18
 */

import java.io.IOException;
import java.util.UUID;

import org.apache.zookeeper.*;

public class DataUpdater implements Watcher {
    private static String hostPort = "localhost:2181";
    private static String zooDataPath = "/zktest";
    ZooKeeper zk;

    public DataUpdater() throws IOException {
        try {
            zk = new ZooKeeper(hostPort, 2000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // updates the znode path /MyConfig every 5 seconds with a new UUID string.
    public void run() throws InterruptedException, KeeperException {

        if (zk.exists(zooDataPath, null) == null) {
            zk.create(zooDataPath, "context".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        while (true) {
            String uuid = UUID.randomUUID().toString();
            byte zoo_data[] = uuid.getBytes();
            zk.setData(zooDataPath, zoo_data, -1);
            System.out.println(">>>>>>>> zk set path:" + zooDataPath + ",value byte[]:" + zoo_data);
            try {
                Thread.sleep(5000); // Sleep for 5 secs
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws
            IOException, InterruptedException, KeeperException {
        DataUpdater dataUpdater = new DataUpdater();
        dataUpdater.run();
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.printf("\nEvent Received: %s", event.toString());
    }
}
