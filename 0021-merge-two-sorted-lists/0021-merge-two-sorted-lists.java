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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }
        ListNode ans = new ListNode(-1);
        ListNode res = ans;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            }else {
                res.next = l2;
                l2 = l2.next;
            }
            res =res.next;
        }

        res.next = l1 != null ? l1 : l2;
        return ans.next;
    }
}