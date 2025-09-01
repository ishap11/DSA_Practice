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
        if(head == null || head.next == null) return head;

        ListNode rhead = reverse(head);
        ListNode curr = rhead;
        ListNode prev = null;
        int max = Integer.MIN_VALUE;

        while(curr != null) {
            if(curr.val >= max) {
                max = curr.val;
                prev =curr;
            }  else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return reverse(rhead);
    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}