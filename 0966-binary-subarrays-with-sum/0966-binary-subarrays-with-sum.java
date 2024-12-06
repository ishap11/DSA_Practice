class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int sum =0 ;
        // int count = 0;
        // int n = nums.length;


        // for(int i =0;i<n;i++)
        // {
        //     sum =0 ;
        //     for(int j =i;j<n;j++)
        //     {
        //         sum +=nums[j];
        //         if(sum==goal)
        //         {
        //             count++;
        //         }
        //     }
        // }
        // return count;


        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1); // Base case: If the running sum equals the goal at any point, it's valid.

        for (int num : nums) {
            currSum += num; 

            if (preSumMap.containsKey(currSum - goal)) {
                count += preSumMap.get(currSum - goal); 
            }

            preSumMap.put(currSum, preSumMap.getOrDefault(currSum, 0) + 1);
        }

        return count;

    }
}