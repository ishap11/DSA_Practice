class Solution {
    public int rob(int[] nums) {
        // wrong
        // int sum =0;
        // for(int i=0; i< nums.length ; i+=2) {
        //     sum+= nums[i];
        // }
        // return sum;


        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int rob1 = 0, rob2 = 0;
        
        for (int num : nums) {
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}