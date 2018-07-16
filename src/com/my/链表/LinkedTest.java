package com.my.链表;

/**
 * Created by YangYuFan on 2018/7/12.
 */
public class LinkedTest {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.addFirst("2");
        stringLinkedList.addFirst("1");
        stringLinkedList.addLast("3");
        stringLinkedList.addIndex("4",3);
        System.out.println(stringLinkedList.toString());
        stringLinkedList.removeElement("3");
        System.out.println(stringLinkedList.toString());

//        LinkedListStack<Integer> linkedListStack = new LinkedListStack();
//        linkedListStack.push(1);
//        linkedListStack.push(2);
//        linkedListStack.push(3);
//        linkedListStack.push(4);
//        System.out.println(linkedListStack.toString());
    }
}
