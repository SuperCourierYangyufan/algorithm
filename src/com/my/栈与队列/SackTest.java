package com.my.栈与队列;


/**
 * Created by YangYuFan on 2018/7/12.
 */
public class SackTest {
    public static void main(String[] args) {
//        ArrayStack<String> arrayStack = new ArrayStack();
//        arrayStack.push("a");
//        arrayStack.push("b");
//        arrayStack.push("c");
//        System.out.println(arrayStack.toString());
//        System.out.println(arrayStack.toString());

        System.out.println("------------------------------------------------------");

        LoopQueue<String> arrayQueue = new LoopQueue<>(2);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
        arrayQueue.enqueue("6");
        System.out.println(arrayQueue.toString());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.toString());
    }

}
