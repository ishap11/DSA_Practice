class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // Step 1: Find first decreasing element from the end
        while(i>= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if(i == -1){
            // reverse the largest to the smallest 
            int s = nums.length -1;
            int t = 0;

            while(t<s) {
                int temp = nums[t];
                nums[t] = nums[s];
                nums[s] = temp;
                t++;
                s--;
            }
            return;
        }

        // Step 2: Find next larger element on the right
        int k = nums.length -1;
        while(nums[i] >= nums[k]) {
            k--;
        }
        // swap 
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;


        // Reverse the suffix(jisse smallest no bnjaaye)
        int start = i + 1;
        int end = nums.length - 1;

        while (start < end) {
            int tempVar = nums[start];
            nums[start] = nums[end];
            nums[end] = tempVar;
            start++;
            end--;
        }

    }
}