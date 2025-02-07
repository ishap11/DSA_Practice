class Solution {
    public void moveZeroes(int[] nums) {

        // TC- O(n) SC - O(n)
        // int[] ans = new int[nums.length];
        // int j= 0;
        // for(int i=0; i< nums.length ; i++) {
        //     if(nums[i] != 0) {
        //         ans[j++] = nums[i];
        //     }
        // }
        // while (j < nums.length ){
        //     ans[j++] = 0;
        // }
        // for (int i = 0; i < nums.length ; i++) {
        //     nums[i] = ans[i];
        // }

        int i = 0;
        int j = 0;
        int temp;

        while (i < nums.length) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
        }
    }
}