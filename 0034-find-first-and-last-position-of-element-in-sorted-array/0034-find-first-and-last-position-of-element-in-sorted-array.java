class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int fIdx = searchFIdx(nums , target);
        int lIdx = searchLIdx(nums , target);

        if(fIdx == -1 && lIdx == -1){
            return new int[]{-1 , -1};
        }

        return new int[]{fIdx , lIdx};
    }

    public int searchFIdx(int[] nums , int target){
        int lo = 0;
        int hi = nums.length -1;
        int res = -1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else {
                res = mid;
                hi = mid - 1;
            }
        }
        return res;
    }

    public int searchLIdx(int[] nums , int target){
        int lo = 0;
        int hi = nums.length -1;
        int res = -1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else {
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }
}