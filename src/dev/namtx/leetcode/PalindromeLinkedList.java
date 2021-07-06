package dev.namtx.leetcode;

//class Main {
//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 1};
//        ListNode l = new ListNode();
//        l.val = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//
//            ListNode temp = new ListNode();
//            temp.val = arr[i];
//
//            ListNode ptr = l;
//            while (ptr.next != null) {
//                ptr = ptr.next;
//            }
//            ptr.next = temp;
//        }
//
//        PalindromeLinkedList palindromeList = new PalindromeLinkedList();
//        System.out.println(palindromeList.isPalindrome(l));
//    }
//}

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;

        if (head.next == null) {
            return true;
        }

        while (fast != null && fast.next != null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while(!s.isEmpty()) { // even number of nodes
            int top = s.pop();
            if (top != slow.val) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }
}
