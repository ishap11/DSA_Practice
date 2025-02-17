class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max_avg = Integer.MIN_VALUE;
        double avg = 0;
        int i= 0;
        int j= 0;

        while(j < nums.length) {
            avg += nums[j];

            if(j - i + 1 < k) {
                j++;
            }else if(j - i + 1 == k) {
                max_avg = Math.max(max_avg , avg/k);
                avg -= nums[i]; // Remove the leftmost element before moving the window
                i++;
                j++;
            } 
            
        }
        return max_avg;
    }
}