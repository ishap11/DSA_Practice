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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int carry = 0;

        while(curr != null) {
            int prod = (curr.val*2) + carry;
            curr.val = prod % 10;
            carry = prod/10;

            if(curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);  
                break;
            }

            curr = curr.next;
        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
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