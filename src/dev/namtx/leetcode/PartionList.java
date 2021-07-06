package dev.namtx.leetcode;

class PartionListSolution {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1,1};
        ListNode l = new ListNode();
        l.val = arr[0];
        for (int i = 1; i < arr.length; i++) {

            ListNode temp = new ListNode();
            temp.val = arr[i];

            ListNode ptr = l;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }

        PartionList list = new PartionList();
        ListNode head = list.partition(l, 2);
        System.out.println(head);
    }
}

class PartionList {
    public ListNode partition(ListNode head, int x) {
        ListNode current = head;
        ListNode bigger = null;
        ListNode smaller = null;

        while (current != null) {
            if (bigger == null) {
                if (current.val < x) {
                    smaller = current;
                    current = current.next;
                } else {
                    bigger = current;
                    current = current.next;
                }
            } else {
                if (current.val >= x) {
                    current = current.next;
                } else {
                    ListNode temp = current.next;
                    if (smaller == null) {
                        smaller = current;
                        if (current.next == null) { // smallest in the right most
                            current.next = bigger;
                            ListNode temp2 = bigger;
                            while (temp2.next.val >= x) {
                                temp2 = temp2.next;
                            }
                            temp2.next = null;

                            return current;
                        } else {
                            current = current.next;
                        }
                    } else {
                        smaller.next = current;
                        current.next = bigger;
                        ListNode temp2 = bigger;
                        while (temp2.next.val >= x) {
                            temp2 = temp2.next;
                        }
                        temp2.next = temp;
                        smaller = current;
                        current = temp;
                    }
                }
            }
        }

        return head;
    }
}
