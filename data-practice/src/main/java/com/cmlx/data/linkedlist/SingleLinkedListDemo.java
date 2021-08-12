package com.cmlx.data.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author CMLX
 * @Date -> 2021/8/11 18:01
 * @Desc -> 手动实现单链表
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //HeroNode heroNode1 = new HeroNode(1, "及时雨", "宋江");
        //HeroNode heroNode2 = new HeroNode(2, "玉麒麟", "卢俊义");
        //HeroNode heroNode3 = new HeroNode(3, "浪里白条", "张顺");
        //HeroNode heroNode4 = new HeroNode(4, "豹子头", "林冲");
        //singleLinkedList.add(heroNode1);
        //singleLinkedList.add(heroNode2);
        //singleLinkedList.add(heroNode3);
        //singleLinkedList.add(heroNode4);
        //singleLinkedList.list();
        //System.out.println("=============================");
        //LinkedList<HeroNode> list = new LinkedList<>();
        //list.add(heroNode1);
        //list.add(heroNode2);
        //list.add(heroNode3);
        //list.add(heroNode4);
        //for (HeroNode heroNode : list) {
        //    System.out.println(heroNode);
        //}

        HeroNode heroNode3 = new HeroNode(3, "及时雨", "宋江");
        HeroNode heroNode2 = new HeroNode(2, "及时雨", "宋江");
        HeroNode heroNode5 = new HeroNode(5, "及时雨", "宋江");
        HeroNode heroNode4 = new HeroNode(4, "及时雨", "宋江");
        HeroNode heroNode1 = new HeroNode(1, "及时雨", "宋江");
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode5);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.list();
        HeroNode heroNode6 = new HeroNode(2, "浪里白条", "张顺");
        singleLinkedList.update(heroNode6);
        System.out.println("==========更新后=========");
        singleLinkedList.list();
        singleLinkedList.delete(heroNode6);
        System.out.println("==========删除后=========");
        singleLinkedList.list();

        System.out.println("求单链表中有效节点的个数>>>>>>>>>>>>>>>>>>>>>>>>");
        int nodeCount = getNodeCount(singleLinkedList.getHead());
        System.out.println("单链表中有效的节点数是：" + nodeCount);

        System.out.println("查找单链表中倒数第K个节点");
        HeroNode heroNode = getNodeByReverseCount(singleLinkedList.getHead(), 3);
        if (heroNode != null) {
            System.out.println("单链表中有效的节点数是：" + heroNode);
        }


        System.out.println("单链表的翻转>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        reverseLinkedList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("逆序打印单链表>>>>>>>>>>>>>>>>>>>>>>>>>>");
        // 方式一、链表倒序之后在打印，但是会破坏链表之前的结构
        // 方式二、用栈
        reverseLinkedListByStack(singleLinkedList.getHead());


    }

    private static void reverseLinkedListByStack(HeroNode head) {
        if (head.next == null) {
            System.out.println("当前链表没有数据，不能进行修改操作哦~");
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    private static void reverseLinkedList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode newHead = new HeroNode(0, null, null);
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        head.next = newHead.next;
        // 自己的思路行不通
        //if (head.next == null) {
        //    System.out.println("链表为空，不能翻转");
        //}
        //
        //HeroNode temp1 = head.next;
        //HeroNode temp = null;
        //int count = 1;
        //while (temp1.next != null) {
        //    count++;
        //    temp = temp1.next;
        //    temp1 = temp1.next;
        //}
        //HeroNode temp2 = head.next;
        //HeroNode temp3 = head.next;
        //while (count > 0) {
        //    //if (temp2.next.equals(temp1)) {
        //    //    temp1.next = temp2;
        //    //    temp1 = temp2;
        //    //    count--;
        //    //    temp2 = head.next;
        //    //}
        //    //temp2 = temp2.next;
        //    while (temp2.next == null) {
        //        temp3.next = temp2;
        //        count--;
        //    }
        //}
        //head.next = temp;
    }

    private static HeroNode getNodeByReverseCount(HeroNode head, int i) {
        // 遍历单链表查总数
        HeroNode temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        int index = count - i + 1;
        if (index < 0) {
            System.out.println("该数据不存在");
            return null;
        }
        temp = head;
        count = 0;
        boolean flag = false;
        while (temp.next != null) {
            if (count == index) {
                flag = true;
                break;
            }
            count++;
            temp = temp.next;
        }
        if (flag) {
            return temp;
        }
        return null;
    }

    private static int getNodeCount(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 1;
        HeroNode temp = head.next;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;

    }
}

class SingleLinkedList {

    // 初始化一个head
    HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode data) {

        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = data;
    }

    public void addByOrder(HeroNode data) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > data.no) {
                break;
            }
            if (temp.next.no.equals(data.no)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("当前插入位置有数据");
        } else {
            data.next = temp.next;
            temp.next = data;
        }
    }

    public void update(HeroNode data) {
        if (head.next == null) {
            System.out.println("当前链表没有数据，不能进行修改操作哦~");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no.equals(data.no)) {
                data.next = temp.next.next;
                temp.next = data;
                break;
            }
            //if (temp.no.equals(data.no)) {
            //    temp.name = data.name;
            //    temp.nickName = data.nickName;
            //    break;
            //}
            temp = temp.next;
        }
    }

    public void delete(HeroNode data) {
        if (head.next == null) {
            System.out.println("当前链表没有数据，不能进行修改操作哦~");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no.equals(data.no)) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }


    public void list() {
        if (head.next == null) {
            System.out.println("链表中没有数据");
        }
        HeroNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}

class HeroNode {

    public Integer no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(Integer no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
