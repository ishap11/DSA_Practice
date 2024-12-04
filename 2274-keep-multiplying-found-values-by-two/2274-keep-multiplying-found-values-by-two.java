class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
       int original_copy  = original;

       for(int i=0; i< nums.length ; i++){
            if(nums[i] == original_copy) {
                original_copy *= 2;
            }
       } 
       return original_copy;
    }
}