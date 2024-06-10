class Solution {
    public int singleNonDuplicate(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        
        // for (int num : nums) {
        //     if (map.get(num) == 1) {
        //         return num;
        //     }
        // }
        // return -1;


        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }
}