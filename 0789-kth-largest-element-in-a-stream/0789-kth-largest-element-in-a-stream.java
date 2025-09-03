class KthLargest {
    int K;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        K = k;

        pq = new PriorityQueue<>();
        
        for(int num : nums){
            pq.add(num);

            if(pq.size() > k) {
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size() > K) {
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */