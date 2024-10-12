package LinkedList;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2; // Starting position for reversal
        int right = 4; // Ending position for reversal

        // Call the reverseBetween method
        ReverseLinkedListII reverser = new ReverseLinkedListII();
        ListNode resultHead = reverser.reverseBetween(head, left, right);

        // Print the resulting linked list
        resultHead.print(resultHead);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        for(int i=1;i<left;i++){
            prev=prev.next;
        }
        ListNode cur=prev.next;
        for(int i=0;i<(right-left);i++){
            ListNode temp=prev.next;
            prev.next=cur.next;
            cur.next=cur.next.next;
            prev.next.next=temp;
        }
        return dummy.next;

    }
}
