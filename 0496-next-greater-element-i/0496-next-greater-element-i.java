class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // if (nums2.length == 0 || nums1.length == 0)
        // return new int[0];
        
        // Stack<Integer> st = new Stack<>();
        // Map<Integer,Integer> map = new HashMap<>();

        // for(int nums: nums2){
        //     while(st.size() > 0 &&  st.peek() < nums){
        //         map.put(st.pop(), nums);
        //     }
        //     st.push(nums);
        // }
        // for (int i = 0; i < nums1.length; i++) { 
            // Check if each element in nums1 has a next greater element in map
        //     nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
         // Update element in nums1 with next greater element or -1
        // }
        // return nums1;


        int[] ngr = nextGreaterElemRight(nums2);
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            hm.put(nums2[i], ngr[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }

        return ans;

    }
    public static int[] nextGreaterElemRight(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}