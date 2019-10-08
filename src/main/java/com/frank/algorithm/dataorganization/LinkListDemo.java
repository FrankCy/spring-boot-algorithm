package com.frank.algorithm.dataorganization;

/**
 * 链表是由一个个节点形成的，所以先定义节点类，节点类重要分为两块内容（数据和Next指针）
 * 原文参照：https://www.jianshu.com/p/aa729b805059
 */
public class LinkListDemo {
    /**
     * 定义节点类
     */
    private class ListNode {
        private Object data;
        private ListNode next = null;

        ListNode() {
            data = null;
        }

        ListNode(Object data) {
            this.data = data;
        }
    }

    /**
     * 头节点
     */
    private ListNode head;

    /**
     * 临时节点
     */
    private ListNode temp;


    /**
     * 初始化链表，生成一个无数据的头节点
     */
    LinkListDemo() {
        head = new ListNode();
    }

    /** ============== 下述方法是对链表的操作 ================ **/

    /**
     * 添加节点
     */
    public void addNode(Object object) {
        ListNode node = new ListNode(object);
        temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;

        /**
         * 说明：对于插入节点常用的思想主要有头插法和尾插法，使用尾插法的话需要定义一个尾指针来区分，通过下面代码，对比发现它们的不同：
         *
         * 头插法
         *         if(header == null) {
         *             header = newNode;
         *         } else {
         *             // 将新节点连接到链表头部
         *             newNode.next = header;
         *             // header永远存储第一个节点的地址
         *             header = newNode;
         *         }
         *
         * 尾插法
         *         if(header == null) {
         *             header = tailer = newNode;
         *         } else {
         *             // 将新节点连接到链表的尾部
         *             tailer.next = newNode;
         *             // tailer永远存储最后一个节点的地址
         *             tailer = newNode;
         *         }
         */
    }

    /**
     * 返回链表长度
     * @return
     */
    public int getLength() {
        temp = head;
        int length = 0;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 增加节点到链表指定位置
     * 对于传入index需要先判断是否合法，然后通过while循环的遍历寻找index的位置来进行节点的插入
     * @param index
     * @param data
     */
    public void addNodeByIndex(int index, Object data) {
        if(index < 1 || index > getLength() + 1) {
            System.out.println("插入位置不合法！");
            return;
        }
        // 记录遍历的位置
        int count = 1;
        ListNode node = new ListNode(data);
        temp = head;
        while(temp.next != null) {
            if(index == count++) {
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除指定位置的节点
     * 实现与增加节点到链表位置基本相同，只是增删节点的处理过程不同
     * @param index
     */
    public void deleteByIndex(int index) {
        if(index < 1 || index > getLength()) {
            System.out.println("插入的位置不合法！");
            return;
        }

        // 记录遍历的位置
        int count = 1;
        temp = head;
        while(temp.next != null) {
            if(index == count++) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 从头到尾打印链表的数据
     */
    public void printListFromHead() {
        temp = head;
        while(temp.next != null) {
            System.out.println("{" + temp.next.data + "}");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 从尾到头打印链表数据
     */
    public void printFromTail() {

    }

    public static void main(String[] args)
    {
        LinkListDemo list = new LinkListDemo();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.printListFromHead();
        list.addNodeByIndex(3,2.8);
        list.printListFromHead();
        list.deleteByIndex(3);
        list.printListFromHead();
        list.printFromTail();
        System.out.println(list.getLength());
    }
}
