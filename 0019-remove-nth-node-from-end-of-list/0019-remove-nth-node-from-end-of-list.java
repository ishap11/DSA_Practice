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
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev =null;

        while(curr != null) {
            ListNode next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reverseList = reverse(head);

       ListNode dummy = new ListNode(-1);
       dummy.next = reverseList;

       ListNode curr = dummy;

       for(int i=1 ; i< n ; i++) {
        curr = curr.next;
       }

       curr.next = curr.next != null ? curr.next.next : null;

       return reverse(dummy.next);
    }
}