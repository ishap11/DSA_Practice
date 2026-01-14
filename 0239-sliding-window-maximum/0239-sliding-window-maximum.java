class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0){
            return new int[0];
        }

        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int idx = 0;
        int i = 0;
        int j = 0;

        while(j < n){
            while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                dq.pollLast();
            }
            dq.addLast(nums[j]);

            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                ans[idx++] = dq.peekFirst();

                if(dq.peekFirst() == nums[i]){
                    dq.pollFirst();
                }

                i++;
                j++;
            }
        }
        return ans;
    }
}