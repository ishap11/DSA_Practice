class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i =0;
        int j=0;
        int minValue = Integer.MAX_VALUE;
        int sum  = 0;
        while(j < nums.length){
            sum += nums[j] ;

            if(sum < target){
                j++;
            }else {
                minValue = Math.min((j-i+1) , minValue);
                while(sum >= target){
                    minValue = Math.min((j-i+1) , minValue);
                    sum -= nums[i];
                    i++;
        
                }
                j++;
            }
        }
        return minValue == Integer.MAX_VALUE? 0 : minValue;
    }
}