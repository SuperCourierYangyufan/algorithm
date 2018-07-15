package com.my.栈与队列;


/**
 * Created by YangYuFan on 2018/7/12.
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1]; //会浪费一个单位 front==tail 队列为空
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length-1;//会浪费一个单位 front==tail 队列为空
    }


    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front) //队列满值
            resize(getCapacity()*2);
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("is Empty");
        E ret = data[front];
        data[front] = null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4&&getCapacity()/2!=0)
            resize(getCapacity()/2);
        return ret;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i = 0; i <size ; i++) {
            newData[i] = data[(i+front)%data.length]; //重新排位
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: size="+size+", capacity="+(data.length-1)+"\n");
        stringBuilder.append("front[");
        for (int i = front; i !=tail ; i=(i+1)%data.length) {
            if(((i+1)%data.length)==tail){
                stringBuilder.append(data[i]);
                break;
            }
            stringBuilder.append(data[i]+"\t");
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }
}
