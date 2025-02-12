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
    int i=1;
    public static PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<Integer>();
    }
    
    public int popSmallest() {
        if(pq.size()==0){
            return i++;
        }
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(num<i && !pq.contains(num)){
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