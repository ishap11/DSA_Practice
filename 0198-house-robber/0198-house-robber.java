class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int rob1 = 0, rob2 = 0;
        
        for (int num : nums) {
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}

/*
rob1 = 0             rob2 = 0
[ 1     ,   2      ,  3      , 1] 
  num
           num
                     num
                               num

temp => max(rob1 = 0 + 1  rob2 = 0) ==> 1
rob1 = rob2 ===> 0;
rob2 = temp ===> 1;

temp => max(rob1 = 0 + 2  rob2 = 1) ==> 2
rob1 = rob2 ===> 1;
rob2 = temp ===> 2;

temp => max(rob1 = 1 + 3  rob2 = 2) ==> 4
rob1 = rob2 ===> 2;
rob2 = temp ===> 4;

temp => max(rob1 = 2 + 1  rob2 = 4) ==> 4
rob1 = rob2 ===> 4;
rob2 = temp ===> 4;


return rob2 ===> 4 ans

*/