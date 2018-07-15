package com.my.二分搜索树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by YangYuFan on 2018/7/14.
 */
public class BST<E extends Comparable<E>> { //具有可比较性
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else
//            add(root, e);
        root = add(root, e);

    }

    private Node add(Node node, E e) {
//        if (e.equals(node.e))
//            return;
//        else if (e.compareTo(node.e) < 0) {
//            if (node.left == null) {
//                node.left = new Node(e);
//                size++;
//                return;
//            } else
//                add(node.left, e);
//        } else if (e.compareTo(node.e) > 0) {
//            if (node.right == null) {
//                node.right = new Node(e);
//                size++;
//                return;
//            } else
//                add(node.right, e);
//        }
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        preOrder(node.left);
        System.out.println(node.e); //当前节点在之前为前序,中间这里为中序列,放在最后为后续
        preOrder(node.right);
    }

    public void preOrderNR() { //非递归实现
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right); //先右节点压入栈
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    //层序队列
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }

    public E minimum(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left==null)
            return node;
        return minimum(node.left);
    }

    public E maximum(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if(node.right==null)
            return node;
        return maximum(node.right);
    }

    public E removeMin(){
        E ret = minimum();
        removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if(node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removemax(){
        E ret = minimum();
        removemax(root);
        return ret;
    }

    private Node removemax(Node node) {
        if(node.right==null){
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }
        node.right = removemax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node==null)
            return null;
        if(e.compareTo(node.e)<0) {
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else{
            if(node.left==null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //左右子数都不为空
            Node successor = minimum(node.right); //找到删除节点的右子树的最小值
            /*
                删除上一步找到的右子树的最小值的节点
                并将该节点的右子树(比该节点大)添加到上一层中的左子树中去
                返回刚刚传入的节点
                令他为新的节点的左子树
             */
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left= node.right=null;
            return successor;
        }

    }


}
