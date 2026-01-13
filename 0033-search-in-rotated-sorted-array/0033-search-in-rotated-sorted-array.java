class Solution {
    public int search(int[] nums, int target) {
        int li = 0;
        int hi = nums.length - 1;

        while(li <= hi){
            int mid = (li + hi) / 2;

            if(nums[mid] == target){
                return mid;
            }

            else if(nums[li] <= nums[mid]) {
                if(nums[li] <= target && target <= nums[mid]){
                    hi = mid - 1;
                }else{
                    li = mid + 1;
                }
            }

            else if(nums[mid] <= nums[hi]){
                if(nums[mid] <= target && target <= nums[hi]){
                    li = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}