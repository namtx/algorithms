package dev.namtx.leetcode.partitionlist;

import dev.namtx.datastructures.listnode.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            if (current.val < x) {
                previous = current;
                current = current.next;
            } else {
                ListNode greater = current;
                while (greater.next != null && greater.next.val >= x) {
                    greater = greater.next;
                }
                if (greater.next == null)
                    return head;

                ListNode smaller = greater.next;
                ListNode tail = smaller.next;
                if (previous == null) {
                    smaller.next = current;
                    greater.next = tail;
                    previous = smaller;
                    head = previous;
                } else {
                    previous.next = smaller;
                    smaller.next = current;
                    greater.next = tail;
                    previous = smaller;
                }
            }
        }

        return head;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode head = new ListNode(2);
        ListNode current = head;
        for (int num: nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        Solution solution = new Solution();
        System.out.println(solution.partition(head, 2));
    }
}
