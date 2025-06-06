class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int[] rightProd = new int[nums.length];
        int mult = 1;
        for(int i= nums.length -1 ; i>= 0 ; i--){
           mult *= nums[i];
           rightProd[i] = mult;
        }

        mult = 1;
        for(int i=0 ; i< nums.length - 1; i++) {
           int lp = mult;
           int rp = rightProd[i+1];

           res[i] = lp * rp;

           mult *= nums[i];
        }
        res[nums.length - 1] = mult;
        return res;
    }
}