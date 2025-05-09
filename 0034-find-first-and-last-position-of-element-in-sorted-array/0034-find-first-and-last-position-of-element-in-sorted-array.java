class Solution {
    public int[] searchRange(int[] nums, int target) {

       int firstIdx =  firstIndex(nums , target) ;
       int lastIdx = lastIndex(nums , target);

        if (firstIdx == -1 || lastIdx == -1) {
            return new int[]{-1, -1};
        }
        
       return new int[]{firstIdx  , lastIdx};
        
    }

    public int firstIndex(int[] nums , int target) {
        int low = 0 ;
        int high =  nums.length -1;
        int result = -1;

        while(low <= high) {
            int mid = (low + high)/2;

            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target){
                high = mid -1;
            } else {
                result = mid;
                high = mid -1;
            }
        }
        return result;
    }

    public int  lastIndex(int[] nums , int target) {
        int low = 0 ;
        int high =  nums.length -1;
        int result = -1;

        while(low <= high) {
            int mid = (low + high)/2;

            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target){
                high = mid -1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }
}