package dev.namtx.datastructures.listnode;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        ListNode current = this;
        StringBuilder str = new StringBuilder();
        while (current != null) {
            str.append("" + current.val + "->");
            current = current.next;
        }

        return str.toString();
    }
}
