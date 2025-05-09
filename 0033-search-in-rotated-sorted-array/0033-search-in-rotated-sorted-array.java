class Solution {
    public int search(int[] nums, int target) {
        int low  = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // left half is sorted......nums[low] <= target <= nums[mid]
            if(nums[low] <= nums[mid] ) {
                if(target >= nums[low] && target <= nums[mid]) { // target exist in left side
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // right half is sorted. (nums[mid] <= nums[high]).....nums[mid] <= target <= nums[high]
            else {
                if(target > nums[mid] && target <= nums[high] ) { // target exist in right side 
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}