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
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null || k == 1) {
            return head; // Edge case: if k is 1 or head is null, no change is needed
        }

        // Dummy node to simplify reversal handling at the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        // Count the number of nodes in the list
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Traverse the list and reverse every group of k nodes
        current = head;
        while (count >= k) {
            ListNode groupStart = current;
            ListNode prev = null;

            // Reverse the current group of k nodes
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Connect the reversed group to the previous part of the list
            prevGroupEnd.next = prev;
            groupStart.next = current;
            prevGroupEnd = groupStart;

            // Reduce count by k, since we processed k nodes
            count -= k;
        }

        // Return the modified list starting from dummy's next node
        return dummy.next;
    }
}