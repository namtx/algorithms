package dev.namtx.leetcode.intersectionoftwolinkedlist;

import dev.namtx.datastructures.listnode.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = ptrA != null ? ptrA.next : headB;
            ptrB = ptrB != null ? ptrB.next : headA;
        }

        return ptrA;
    }
}

class Main {
    public static void main(String[] args) {
        /*
         * 1 - 9 - 1
         *           \
         *            2 - 4 - null
         *           /
         *         3
         */
        ListNode tail = new ListNode(2);
        tail.next = new ListNode(4);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = tail;

        ListNode headB = new ListNode(3);
        headB.next = tail;

        Solution solution = new Solution();
        System.out.println(solution.getIntersectionNode(headB, headB));
    }
}
