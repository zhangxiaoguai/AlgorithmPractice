package com.company.LeetCode;

public class AddTwoNumbers {

    /**
     * 2.
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     */

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        ListNode result = addTwoNumbers(a1, b1);
        // break point
        System.out.println(result);
    }

    /**
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(max(m,n))
     */
    public static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode headListNode = new ListNode(0);
        ListNode currentListNode = headListNode;
        int carry = 0;
        while (listNode1 != null || listNode2 != null) {
            int x = (listNode1 == null) ? 0 : listNode1.value;
            int y = (listNode2 == null) ? 0 : listNode2.value;
            int sum = carry + x + y;
            carry = sum / 10;
            currentListNode.next = new ListNode(sum % 10);
            currentListNode = currentListNode.next;
            if (listNode1 != null) listNode1 = listNode1.next;
            if (listNode2 != null) listNode2 = listNode2.next;
        }
        if (carry > 0) {
            currentListNode.next = new ListNode(carry);
        }
        return headListNode.next;
    }

    /**
     * Definition for singly-linked list.
     * 单链表的定义
     */
    private static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}


