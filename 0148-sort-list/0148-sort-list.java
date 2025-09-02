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

    public ListNode mergeTwoLL(ListNode l1 , ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode midNode = mid(head);
        ListNode nhead = midNode.next;
        midNode.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(nhead);

        return mergeTwoLL(l1 , l2);
    }
}