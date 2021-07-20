package com.indmoney.zookeepersetup.znode;
import java.io.IOException;

import com.indmoney.zookeepersetup.app.Connector;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class DeleteNode {
    public static void main(String... args) throws InterruptedException, IOException, KeeperException {
        String path = "/SampleNode";
        Connector zkConnector = new Connector();
        ZooKeeper connect = zkConnector.connect("localhost");
        connect.delete(path, connect.exists(path, true).getVersion());
        System.out.println("ZNode is deleted : " + path);
    }
}
