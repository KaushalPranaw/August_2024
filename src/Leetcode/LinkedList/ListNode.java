package Leetcode.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }
    public ListNode(){

    }

    void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
