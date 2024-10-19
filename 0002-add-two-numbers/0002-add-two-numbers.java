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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummy = new ListNode(0); // Dummy node to hold the result list
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            // Get the current values, if a list has ended, use 0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Calculate the sum and the new carry
            int total = val1 + val2 + carry;
            carry = total / 10;
            int newVal = total % 10;
            
            // Create a new node with the computed value and move the pointer
            current.next = new ListNode(newVal);
            current = current.next;
            
            // Move to the next nodes of l1 and l2 if possible
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}