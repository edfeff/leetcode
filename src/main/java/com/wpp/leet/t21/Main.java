package com.wpp.leet.t21;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 */
public class Main {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        new Solution().tra(a1);
        new Solution().tra(b1);


        ListNode listNode = new Solution().mergeTwoLists(a1, b1);
        new Solution().tra(listNode);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void tra(ListNode l1) {
        ListNode t = l1;
        while (t != null) {
            System.out.print(t.val + "   ");
            t = t.next;
        }
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        while (l1 != null) {
            heap.add(new ListNode(l1.val));
            l1 = l1.next;
        }

        while (l2 != null) {
            heap.add(new ListNode(l2.val));
            l2 = l2.next;
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (!heap.isEmpty()) {
            temp.next = heap.poll();
            temp = temp.next;
        }
        return head.next;
    }
}