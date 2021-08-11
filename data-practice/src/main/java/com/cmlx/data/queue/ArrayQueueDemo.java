package com.cmlx.data.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author CMLX
 * @Date -> 2021/8/11 10:48
 * @Desc -> 数组实现队列
 **/
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(10);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：获取队列数据");
            System.out.println("h(head)：获取队列头数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("d(detail)：数组队列详情");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        arrayQueue.showArrayQueue();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 'a':
                    int data = scanner.nextInt();
                    try {
                        arrayQueue.addQueue(data);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println("输出的队列数据是：" + queue);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = arrayQueue.headQueue();
                        System.out.println("头部队列数据是：" + i);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                case 'd':
                    String s = arrayQueue.toString();
                    System.out.println(s);
                    break;
                default:
                    System.err.println("无效的指令~");
                    break;
            }
        }
        System.out.println("退出队列成功");

    }

}

class ArrayQueue {
    private int front;  // 队列头
    private int rear;   // 队列尾
    private int maxSize;// 数组最大容量
    private int[] arr;  // 存放数组数据，模拟队列

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", maxSize=" + maxSize +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    public ArrayQueue(int maxSize) {
        front = -1;
        rear = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    boolean isFull() {
        return rear == maxSize - 1;
    }

    boolean isEmpty() {
        return rear == front;
    }

    void addQueue(int data) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能再添加数据");
        }
        rear++;
        arr[rear] = data;
    }

    int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经没数据了");
        }
        front++;
        return arr[front];
    }

    void showArrayQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经没数据了");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经没数据了");
        }
        return arr[front + 1];
    }

}
