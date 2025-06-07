class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while(i>= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if(i == -1) {
            int t = nums.length - 1;
            int s = 0;
            while(s<t) {
                int temp = nums[t];
                nums[t] = nums[s];
                nums[s] = temp;
                s++;
                t--;
            }
            return;
        }

        int k = nums.length - 1;
        while( nums[i] >= nums[k]) {
            k--;
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;

        int st = i + 1;
        int end = nums.length - 1;

        while(st < end) {
            int tempp = nums[st];
            nums[st] = nums[end];
            nums[end] = tempp;
            st++;
            end--;
        }
    }
}