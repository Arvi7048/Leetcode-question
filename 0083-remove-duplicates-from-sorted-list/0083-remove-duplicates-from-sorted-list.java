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
    public ListNode deleteDuplicates(ListNode head) {
          if (head == null) {
            return head;
        }
        
        ListNode current = head;
        
        // Traverse the list
        while (current != null && current.next != null) {
            // If the current value is the same as the next value, skip the next node
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Move to the next node if values are different
                current = current.next;
            }
        }
        
        return head;
    }
}