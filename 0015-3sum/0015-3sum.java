class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> set = new HashSet<>();
        // int n = nums.length;

        // for(int i= 0 ; i< n  ; i++) {
        //     for(int j = i+1 ; j< n ; j++) {
        //         for(int k= j+1 ; k< n ;k++) {
        //             if(nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(ans);
        //                 set.add(ans);
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(set);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length ; 
        Arrays.sort(nums);

        for(int i=0 ; i< nums.length ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = n-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i] , nums[left] , nums[right]));

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--; 
                }
                else if(sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}