class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] rightProd = new int[n];
        int mul = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            mul *= nums[i];
            rightProd[i] = mul;
        }

        mul = 1;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            int left = mul;
            int right = rightProd[i+1];
            ans[i] = left * right;
            mul *= nums[i];
        }

        ans[nums.length - 1] = mul;


        return ans;
    }
}