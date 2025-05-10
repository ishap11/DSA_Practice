class Solution {
    public int longestConsecutive(int[] nums) {

        // TLE
        // HashSet<Integer> set = new HashSet<>();

        // for(int num : nums) {
        //     set.add(num);
        // }

        // int longSeq = 0;

        // for(int num : nums) {
        //       // Step 2: check if it's the start of a sequence
        //     if(!set.contains(num - 1)) {
        //         int currNum = num;
        //         int currStreak = 1;

        //         // Step 3: count the sequence length
        //         while (set.contains(currNum + 1)) {
        //             currNum += 1;
        //             currStreak += 1;
        //         }
        //         // Step 4: update longest
        //         longSeq = Math.max(longSeq, currStreak);
        //     }
            
        // }
        // return longSeq;



        /*==========================CODE=================================== */

        // HashMap<Integer , Boolean> map = new HashMap<>();

        // for(int num : nums) {
        //     map.put(num , true);
        // }

        // for(int num : nums) {
        //     if(map.containsKey(num - 1)) {
        //         map.put(num , false);
        //     }
        // }

        // int maxStartPoint = 0 ;
        // int maxLength = 0;

        // for(int num : nums) {
        //     if(map.get(num) == true) {
        //         int tempLength = 1;
        //         int tempStartPoint = num;

        //         while(map.containsKey(tempStartPoint +  tempLength)) {
        //             tempLength++;
        //         }

        //         if(tempLength > maxLength) {
        //             maxLength = tempLength;
        //         }
        //     }
        // }
        // return maxLength;
        


        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLength = 0;

        for (int num : set) {  
            if (!set.contains(num - 1)) { 
                int curNum = num;
                int currLen = 1;

                while (set.contains(curNum + 1)) {
                    curNum++;
                    currLen++;
                }

                maxLength = Math.max(maxLength, currLen);
            }
        }

        return maxLength;
    }
}