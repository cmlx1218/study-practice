package com.cmlx.thread.thread01;

/**
 * @Author Administrator
 * @Date -> 2021/6/8 15:04
 * @Desc ->
 **/
public class MianShi01 extends Thread{

    final StringBuffer sb1 = new StringBuffer();
    final StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {
        final MianShi01 h = new MianShi01();
        new Thread() {
            @Override
            public void run() {
                h.sb1.append("A");
                h.sb2.append("B");
                System.out.println(h.sb1);
                System.out.println(h.sb2);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                h.sb1.append("D");
                h.sb2.append("C");
                System.out.println(h.sb2);
                System.out.println(h.sb1);
            }
        }.start();
    }

}
