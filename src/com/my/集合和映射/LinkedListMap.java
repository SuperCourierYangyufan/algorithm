package com.my.集合和映射;


/**
 * Created by YangYuFan on 2018/7/16.
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListMap() {
        head = new Node();
        size = 0;
    }

    private Node getNode(K key){
        Node cur = head.next;
        while(cur!=null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node==null) {
            head.next = new Node(key, value, head.next);
            size++;
        }else
            node.value = value;
    }

    @Override
    public V remove(K key) {
        Node prev = head;
        while (head.next!=null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }
        if(prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node==null)
            throw new IllegalArgumentException(key+"doesn`t exist!");
        node.value=value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
