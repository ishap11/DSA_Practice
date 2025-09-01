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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode evenDummy = new ListNode(-1);
        ListNode even = evenDummy;

        ListNode oddDummy = new ListNode(-1);
        ListNode odd = oddDummy;

        ListNode curr = head;

        int n =0;
        while(curr != null) {
            n++;
            if(n % 2 == 0) {
                even.next = curr;
                even = even.next;
            }else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }
        even.next = null;
        odd.next = evenDummy.next;

        return oddDummy.next;
    }
}