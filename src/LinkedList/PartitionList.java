package LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3; // Partition around this value

        // Call the partition method
        PartitionList partitionList = new PartitionList();
        ListNode partitionedHead = partitionList.partition(head, x);

        // Print the resulting linked list
        partitionedHead.print(partitionedHead);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode large=new ListNode(0);

        ListNode smallPointer=small;
        ListNode largePointer=large;
        while (head!=null){
            if(head.val<x){
                smallPointer.next=head;
                smallPointer=smallPointer.next;
            }else {
                largePointer.next=head;
                largePointer=largePointer.next;
            }
            head=head.next;
        }
        smallPointer.next=large.next;
        largePointer.next=null;
        return  small.next;

    }
}
