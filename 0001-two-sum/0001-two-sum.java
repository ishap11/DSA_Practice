class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int idx ; 

        Pair(int val , int idx) {
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        // for(int i = 0; i < nums.length; i++){
        //     for(int j=i+1; j < nums.length; j++){
        //         if (nums[j] == target - nums[i]){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{-1,-1};

        Pair[] pair = new Pair[nums.length];

        for(int i=0; i< nums.length ; i++) {
            pair[i] = new Pair(nums[i] , i);
        }

        Arrays.sort(pair);
        int[] res = new int[2];
        int li = 0;
        int ri = nums.length -1;

        while(li <= ri) {
            int left = pair[li].val;
            int right = pair[ri].val;

            if(left + right < target) {
                li++;
            } else if(left + right > target) {
                ri--;
            } else {
                res[0] = pair[li].idx;
                res[1] = pair[ri].idx;
                break;
            }
        }
        return res;


       

    }
}