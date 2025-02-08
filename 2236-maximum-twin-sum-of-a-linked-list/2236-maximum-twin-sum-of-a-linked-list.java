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
    public int pairSum(ListNode head) {
        if (head == null || head.next == null) return 0;

        // Step 1: Find the middle node
        ListNode mid = midNode(head);
        ListNode secondHalf = reverse(mid.next);
        mid.next = null;
        
        ListNode i = head;
        ListNode j = secondHalf;
        int maxSum = 0;
        while (j != null) {
            maxSum = Math.max(maxSum, i.val + j.val);
            i = i.next;
            j = j.next;
        }
        
        return maxSum;
    }

    public ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast =head;

        while(fast != null && fast.next != null  && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null ;
        ListNode curr = head;
        
        while(curr != null)  {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}