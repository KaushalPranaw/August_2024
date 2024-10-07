package LinkedList;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null){
            return false;
        }

        ListNode slow=head, fast=head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Create a linked list
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        // Connect nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create a cycle by pointing the last node to one of the previous nodes
        fifth.next = third; // Creates a cycle

        LinkedListCycle listCycle = new LinkedListCycle();

        // Check if the linked list has a cycle
        boolean hasCycle = listCycle.hasCycle(head);

        if (hasCycle) {
            System.out.println("The linked list has a cycle.");
        } else {
            System.out.println("The linked list does not have a cycle.");
        }
    }
}
