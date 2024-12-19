package Leetcode.LinkedList;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        // Create a sorted linked list with duplicates: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        // Call the deleteDuplicates method
        RemoveDuplicatesFromSortedListII remover = new RemoveDuplicatesFromSortedListII();
        ListNode resultHead = remover.deleteDuplicates(head);

        // Print the resulting linked list
        resultHead.print(resultHead);

    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        while (head!=null){
            if(head.next!=null && head.val==head.next.val){
                //skip the duplicate elements
                while (head.next!=null && head.val==head.next.val){
                    head=head.next;
                }
                prev.next=head.next;
            }else {
                prev=prev.next;
            }
            head=head.next;
        }
        return dummy.next;


    }
}
