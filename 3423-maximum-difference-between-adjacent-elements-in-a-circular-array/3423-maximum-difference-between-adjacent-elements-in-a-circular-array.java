class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;   // makes it circular
            max = Math.max(max, Math.abs(nums[i] - nums[next]));
        }

        return max;
    }
}