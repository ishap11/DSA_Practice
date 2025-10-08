class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();

        return generatePer(nums , used , curr , ans , 0);
    }

    public List<List<Integer>> generatePer(int[] nums , boolean[] used , List<Integer> curr , List<List<Integer>> ans , int level){
        if(level == nums.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int i = 0 ; i< nums.length ; i++){
            if(!used[i]){
                used[i] = true;
                curr.add(nums[i]);
                generatePer(nums , used , curr , ans , level + 1);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }

        return ans;
    }
}