package com.my.栈与队列;

import com.my.数组.Array;

/**
 * Created by YangYuFan on 2018/7/12.
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(){
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: size="+array.getSize()+", capacity="+array.getCapacity()+"\n");
        stringBuilder.append("front [");
        for (int i = 0; i <array.getSize() ; i++) {
            if (i==array.getSize()-1){
                stringBuilder.append(array.get(i));
                break;
            }
            stringBuilder.append(array.get(i)+"\t");
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }
}
