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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          // Create a dummy node to act as the head of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists and add the smaller node to the merged list
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // If there are remaining nodes in either list, add them to the end
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the head of the merged list (skipping the dummy node)
        return dummy.next;
    }
}