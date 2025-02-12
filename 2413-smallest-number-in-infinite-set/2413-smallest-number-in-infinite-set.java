// class SmallestInfiniteSet {

//     private TreeSet<Integer> set;
//     private int nextNum;

//     public SmallestInfiniteSet() {
//         set = new TreeSet<>();
//         nextNum = 1;
//     }
    
//     public int popSmallest() {
//         if(!set.isEmpty()) {
//            return set.pollFirst();
//         }
//         return nextNum++;
//     }
    
//     public void addBack(int num) {
//         if(num < nextNum && !set.contains(num)) {
//             set.add(num);
//         } 
//     }
// }


class SmallestInfiniteSet {
    private int nextNum;  // Tracks the smallest number not removed yet
    private PriorityQueue<Integer> pq;  // Min-heap for added-back numbers
    private HashSet<Integer> set;  // To track numbers in pq (for O(1) lookup)

    public SmallestInfiniteSet() {
        nextNum = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!pq.isEmpty()) {
            int smallest = pq.poll();
            set.remove(smallest);  // Remove from HashSet
            return smallest;
        }
        return nextNum++;
    }
    
    public void addBack(int num) {
        if (num < nextNum && set.add(num)) {  // Only add if it's not already in the heap
            pq.add(num);
        }
    }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */