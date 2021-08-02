package dev.namtx.leetcode.cyclelinkedlist;

import dev.namtx.datastructures.listnode.ListNode;

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;
            if (fast == null) return false;
            if (slow == fast) return true;
        }

        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 0, -4};
        ListNode head = null;
        ListNode[] nodes = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (head == null) {
                head = new ListNode(nums[i]);
                nodes[i] = head;
            } else {
                head.next = new ListNode(nums[i]);
                nodes[i] = head.next;
                head = head.next;
            }
        }
        nodes[nums.length - 1].next = nodes[1];

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(nodes[0]));
    }
}
