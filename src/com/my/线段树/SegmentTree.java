package com.my.线段树;

/**
 * Created by YangYuFan on 2018/7/24.
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rigthChild(treeIndex);
        int mid = (left + right) / 2;
        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rigthChild(int index) {
        return 2 * index + 2;
    }


    public E query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryRight >= data.length || queryLeft > queryRight)
            throw new IllegalArgumentException("index is illegal");
        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    private E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight)
            return tree[treeIndex];

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rigthChild(treeIndex);
        int mid = (left + right) / 2;
        if (queryLeft > mid)
            return query(rightTreeIndex, mid + 1, right, queryLeft, queryRight);
        else if (queryRight <= mid)
            return query(leftTreeIndex, left, mid, queryLeft, queryRight);
        E leftResult = query(leftTreeIndex, left, mid, queryLeft, mid);
        E rightResult = query(rightTreeIndex, mid + 1, right, mid + 1, queryRight);
        return merger.merge(leftResult, rightResult);
    }

    public void update(int index,E e){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        data[index] = e;
        update(0,0,data.length-1,index,e);
    }

    private void update(int treeIndex,int left,int right,int index,E e){
        if(left==right){
            tree[treeIndex] =e;
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rigthChild(treeIndex);
        int mid = (left + right) / 2;
        if(index>=mid+1)
            update(rightTreeIndex,mid+1,right,index,e);
        else
            update(leftTreeIndex,left,mid,index,e);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }
}
