package com.example.zkclient;


import com.example.zkclient.watcher.ZkClientWatcher;
import com.example.zkclient.znode.ZkClientCrud;

public class ZkclientTest {
   public static void main(String[] args) throws InterruptedException {

      // 可存储对象文件等，只需要转换为byte[]就行
      //ZkClientCrud zkClientCrud=new ZkClientCrud();
      //zkClientCrud.createPersistent("/wukong/a/b","abc");
      //System.out.println(zkClientCrud.readData("/wukong/a/b"));;
      //User user=new User();
      //user.setAge(18);
      //user.setName("wukong");
      //zkClientCrud.createPersistent("/abc",user);
      //System.out.println(zkClientCrud.readData("/abc"));

      /****
       * 由于zkClient创建连接的时候指定了默认的序列化类-new SerializableSerializer(),
       * 所以存储在节点上的值也是序列化后的字节数组，当使用zkCli.sh在控制台set /xxx/xx的值时，
       * 存储的是普通的字符串字节数组。所以当set值时虽然触发了值改变事件，但zkClient无法反序列化这个值。
       * 1、在我们ZkClientWatcher这个类中是加了序列化的（org.I0Itec.zkclient.ZkClient#ZkClient(org.I0Itec.zkclient.IZkConnection, int, org.I0Itec.zkclient.serialize.ZkSerializer)
       * 在zkCli.sh 并没有 然后我为了验证 我在zkCli.sh 删除节点和增加节点都可以
       * 感应到事件
       *
       *
       */
      ZkClientWatcher zkClientWatcher=new ZkClientWatcher();
      String path="/mmm";
      zkClientWatcher.deleteRecursive(path);
      zkClientWatcher.lister(path);
      zkClientWatcher.createPersistent(path,"123");
      Thread.sleep(2000);
      zkClientWatcher.writeData(path,"abc");
      Thread.sleep(Integer.MAX_VALUE);


   }
}
