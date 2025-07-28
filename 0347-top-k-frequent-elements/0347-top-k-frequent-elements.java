class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        for(int i=0 ; i< k ; i++) {
            int maxFreq = 0;
            int maxkey = 0;

            for(int key : map.keySet()) {
                if(map.get(key) > maxFreq) {
                    maxFreq = map.get(key);
                    maxkey = key;
                }
            }

            ans[i] = maxkey;
            map.remove(maxkey);
        }
        return ans;
    }
}