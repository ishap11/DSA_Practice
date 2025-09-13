class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int count1 = 0; // Count of elements from nums1 present in nums2
        int count2 = 0; // Count of elements from nums2 present in nums1

        // Loop to find elements of nums1 in nums2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    count1++; // Increment count if the element is found in nums2
                    break; // Move to the next element of nums1
                }
            }
        }

        // Loop to find elements of nums2 in nums1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums2[i] == nums1[j]) {
                    count2++; // Increment count if the element is found in nums1
                    break; // Move to the next element of nums2
                }
            }
        }

        // Return the counts as an integer array
        return new int[]{count1, count2};
    }
}
