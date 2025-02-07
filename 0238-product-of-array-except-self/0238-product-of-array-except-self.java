class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Brute force --TLE
        // int n = nums.length;

        // int[] res = new int[n];
        // Arrays.fill(res, 1);
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i != j) {
        //             res[i] *= nums[j];
        //         }
        //     }
        // }
        // return res;

        int[] ans = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }
}