class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

             if (nums[mid] == target) {
                return mid;
            }

            // left half sorted 
            if(nums[lo] <= nums[mid]) {
                // target exist in b/w 
                if(nums[lo] <= target && target <= nums[mid]) {
                    hi = mid - 1;
                }
                // does not exist 
                else {
                    lo = mid + 1;
                }
            } 
            // right part sorted
            else {
                if(nums[mid] <= target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}