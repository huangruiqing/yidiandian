package huangruiqing;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @ClassName ZKClientApp
 * @Description //  使用com.101tec zkclient 客户端
 * <dependency>
 * <groupId>com.101tec</groupId>
 * <artifactId>zkclient</artifactId>
 * <version>0.11</version>
 * </dependency>
 * @Author huangrq
 * @Date 2018/12/19 16:47
 */
public class ZKClientApp {

    public static void main(String[] args) {
        String hostPort = "localhost:2181";

        String zpath = "/";
        ZkClient zk = new ZkClient(hostPort, 2000, 30000);

        List<String> znodes = zk.getChildren(zpath);
        for (String zName : znodes) {
            System.out.println("znodeName:" + zName);
        }
        zpath = "/zktest";
        zk.deleteRecursive(zpath);
        System.out.println("Q:'/zktest' is exist ? A:" + zk.exists(zpath));
        if (!zk.exists(zpath)) {
            zk.create(zpath, new DbConfig("mysql", "name", "123456"), CreateMode.PERSISTENT);
        }

        DbConfig dbConfig = zk.readData(zpath, new Stat());

        System.out.println(dbConfig.toString());
    }


}
