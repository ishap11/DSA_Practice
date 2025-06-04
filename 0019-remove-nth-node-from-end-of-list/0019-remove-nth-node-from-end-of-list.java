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

/*
reverse --> 5-----> 4-----> 3-----> 2----->1 */
    
    /*Eg :        1 -----> 2-----> 3-----> 4-----> 5
STEP 1:  null     head
STEP 2:  prev     curr     next
STEP 3:       <----1        2 -----> 3------>4 ------>5
                  prev     curr    next
STEP 4:       <-----1 <------2       3 ------->4 ----->5
                             prev     curr     next
LAST STEP : 1 <----- 2 <------ 3 < ------ 4 <------5
*/ 
class Solution {

    // reverse 
    private ListNode reverse(ListNode head) {

        // base case
        if(head == null || head.next == null) {
            return head;
        }

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        // calling the method reverse and passing the argument head
        //  in return i got ----> 5 ----> 4 -----> 3 -----> 2 -----> 1
        ListNode reverseList = reverse(head);

        // -1     5 ----> 4 -----> 3 -----> 2 -----> 1
        ListNode dummy = new ListNode(-1);

        //  -1 (dummy) -----> 5 ----> 4 -----> 3 -----> 2 -----> 1
        dummy.next = reverseList;

         //  -1 (dummy || curr) -----> 5 ----> 4 -----> 3 -----> 2 -----> 1
        ListNode curr = dummy;

        //1} -1 [i](dummy || curr) -----> 5 ----> 4 -----> 3 -----> 2 -----> 1
        //2} -1 (dummy  -----> 5(curr)[i] ----> 4 -----> 3 -----> 2 -----> 1
        
        for(int i= 1 ; i< n ; i++) {
            curr = curr.next;
        }

        curr.next = curr.next != null ? curr.next.next : null;

        
        return reverse(dummy.next);

    }
}