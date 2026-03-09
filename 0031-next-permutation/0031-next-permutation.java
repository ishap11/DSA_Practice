class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i == -1){
            int st = 0;
            int et = nums.length - 1;

            while(st <= et){
                int temp = nums[st];
                nums[st] = nums[et];
                nums[et] = temp;
                st++;
                et--;
            }

            return;
        }

        int k = nums.length - 1;
        while(nums[i] >= nums[k]){
            k--;
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;

        int st = i + 1;
        int et =nums.length - 1;

        while(st <= et){
            int tempp = nums[st];
            nums[st] = nums[et];
            nums[et] = tempp;

            st++;
            et--;
        }
    }
}