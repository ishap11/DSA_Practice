class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length] ;

        for (int i = 0; i < nums2.length; i++) {
        int nextGreater = -1;

        for (int j = i + 1; j < nums2.length; j++) {
            if (nums2[j] > nums2[i]) {
                nextGreater = nums2[j];
                break; 
            }
        }

        map.put(nums2[i], nextGreater); 
    }
 

        for(int i=0 ; i< nums1.length ; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}