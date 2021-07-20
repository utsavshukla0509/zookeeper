package com.indmoney.zookeepersetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

import com.indmoney.zookeepersetup.app.ZKConnector;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;


@SpringBootApplication
public class ZookeeperSetupApplication {

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		SpringApplication.run(ZookeeperSetupApplication.class, args);
		ZKConnector zkConnector = new ZKConnector();
		ZooKeeper connect = zkConnector.connect("localhost");
		List<ACL> acl = connect.getACL("/SampleNode", connect.exists("/SampleNode", true));
	
		for (ACL aclItem : acl) {
			System.out.println(aclItem.toString());
		}
	}

}

