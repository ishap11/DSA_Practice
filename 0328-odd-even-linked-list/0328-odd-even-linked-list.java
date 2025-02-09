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
        ListNode evenList = new ListNode(-1);
        ListNode oddList = new ListNode(-1);

        ListNode even = evenList;
        ListNode odd = oddList;
        ListNode curr = head;

       int n = 0; 
        while(curr != null){
            n++;
            if(n % 2 == 0){
                //even
                even.next = curr;
                even = even.next;
            }else{
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }
        even.next = null;
        odd.next = evenList.next;

        return oddList.next;
    }
}