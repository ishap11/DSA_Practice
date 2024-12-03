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

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> pq = new ListNode<>((a,b)->{
//             return a.val - b.val;

//         });

//         for(ListNode 1:lists) if(1 != null) pq.add(1);
//         ListNode dummy = new ListNode(-1);
//         ListNode prev = dummy;
//         while(pq.size != 0){
//             ListNode node = pq.remove();
//             prev.next = node;
//             prev = prev.next;
//             node = node.next;

//             if(node != null ) pq.add(node);

//             return dummy.next;
//         }
//     }
// }

// import java.util.Comparator;
// import java.util.PriorityQueue;

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

//         for (ListNode l : lists) {
//             if (l != null) {
//                 pq.add(l);
//             }
//         }

//         ListNode dummy = new ListNode(-1);
//         ListNode prev = dummy;

//         while (!pq.isEmpty()) {
//             ListNode node = pq.poll();
//             prev.next = node;
//             prev = prev.next;
//             node = node.next;

//             if (node != null) {
//                 pq.add(node);
//             }
//         }

//         return dummy.next;
//     }
// }

class Solution {
    public class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;

        Pair(int li , int di , int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }
        @Override
        public int compareTo(Pair other) {
            return this.val - other.val; // Min-heap based on value
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) { 
                pq.add(new Pair(i, 0, lists[i].val));
            }
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            tail.next = new ListNode(p.val);
            tail = tail.next;

            // Move to the next element in the list from which the pair was removed
            lists[p.li] = lists[p.li].next;

            // If the list is not exhausted, add the next element to the priority queue
            if (lists[p.li] != null) {
                pq.add(new Pair(p.li, p.di + 1, lists[p.li].val));
            }
        }

        return dummy.next;
    }
}
