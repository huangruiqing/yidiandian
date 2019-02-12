package huangruiqing;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String hostPort = "localhost:2181";
        String zpath = "/";
        List<String> zooChildren = new ArrayList<String>();

        ZooKeeper zk = new ZooKeeper(hostPort, 2000, null);
        if (zk != null) {
            //   String res =  zk.create("/zktest/02","zktest_context02".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            //   Stat stat = new Stat();
            zk.setData("/zktest", UUID.randomUUID().toString().getBytes(), -1);
            //  zk.setData("/zktest",String.valueOf(new DbConfig("orcale","dbName01","pwd")).getBytes(),-1);
            //    byte[] data =  zk.getData("/zktest/02",true,stat);
            //        System.out.println("data:"+new String(data).toString());
            try {
                zooChildren = zk.getChildren(zpath, false);
                System.out.println("Znodes of '/': ");
                for (String child : zooChildren) {
                    //print the children
                    System.out.println(child);
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
