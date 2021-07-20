package com.indmoney.zookeepersetup.znode;

import java.io.IOException;

import com.indmoney.zookeepersetup.app.Connector;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
public class UpdateNode {
    public static void main(String... args) throws InterruptedException, IOException, KeeperException {
        String path = "/SampleNode";
        Connector zkConnector = new Connector();
        ZooKeeper connect = zkConnector.connect("localhost");
        //[zk: localhost:2181(CONNECTED) 6] get /SampleNode
        byte[] data = connect.getData(path, true, connect.exists(path, true));
        System.out.print("Existing Data: ");
        for (byte b : data) {
            System.out.print((char) b);
        }
        connect.setData(path, "Searching On Lucene w/Replication".getBytes(), connect.exists(path, true).getVersion());

        data = connect.getData(path, true, connect.exists(path, true));
        System.out.println();
        System.out.print("Updated Data: ");
        for (byte b : data) {
            System.out.print((char) b);
        }
    }
}
