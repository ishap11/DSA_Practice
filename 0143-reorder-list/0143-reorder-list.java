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
    public ListNode mid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
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
    public void reorderList(ListNode head) {
        ListNode midNode = mid(head);
        ListNode nHead = midNode.next;
        ListNode reverseHead = reverse(nHead);
        midNode.next = null;

        ListNode curr = head;
        ListNode newCurr = reverseHead;

        while(curr != null && newCurr != null ){
            ListNode temp1 = curr.next ;
            curr.next = newCurr;
            ListNode temp2 = newCurr.next;
            newCurr.next = temp1;

            curr = temp1;
            newCurr = temp2;
        }
    }
}
