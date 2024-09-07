class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createsubsets(nums, 0, res, subset);
        return res; 
    }
    public void createsubsets(int[] nums , int index , List<List<Integer>> res , List<Integer> subset) {
        if(index == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        createsubsets(nums , index +1 , res , subset);

        subset.remove(subset.size() - 1);
        createsubsets(nums, index + 1, res, subset);
    }
}