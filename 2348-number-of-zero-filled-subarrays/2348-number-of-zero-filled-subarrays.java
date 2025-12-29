class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long current = 0;

        for (int num : nums) {
            if (num == 0) {
                current++;       // increase streak
                count += current; // add subarrays ending here
            } else {
                current = 0;      // reset streak
            }
        }
        return count;
    }
}
