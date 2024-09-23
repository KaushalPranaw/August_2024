/*
package LinkedList;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    // Function to reverse a linked list
    // using the 3-pointer approach
    static ListNode reverseLinkedList(ListNode head) {
        // Initialize'temp' at
        // head of linked list
        ListNode temp = head;
        // Initialize pointer 'prev' to NULL,
        // representing the previous node
        ListNode prev = null;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
        while (temp != null) {
            // Store the next node in
            // 'front' to preserve the reference
            ListNode front = temp.next;

            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev;

            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;

            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;

        }
        // Return the new head of
        // the reversed linked list
        return prev;

    }

    public ListNode reverseKGroup(ListNode head, int k) {


    }
}
*/
