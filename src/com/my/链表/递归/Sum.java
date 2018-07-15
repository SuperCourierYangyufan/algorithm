package com.my.链表.递归;


/**
 * Created by YangYuFan on 2018/7/13.
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr,int l){
        if(l==arr.length)
            return 0;
        return arr[l]+sum(arr,++l);
    }

    public static void main(String[] args) {
        int[] arr =new int[999];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        int sum = sum(arr);
        System.out.println(sum);
    }
}
