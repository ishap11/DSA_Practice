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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode temp = null;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        temp = fast;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode curr1 = temp;
        ListNode curr2 = slow.next;

        int val = curr1.val;
        curr1.val = curr2.val;
        curr2.val = val;

        return dummy.next;

    }
}