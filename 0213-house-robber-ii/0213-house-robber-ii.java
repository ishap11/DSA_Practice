class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return nums[0]; // Only one house to rob
        }
        
        return Math.max(robb(nums, 0, n - 2), robb(nums, 1, n - 1));
    }

    public int robb(int[] nums, int st, int end) {
        int r1 = 0, r2 = 0;
        for (int i = st; i <= end; i++) {
            int temp = Math.max(r1 + nums[i], r2);
            r1 = r2;
            r2 = temp;
        }
        return r2;
    }
}
