package com.my.数组;

import java.util.Arrays;
/**
 * Created by YangYuFan on 2018/7/10.
 */
public class Array<T> {
    private T[] data;
    private int size;


    // 传入数组容量的构造函数
    public Array(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }
    //当没有传入时调用重构的构造方法,初始为10
    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(T e){
//        if (size == data.length)
//            throw new IllegalArgumentException("addLast throw exception because size equal data.size");
//        data[size++] = e;
        addIndex(size,e);
    }

    public void addIndex(int index,T e){
        if(index<0 || index > size){
            throw new IllegalArgumentException("addLast throw exception because index<0 || index > size");
        }
        resize();
        for (int i = size-1; i >=size ; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(T e){
        if(size==0){
            addIndex(0,e);
        }else{
            resize();
            for (int i = size-1; i >=size ; i--) {
                data[i+1] = data[i];
            }
            data[0] = e;
        }
    }
    public void add(T e){
        resize();
        data[size] = e;
        size++;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array: size="+size+", capacity="+data.length+"\n");
        stringBuilder.append("[");
        Arrays.stream(data).forEach(e->stringBuilder.append(e+"\t"));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public T get(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("get throw exception because index<0 || index >= size");
        return data[index];
    }

    public T getLast(){
        return get(size-1);
    }

    public T getFirst(){
        return get(0);
    }

    public void set(int index,T e){
        if(index<0||index>=size)
            throw new IllegalArgumentException("get throw exception because index<0 || index >= size");
        resize();
        data[index]=e;
    }

    public boolean contains(T e){
       for (int i=0;i<size;i++){
           if (e.equals(data[i]))
               return true;
       }
       return false;
    }

    public int find(T e){
        for(int i=0;i<size;i++){
            if (e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public void remove(T e){
        int i = find(e);
        if (i==-1)
            throw new IllegalArgumentException("remove throw exception because no number "+e);
        for (int j = i; j <size ; j++) {
            data[j]=data[j+1];
        }
        size--;
        data[size]=null;
        resize();
    }

    public T removeIndex(int index){
        T number = data[index];
        if(index<0||index>=size)
            throw new IllegalArgumentException("removeIndex throw exception because index<0 || index >= size");
        for (int j = index; j <size ; j++) {
            data[j]=data[j+1];
        }
        size--;
        resize();
        return number;
    }

    public T removeFirst(){
        return removeIndex(0);
    }

    public T removeLast(){
        return removeIndex(size-1);
    }

    public void resize(){
        if(size>=data.length){
            T[] array = (T[]) new Object[data.length*2];
            for (int i = 0; i <size ; i++) {
                array[i]=data[i];
            }
            data=array;
        }else if (size==data.length/4&&data.length/2!=0){
            T[] array = (T[]) new Object[data.length/2];
            for (int i = 0; i <size ; i++) {
                array[i]=data[i];
            }
            data=array;
        }
    }
}
