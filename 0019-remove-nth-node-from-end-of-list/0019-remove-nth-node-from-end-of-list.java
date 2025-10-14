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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both slow and fast until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;


        // ListNode reverseList = reverse(head);

        // ListNode dummy = new ListNode(-1);
        // dummy.next = reverseList;

        // ListNode curr = dummy;

        // for(int i = 1 ; i< n ; i++){
        //     curr = curr.next;
        // }
        // curr.next = curr.next != null ? curr.next.next : null;

        // return reverse(dummy.next);
    }

    // public ListNode reverse(ListNode head){
    //     if(head == null || head.next == null){
    //         return head;
    //     }

    //     ListNode curr = head;
    //     ListNode prev = null;

    //     while(curr != null){
    //         ListNode next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     return prev;
    // }
}