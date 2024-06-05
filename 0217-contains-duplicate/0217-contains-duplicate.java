class Solution {
    public boolean containsDuplicate(int[] nums) {
        // BRUTE FORCE - TC->O(N^2) SC-> O(1)

        // for(int i=0; i< nums.length ; i++){
        //     for(int j=i+1; j< nums.length ; j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false


        // Sorting Efficient approach 
        // TC:O(N*logN),Sorting takes N*logN. N isthe length of the array
        // SC: O(1), Since we are not using any extra space. 

        /*
        Arrays.sort(nums);

        for(int i =1 ; i< nums.length ; i++){
            // Now, the loop starts iterating over the sorted array nums 
            // starting from index 1. The reason it starts from index 1 instead of 
            // 0 is because it is comparing each element with the previous one 
            // (index i - 1), so it's necessary to begin at index 1 
            // to have a valid previous element to compare to.
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
        */

        /*
        HashSet<Integer> set = new HashSet<>();
       for(int i=0; i< nums.length ;i++){
           if(set.contains(nums[i])){
               return true;
           }
           set.add(nums[i]);
       } 
       return false;
       */

       HashMap<Integer , Integer> map = new HashMap<>();
       for(int num : nums){
        map.put(num , map.getOrDefault(num ,0 )+1);

        if(map.get(num) > 1){
            return true;
        }
       }
       return false;
    }

}
