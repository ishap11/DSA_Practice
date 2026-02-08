class Solution {
    public int rob(int[] nums) {
         int n = nums.length;
        
        // Edge cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        // Case 1: rob houses from 0 to n-2 [In case 1, first house allowed, last forbidden]
        int case1 = robLinear(nums, 0, n - 2);
        
        // Case 2: rob houses from 1 to n-1 [In case 2, last house allowed, first forbidden]
        int case2 = robLinear(nums, 1, n - 1);
        
        return Math.max(case1, case2);
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}