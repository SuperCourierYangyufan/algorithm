package com.my.栈与队列;

import com.my.数组.Array;


/**
 * Created by YangYuFan on 2018/7/12.
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: size="+array.getSize()+", capacity="+array.getCapacity()+"\n");
        stringBuilder.append("[");
        for (int i = 0; i <array.getSize() ; i++) {
            if (i==array.getSize()-1){
                stringBuilder.append(array.get(i));
                break;
            }
            stringBuilder.append(array.get(i)+"\t");
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
