package com.indmoney.zookeepersetup.znode;
import java.io.IOException;

import com.indmoney.zookeepersetup.app.Connector;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ReadNode {
    public static void main(String... args) throws InterruptedException, IOException, KeeperException {
        Connector zkConnector = new Connector();
        ZooKeeper connect = zkConnector.connect("localhost");
        //[zk: localhost:2181(CONNECTED) 6] get /SampleNode
        byte[] data = connect.getData("/SampleNode", true, connect.exists("/SampleNode", true));
        for (byte b : data) {
            System.out.print((char) b);
        }
    }
}
