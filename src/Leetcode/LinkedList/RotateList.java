package Leetcode.LinkedList;

public class RotateList {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // Number of positions to rotate

        RotateList rotator = new RotateList();
        ListNode newHead = rotator.rotateRight(head, k);

        // Print the rotated list
        newHead.print(newHead);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur.next = head;
        k = k % len;
        int stepToNewHead = len - k;
        ListNode newTail = head;
        for (int i = 1; i < stepToNewHead; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
