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
    private ListNode mid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next =curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode midNode = mid(head);
        ListNode nHead = midNode.next;
        midNode.next = null;

        nHead = reverse(nHead);

        ListNode curr1 = head;
        ListNode curr2 = nHead;

        while(curr1 != null  && curr2 != null){
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }

    }
}