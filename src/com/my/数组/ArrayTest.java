package com.my.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YangYuFan on 2018/7/10.
 */
public class ArrayTest {
    public static void main(String[] args) {
//        AtomicInteger i = new AtomicInteger();
//        int[] a = new int[10];
//        OptionalInt first = Arrays.stream(a).map(e -> e + (i.getAndIncrement())).filter(e -> e > 3).findAny();
//        System.out.println(first.getAsInt());
        Array<Integer> array = new Array(1);
        array.addFirst(1);
        array.addIndex(1,2);
        array.addIndex(2,3);
        array.addLast(4);
        array.addFirst(1);
        System.out.println(array.toString());
        System.out.println(String.format("number is %d %s %d ",1,"and number is",3));
        System.out.println(array.contains(5));
        System.out.println(array.find(2));
        array.remove(2);
        array.remove(1);
        System.out.println(array.toString());
        array.remove(3);
        System.out.println(array.toString());
    }
}
