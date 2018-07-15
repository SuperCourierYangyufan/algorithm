package com.my.链表.递归;

/**
 * Created by YangYuFan on 2018/7/13.
 */
public class Solution {
    class ListNode{
        private ListNode next;
        private int num;

        public ListNode(ListNode next, int num) {
            this.next = next;
            this.num = num;
        }
        public ListNode(int num) {
            this(null,num);
        }
    }

    public static ListNode removeElement(ListNode head,int val){
        if(head ==null)
            return null;
        ListNode res = removeElement(head.next, val);
        if(head.num==val)
            return res;
        else{
            head.next = res;
            return head;
        }
    }
}
