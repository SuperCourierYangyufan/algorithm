package com.my.栈与队列;

/**
 * Created by YangYuFan on 2018/7/12.
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
