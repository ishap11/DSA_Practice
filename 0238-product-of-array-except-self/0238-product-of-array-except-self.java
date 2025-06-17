class Solution {
    public int[] productExceptSelf(int[] nums) {
       int [] res = new int[nums.length];

       int[] rightProd = new int[nums.length];
       int mul = 1;
       for(int i = nums.length - 1 ; i >= 0  ;i--) {
            mul *= nums[i];
            rightProd[i] = mul;
       }

       mul = 1;
        for(int i=0 ; i< nums.length - 1; i++) {
           int lp = mul;
           int rp = rightProd[i+1];

           res[i] = lp * rp;

           mul *= nums[i];
        }
        res[nums.length - 1] = mul;
        return res;
    }
}