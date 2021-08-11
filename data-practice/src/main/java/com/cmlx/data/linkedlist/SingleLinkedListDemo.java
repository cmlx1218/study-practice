package com.cmlx.data.linkedlist;

import java.util.LinkedList;

/**
 * @Author CMLX
 * @Date -> 2021/8/11 18:01
 * @Desc -> 手动实现单链表
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "及时雨", "宋江");
        HeroNode heroNode2 = new HeroNode(2, "玉麒麟", "卢俊义");
        HeroNode heroNode3 = new HeroNode(3, "浪里白条", "张顺");
        HeroNode heroNode4 = new HeroNode(4, "豹子头", "林冲");
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        singleLinkedList.list();
        System.out.println("=============================");
        LinkedList<HeroNode> list = new LinkedList<>();
        list.add(heroNode1);
        list.add(heroNode2);
        list.add(heroNode3);
        list.add(heroNode4);
        for (HeroNode heroNode : list) {
            System.out.println(heroNode);
        }
    }
}

class SingleLinkedList {

    // 初始化一个head
    HeroNode head = new HeroNode(0, "", "");

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
        }
        temp.next = data;
        data.next = temp.next.next;
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
    private String name;
    private String nickName;
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
