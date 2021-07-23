package com.example.zkclient.znode;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.util.List;

public class ZkClientCrud<T> {

   ZkClient zkClient;
   private String connectString = "cmlx101:2181,cmlx102:2181,cmlx103:2181";
   public ZkClientCrud() {
      this.zkClient = new ZkClient(connectString,5000,5000,new SerializableSerializer());
   }


   /***
    *
    * @param path
    * @param data
    */
   public void createPersistent(String path,Object data){
      zkClient.createPersistent(path,data);
   }
   public  T readData(String path){
      return zkClient.readData(path);

   }

   public List<String> getChildren(String path){
      return zkClient.getChildren(path);

   }

   public  void writeData(String path,Object object){
      zkClient.writeData(path,object);

   }

   public  void deleteRecursive(String path){
      zkClient.deleteRecursive(path);

   }



   /***
    * 支持创建递归方式
    * @param path
    * @param createParents
    */
   public void createPersistent(String path,boolean createParents){
      zkClient.createPersistent(path,createParents);
   }
}
