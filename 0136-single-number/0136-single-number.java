class Solution {
    public int singleNumber(int[] nums) {
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     int count = 0;

        //     for (int j = 0; j < n; j++) {
        //         if (nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if (count == 1) {
        //         return nums[i];
        //     }
        // }
        // return -1;


        HashMap<Integer , Integer > map = new HashMap<>();
        for(int num: nums){
            map.put(num , map.getOrDefault(num , 0)+1);
        }
        for(int num: nums){
            if(map.get(num)==1){
                return num;
            }
        }
        return -1;


    }
}