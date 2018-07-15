package com.my.集合和映射;

/**
 * Created by YangYuFan on 2018/7/15.
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
