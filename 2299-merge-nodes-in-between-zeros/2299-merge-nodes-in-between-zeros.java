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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;
        ListNode j = curr;

        int sum =0;
        while(curr != null){
            while(j != null && j.val != 0){
                sum += j.val;
                j = j.next;
            } 
            curr.val = sum;       
            curr.next = j.next;    
            curr = j.next;        
            if (curr != null) {
                j = curr;          
                sum = 0;          
            }              
        }

        return head.next;
    }
}