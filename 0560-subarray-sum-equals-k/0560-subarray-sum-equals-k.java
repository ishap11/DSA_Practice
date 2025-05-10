class Solution {
    public int subarraySum(int[] nums, int k) {
        /*

        why this solution is wrong : 
        Initial: sum = 0, count = 0, i = 0, j = 0
        sum += nums[j] → sum = 1
        sum == k → ❌ no (1 != 0)
        sum < k → ❌ no (1 > 0)
        sum > k → ✅ yes
        enter while (sum > k):
        sum -= nums[i] → sum = 0, i = 1
        sum == k → ✅ yes → count++ → count = 1
        j++ → j = 1
        loop ends
        ⚠ WRONG output: 1
        ✅ Correct output: 0
        Because there is no subarray in [1] whose sum is exactly 0.
        
        ================CODE======================

        int sum = 0;
        int count = 0;

        int i=0;
        int j=0;

        while(j< nums.length) {
            sum += nums[j];

            if(sum == k) {
                count++;
            }

            if(sum < k) {
                j++;
            }else if (sum > k) {
                while(sum > k && i<=j) {
                    sum -= nums[i];
                    i++;
                }
                if (sum == k) {
                    count++;
                }
                j++;
            } else {
                j++;
            }
        }
        return count;
        */


        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int sum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         if (sum == k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;


        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Check if the current sum is equal to k
            if (sum == k) {
                count++;
            }

            // Check if there's any previous prefix sum such that sum - k has occurred
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store the current sum in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
        
    }
}