package com.my.优先队列和堆;

import com.my.数组.Array;

/**
 * Created by YangYuFan on 2018/7/22.
 */
public class MaxHeep<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeep(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeep() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //父亲节点
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index==0");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }


    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            i = parent(i); //进行下一次比较
        }
    }

    public E findMax(){
        if(data.isEmpty())
            throw new IllegalArgumentException("empty");
        return data.get(0);
    }

    public E get(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int i) {
        while(leftChild(i)<data.getSize()){
            int j = leftChild(i);
            if(j+1<data.getSize() && data.get(j+1).compareTo(data.get(j))>0)
                j = rightChild(i);
            if(data.get(i).compareTo(data.get(j))>=0)
                break;
            data.swap(i,j);
            i = j;
        }
    }
}
