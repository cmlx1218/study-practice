package com.example.zookeeper;

import com.example.zkclient.watcher.ZkClientWatcher;
import com.example.zookeeper.watcher.ZookeeperWatcher;
import org.apache.zookeeper.KeeperException;

/**
 * @Author CMLX
 * @Date -> 2021/7/23 10:55
 * @Desc ->
 **/
public class ZookeeperCrudTest {

    public static void main(String[] args) throws InterruptedException, KeeperException {
        //ZookeeperCrud zookeeperCrud = new ZookeeperCrud();
        //System.out.println(zookeeperCrud);
        ////zookeeperCrud.createPersistent("/cmlx","this is a beauty girl");
        //zookeeperCrud.createEphemeral("/cqsz","this ia a tokyo girl");

        ZookeeperWatcher zookeeperWatcher = new ZookeeperWatcher();
        zookeeperWatcher.createPersistent("/zmm","you are my first lady!");
        zookeeperWatcher.delete("/ccc");
        zookeeperWatcher.deleteRecursive("/zm");
        zookeeperWatcher.exists("/zmm", true);
        Thread.sleep(Long.MAX_VALUE);


    }

}
