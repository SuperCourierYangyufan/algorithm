package com.my.栈与队列;

/**
 * Created by YangYuFan on 2018/7/12.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
