class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0 ; i< nums.length;  i++) {
            if(i < k) {  // 0< 2 (T) , 1<2(T) , 2 < 2 (F)
                pq.add(nums[i]); // -1 , 2 
            } 
            else {
                if(pq.peek() < nums[i]) { // -1 < 0 (T)  
                    pq.remove(); // -1 
                    pq.add(nums[i]); // 0
                }
            }
        }
        return pq.peek(); // 0
    }
}

//  [ -1 2 0 ] k = 2

