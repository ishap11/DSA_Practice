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
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyEven = new ListNode(-1);
        ListNode even = dummyEven;

        ListNode dummyOdd = new ListNode(-1);
        ListNode odd = dummyOdd;

        ListNode curr = head;

        int n = 0;
        while(curr != null){
            n++;
            if(n % 2 == 0){
                even.next = curr;
                even = even.next;
            }else{
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }

        odd.next = dummyEven.next;
        even.next = null;

        return dummyOdd.next;
    }
}