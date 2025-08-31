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
    public void reorderList(ListNode head) {
        ListNode midNode = mid(head);
        ListNode nHead = midNode.next;

        ListNode revHead = reverse(nHead);
        midNode.next = null;

        ListNode curr = head;
        ListNode ncurr = revHead;

        while(curr != null && ncurr != null){
            ListNode temp1 = curr.next;
            curr.next = ncurr;

            ListNode temp2 = ncurr.next;
            ncurr.next = temp1;

            curr = temp1;
            ncurr = temp2;
        }
    }

    public ListNode mid(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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