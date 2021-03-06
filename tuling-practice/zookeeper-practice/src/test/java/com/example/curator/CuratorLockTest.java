package com.example.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorLockTest implements  Runnable{

    final  static CuratorFramework client= CuratorFrameworkFactory.builder().connectString("cmlx101:2181,cmlx102:2181,cmlx103:2181").retryPolicy(new ExponentialBackoffRetry(100,1)).build();
     static int i=0;
    final InterProcessMutex lock=new InterProcessMutex(client,"/lock");


    public static void main(String[] args) throws InterruptedException {
        client.start();
        CuratorLockTest lockTest2=new CuratorLockTest();
        Thread t1= new Thread(lockTest2);
        Thread t2=  new Thread(lockTest2);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);

    }

        @Override
        public void run() {
            try {
                for(int j=0;j<300;j++){
                    lock.acquire();

                    i++;
                    lock.release();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


    }
}
