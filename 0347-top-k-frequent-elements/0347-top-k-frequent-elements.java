class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // TC  - O(k⋅n) SC - O(m+k)
        // HashMap<Integer , Integer> map = new HashMap<>();
        // int[] ans = new int[k];
        // for(int num : nums){
        //     map.put(num , map.getOrDefault(num , 0) +1);
        // }
        
        //  // Step 2: Find the top k frequent elements
        // for (int i = 0; i < k; i++) {
        //     int maxFreq = 0;
        //     int maxKey = 0;
            
        //     // Iterate over the map to find the element with the highest frequency
        //     for (int key : map.keySet()) {
        //         if (map.get(key) > maxFreq) {
        //             maxFreq = map.get(key);
        //             maxKey = key;
        //         }
        //     }
            
        //     // Add the most frequent element to the result array
        //     ans[i] = maxKey;
            
        //     // Remove the most frequent element from the map
        //     map.remove(maxKey);
        // }
        
        // return ans;


        // TC - O(n) Sc- O(1)
        List<Integer> [] bucket = new List[nums.length + 1];
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) +1);
        }

        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null ) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for(int pos = bucket.length -1; pos >=0 && counter < k ; pos--) {
            if(bucket[pos] != null) {
                for(Integer integer : bucket[pos]) {
                    res[counter++] = integer;
                }
            }
        }
        return res;
    }
}