package com.cmlx.data.linkedlist;

/**
 * @Author CMLX
 * @Date -> 2021/8/12 18:18
 * @Desc -> 自己实现双向链表
 **/
public class DoublyLinkedListDemo {

    public static void main(String[] args) {

        HeroNodeDou heroNodeDou1 = new HeroNodeDou(1, "及时雨", "宋江");
        HeroNodeDou heroNodeDou2 = new HeroNodeDou(2, "玉麒麟", "卢俊义");
        HeroNodeDou heroNodeDou3 = new HeroNodeDou(3, "浪里白条", "张顺");
        HeroNodeDou heroNodeDou4 = new HeroNodeDou(4, "豹子头", "林冲");
        HeroNodeDou heroNodeDou5 = new HeroNodeDou(5, "行者", "武松");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(heroNodeDou1);
        doublyLinkedList.add(heroNodeDou2);
        doublyLinkedList.add(heroNodeDou3);
        doublyLinkedList.add(heroNodeDou4);
        doublyLinkedList.add(heroNodeDou5);
        doublyLinkedList.list();
        doublyLinkedList.delete(4);
        System.out.println("删除之后》》》》》》》》");
        doublyLinkedList.list();
        HeroNodeDou heroNodeDou6 = new HeroNodeDou(2, "花和尚", "鲁智深");
        doublyLinkedList.update(heroNodeDou6);
        System.out.println("更新内容之后》》》》》》");
        doublyLinkedList.list();
        System.out.println("查询的结果是》》》》》》》");
        System.out.println(doublyLinkedList.get(3));

    }

}


class DoublyLinkedList {

    // 头节点
    HeroNodeDou head = new HeroNodeDou(0, null, null);

    void add(HeroNodeDou data) {
        HeroNodeDou temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = data;
        data.prep = temp;
    }

    void list() {
        HeroNodeDou temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    void delete(int no) {
        HeroNodeDou temp = head.next;
        while (temp != null) {
            if (temp.no == no) {
                temp.prep.next = temp.next;
                temp.next.prep = temp.prep;
            }
            temp = temp.next;
        }
    }

    void update(HeroNodeDou data) {
        HeroNodeDou temp = head.next;
        while (temp != null) {
            if (temp.no.equals(data.no)) {
                temp.name = data.name;
                temp.nickName = data.nickName;
            }
            temp = temp.next;
        }
    }

    HeroNodeDou get(int no) {
        HeroNodeDou temp = head.next;
        while (temp != null) {
            if (temp.no.equals(no)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


}


class HeroNodeDou {

    public Integer no;
    public HeroNodeDou prep;
    public String name;
    public String nickName;
    public HeroNodeDou next;


    public HeroNodeDou(Integer no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNodeDou{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}