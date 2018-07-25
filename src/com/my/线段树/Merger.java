package com.my.线段树;

/**
 * Created by YangYuFan on 2018/7/25.
 */
public interface Merger<E> {
    E merge(E a,E b);
}
