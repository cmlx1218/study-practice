package com.example.zookeeper.acl;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @Author CMLX
 * @Date -> 2021/7/23 16:59
 * @Desc ->
 **/
public class ZookeeperAcl {

    private String connectString = "cmlx101:2181,cmlx102:2181,cmlx103:2181";

    private ZooKeeper zooKeeper;

    /** 认证类型 */
    final static String scheme = "digest";
    final static String auth="111";//这个就是用户名

    /****
     * 区分下auth和非auth 需要登录
     */
    public ZookeeperAcl(boolean acl) {
        try {
            this.zooKeeper = new ZooKeeper(connectString,5000,null);
            zooKeeper.addAuthInfo(scheme,auth.getBytes());//这行代码
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /***
     * No权限认证的
     * @param
     */
    public ZookeeperAcl() {
        try {
            this.zooKeeper = new ZooKeeper(connectString, 5000, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 创建持久节点
     * @param path
     * @param data
     * @return
     */
    public String createPersistent(String path, String data) {
        try {
            return zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 创建持久节点
     * @param path
     * @param data
     * @return
     */
    public String createPersistentAcl(String path, String data) {
        try {
            return zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    /***
     * 创建临时节点
     * @param path
     * @param data
     * @return
     */
    public String createEphemeral(String path, String data) {
        try {
            return zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 更新信息
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String getData(String path) throws KeeperException, InterruptedException {
        byte data[] = zooKeeper.getData(path, false, null);
        data = (data == null) ? "null".getBytes() : data;
        return new String(data);
    }


    /***
     * 更新信息
     * @param path
     * @param data
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Stat setData(String path, String data) throws KeeperException, InterruptedException {
        return zooKeeper.setData(path, data.getBytes(), -1);
    }

    /***
     * 是否存在
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Stat exists(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, false);

    }


    /***
     * 删除
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void delete(String path) throws KeeperException, InterruptedException {
        zooKeeper.delete(path, -1);
    }

    /***
     * 删除
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void deleteRecursive(String path) throws KeeperException, InterruptedException {
        ZKUtil.deleteRecursive(zooKeeper, path);
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}
