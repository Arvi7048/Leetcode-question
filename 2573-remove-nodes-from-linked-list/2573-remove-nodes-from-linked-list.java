/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
         // Step 1: Reverse the linked list
        ListNode reversedHead = reverseList(head);
        
        // Step 2: Remove nodes that are less than the max seen so far
        ListNode current = reversedHead;
        ListNode newHead = null;
        ListNode tail = null;
        int max = Integer.MIN_VALUE;
        
        while (current != null) {
            if (current.val >= max) {
                // Update the max value
                max = current.val;
                // Add current node to the new list
                if (newHead == null) {
                    newHead = current;
                    tail = current;
                } else {
                    tail.next = current;
                    tail = current;
                }
            }
            current = current.next;
        }
        
        // Terminate the new list properly
        if (tail != null) {
            tail.next = null;
        }
        
        // Step 3: Reverse the list again to restore original order
        return reverseList(newHead);
    }
    
    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}