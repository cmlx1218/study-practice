package com.cmlx.data.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author CMLX
 * @Date -> 2021/8/11 12:04
 * @Desc -> 数组实现环形队列
 **/
public class ArrayCircularQueueDemo {

    public static void main(String[] args) {

        ArrayCircularQueue arrayQueue = new ArrayCircularQueue(5);
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
                        arrayQueue.showArrayCircularQueue();
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

    }
}

class ArrayCircularQueue {

    private int front;  // 环形队列头部位置,与普通队列不同这里初始值赋值0
    private int rear;   // 环形队列尾部位置
    private int maxSize;// 数组最大容量
    private int[] arr;  // 数组数据

    ArrayCircularQueue(int maxSize) {
        front = 0;
        rear = 0;
        this.maxSize = maxSize;
        arr = new int[maxSize + 1];
    }

    boolean isFull() {
        //return (rear + 1) % maxSize == front;
        return (rear + 1) % maxSize == front;
    }

    boolean isEmpty() {
        return rear == front;
    }

    void addQueue(int data) {
        if (isFull()) {
            throw new RuntimeException("队列数据已满");
        }
        arr[rear] = data;
        rear++;
        rear = rear % maxSize;
    }

    int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中无数据");
        }
        int i = arr[front];
        front++;
        front = front % maxSize;
        return i;
    }

    void showArrayCircularQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中无数据");
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
        //for (int i = 0; i < arr.length; i++) {
        //    System.out.printf("arr[%d]=%d\n", i, arr[i]);
        //}
    }

    int size() {
        return (rear + maxSize - front) % maxSize;
    }

    @Override
    public String toString() {
        return "ArrayCircularQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", maxSize=" + maxSize +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中无数据");
        }
        return arr[front];
    }

    // 自己的思路，但是rear和front的意义变了
    //void addQueue(int data) {
    //    if (isFull()) {
    //        throw new RuntimeException("队列数据已满");
    //    }
    //    arr[rear % maxSize] = data;
    //    rear++;
    //}
    //
    //int getQueue() {
    //    if (isEmpty()) {
    //        throw new RuntimeException("队列中无数据");
    //    }
    //    int i = arr[front % maxSize];
    //    front++;
    //    return i;
    //}
    //
    //void showArrayCircularQueue() {
    //    if (isEmpty()) {
    //        throw new RuntimeException("队列中无数据");
    //    }
    //
    //    for (int i = front; i < rear; i++) {
    //        System.out.printf("arr[%d]=%d\n", i, arr[i % maxSize]);
    //    }
    //    //for (int i = 0; i < arr.length; i++) {
    //    //    System.out.printf("arr[%d]=%d\n", i, arr[i]);
    //    //}
    //}
    //
    //int size() {
    //    return (rear + maxSize - front) % maxSize;
    //}
    //
    //@Override
    //public String toString() {
    //    return "ArrayCircularQueue{" +
    //            "front=" + front +
    //            ", rear=" + rear +
    //            ", maxSize=" + maxSize +
    //            ", arr=" + Arrays.toString(arr) +
    //            '}';
    //}
    //
    //public int headQueue() {
    //    if (isEmpty()) {
    //        throw new RuntimeException("队列中无数据");
    //    }
    //    return arr[front % maxSize];
    //}
}
