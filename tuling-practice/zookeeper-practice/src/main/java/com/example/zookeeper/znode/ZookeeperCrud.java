package com.example.zookeeper.znode;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Author CMLX
 * @Date -> 2021/7/23 10:53
 * @Desc ->
 **/
public class ZookeeperCrud {

    private String connectString = "cmlx101:2181,cmlx102:2181,cmlx103:2181";

    private ZooKeeper zooKeeper;

    public ZookeeperCrud() {
        try {
            // 没有设置watcher，所以空指针
            zooKeeper = new ZooKeeper(connectString, 5000, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String createPersistent(String path,String data) {
        try {
            return zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String createEphemeral(String path,String data) {
        try {
            return zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
