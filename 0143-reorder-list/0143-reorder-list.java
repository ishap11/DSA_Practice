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
    public ListNode middle(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    } 

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        
        ListNode midNode = middle(head);
        ListNode newHead = reverse(midNode.next);
        midNode.next = null;
        
        ListNode curr = head;
        
        ListNode tempHead = newHead;

        while(curr != null && tempHead != null){
            ListNode temp1 = curr.next;
            curr.next = tempHead;
            ListNode temp2 = tempHead.next;
            tempHead.next = temp1;
            curr = temp1;
            tempHead = temp2;
        }

    }
}