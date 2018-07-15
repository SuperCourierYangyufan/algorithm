package com.my.链表;

/**
 * Created by YangYuFan on 2018/7/12.
 */
public class LinkedList<E> {
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

    private Node head;
    private int size;

    public LinkedList() {
        head = new Node(); //设置虚拟头结点
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        head = new Node(e,head);
//        size++;
        addIndex(e, 0);
    }

    public void addIndex(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index<0||index>size");
        }
//        if(index==0){
//            addFirst(e);
//            return;
//        }
        Node front = head;
        for (int i = 0; i < index; i++) {
            front = front.next;
        }
        front.next = new Node(e, front.next);
        size++;
    }

    public void addLast(E e) {
        addIndex(e, size);
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index<0||index>size");
        Node current = head;
        for (int i = 0; i < index + 1; i++)
            current = current.next;
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index<0||index>size");
        Node current = head;
        for (int i = 0; i < index + 1; i++)
            current = current.next;
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (current.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        while (current.next != null) {
            current = current.next;
            stringBuilder.append(current.e + "->");
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index<0||index>size");
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next; //删除前结点的指针
        current = current.next; //到删除的节点
//        current.next = null; //将删除节点的指针删除
        E deleteDate = current.e;
        current = null; //删除节点
        size--;
        return deleteDate;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


}
