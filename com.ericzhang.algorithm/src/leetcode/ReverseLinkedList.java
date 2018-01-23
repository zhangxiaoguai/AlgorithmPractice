package leetcode;

/**
 * @author EricZhang
 * @email ericzhangisworking@gmail.com
 * @date 2018/1/15 下午3:39
 */
public class ReverseLinkedList {

    private static ListNode node1 = new ListNode(1);
    private static ListNode node2 = new ListNode(3);
    private static ListNode node3 = new ListNode(5);
    private static ListNode node4 = new ListNode(7);
    private static ListNode node5 = new ListNode(9);

    /**
     * 206.
     * Reverse a singly linked list.
     * 反转单链表
     */
    public static void main(String[] args) {
        init();
        System.out.println(node1);
        ListNode resultNode1 = recursiveReverse(node1);
        System.out.println(resultNode1);

        init();
        System.out.println(node1);
        ListNode resultNode2 = recursiveReverse2(node1);
        System.out.println(resultNode2);

        init();
        System.out.println(node1);
        ListNode resultNode3 = loopReverse(node1);
        System.out.println(resultNode3);
    }

    private static void init() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
    }

    /**
     * 递归方式，递归是压栈操作
     *
     * @param currentNode 要反转的单链表
     * @return 反转后的单链表
     */
    public static ListNode recursiveReverse(ListNode currentNode) {
        if (currentNode == null || currentNode.next == null)
            return currentNode;
        ListNode nextNode = currentNode.next;
        currentNode.next = null;
        ListNode resultNode = recursiveReverse(nextNode);
        nextNode.next = currentNode;
        return resultNode;
    }

    /**
     * 递归方式2，操作次序不同，其实是一样的
     *
     * @param currentNode 要反转的单链表
     * @return 反转后的单链表
     */
    public static ListNode recursiveReverse2(ListNode currentNode) {
        if (currentNode == null || currentNode.next == null)
            return currentNode;
        ListNode resultNode = recursiveReverse2(currentNode.next);
        ListNode next = currentNode.next;
        currentNode.next = null;
        next.next = currentNode;
        return resultNode;
    }

    /**
     * while循环方式，栈操作来替代递归压栈操作
     *
     * @param currentNode 要反转的单链表
     * @return 反转后的单链表
     */
    public static ListNode loopReverse(ListNode currentNode) {
        ListNode previousNode = null;
        ListNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
