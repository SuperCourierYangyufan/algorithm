package com.my.链表;

import com.my.栈与队列.Queue;

/**
 * Created by YangYuFan on 2018/7/12.
 */
public class LinkedListQueue<E> implements Queue<E> {
    //头部弹出元素,尾部插入元素
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size = 0;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next; //维护tail,插入元素后改变指针位置
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (head == tail)
            throw new IllegalArgumentException("head==tail");
        Node current = head;
        head = head.next;
        current.next = null;
        if (head == null)
            tail = null;
        size--;
        return current.e;
    }

    @Override
    public E getFront() {
        if (head == tail)
            throw new IllegalArgumentException("head==tail");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("Null tail");
        return res.toString();
    }
}
