class Solution {
    public int findDuplicate(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();

        // for(int num : nums ){
        //     if(!set.contains(num)){
        //         set.add(num);
        //     }
        //     else if (set.contains(num)){
        //         return num;
        //     }
        // }
        // return -1;

        int left = 1;
        int right = nums.length - 1; // since nums.length == n + 1

        while (left < right) {
            int mid = (left + right) / 2;

            // Count how many numbers are <= mid
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // Binary search decision
            if (count > mid) {
                right = mid; // duplicate is in the left half
            } else {
                left = mid + 1; // duplicate is in the right half
            }
        }

        return left; // or right, since left == right
    }
}