package com.my.二分搜索树;

/**
 * Created by YangYuFan on 2018/7/14.
 */
public class BST_Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(10);
        bst.add(3);
        bst.add(11);
        bst.add(1);
        bst.add(6);
        bst.add(13);
        bst.levelOrder();
        System.out.println("----------------------------------");
        /*
              10
            /    \
           3      11
          / \    / \
         1   6  NULL 13
         */
//        bst.removemax();
//        bst.preOrderNR();
//        System.out.println("----------------------------------");
//        bst.removeMin();
//        bst.preOrder();
        bst.remove(3);
        bst.levelOrder();

    }
}
