class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            sum += num;

            if(sum < 0){
                sum = 0;
            }

            maxSum = Math.max(maxSum , sum);
        }

        return maxSum;
    }
}