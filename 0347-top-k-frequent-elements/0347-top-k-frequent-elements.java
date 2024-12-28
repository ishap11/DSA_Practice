class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) +1);
        }
        
         // Step 2: Find the top k frequent elements
        for (int i = 0; i < k; i++) {
            int maxFreq = 0;
            int maxKey = 0;
            
            // Iterate over the map to find the element with the highest frequency
            for (int key : map.keySet()) {
                if (map.get(key) > maxFreq) {
                    maxFreq = map.get(key);
                    maxKey = key;
                }
            }
            
            // Add the most frequent element to the result array
            ans[i] = maxKey;
            
            // Remove the most frequent element from the map
            map.remove(maxKey);
        }
        
        return ans;
    }
}