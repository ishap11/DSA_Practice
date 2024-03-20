class Solution {
    public int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        // int i = 0;
        // while(i<nums.length-1){
        //     if(nums[i]==nums[i+1]){
        //         i = i+2;
        //     }
        //     else{
        //         break;
        //     }
            
        // }
        // return nums[i];

        // METHOd-2
        int a =0;
        for(int i=0 ; i<nums.length ; i++){
            a = a^nums[i];
        }
        return a;
    }
}