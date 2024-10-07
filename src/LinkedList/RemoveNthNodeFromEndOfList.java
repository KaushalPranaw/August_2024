package LinkedList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original list
        System.out.print("Original list: ");
        head.print(head);

        // Create an instance of the class to call the method
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

        // Remove the 2nd node from the end (should remove node with value 4)
        head = solution.removeNthFromEnd(head, 2);

        // Print the modified list
        System.out.print("Modified list after removing 2nd node from end: ");
        head.print(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
