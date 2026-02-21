class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rp = new int[n];
        int mul = 1;

        for(int i = n - 1; i>= 0 ; i--){
            mul *= nums[i];
            rp[i] = mul;
        }

        mul = 1;
        int[] ans = new int[n];

        for(int i = 0 ; i <  n - 1 ; i++){
            int left = mul;
            int right = rp[i + 1];

            ans[i] = left * right;
            mul *= nums[i];
        }

        ans[nums.length - 1] = mul;

        return ans;
    }
}