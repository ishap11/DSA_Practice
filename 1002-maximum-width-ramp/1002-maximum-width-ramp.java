class Solution {
    public int maxWidthRamp(int[] nums) {
        /*
        //-+-+-+-+ TLE -+-+-+-+  TC- O(n^2) SC - O(1)
        int res = 0;
        for(int i = 0 ;i< nums.length-1; i++){
            for(int j=1 ; j< nums.length ; j++){
                if(nums[i] <= nums[j] && i<j){
                    res = Math.max(res , j-i);
                }
            }
        }
        return res;
        */

        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) 
        rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        
        int left = 0, right = 0, maxValue = 0;

        while (right < n) {
            while (right<n && nums[left]<=rightMax[right])
            right++;           
            maxValue = Math.max(maxValue, right - left-1);
            left++;
            right = left + maxValue + 1; 
        }

        return maxValue;
    }
}