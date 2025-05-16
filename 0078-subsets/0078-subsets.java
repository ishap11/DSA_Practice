class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        createSubsets(nums, nums.length - 1, res, subset);
        return res;
    }

    public void createSubsets(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        // Base case: if index is less than 0, add the current subset to result and return
        if (index < 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Exclude the current element and move to the next element (towards the start)
        createSubsets(nums, index - 1, res, subset);

        // Include the current element in the subset and move to the next element (towards the start)
        subset.add(nums[index]);
        createSubsets(nums, index - 1, res, subset);

        // Backtrack by removing the last element added
        subset.remove(subset.size() - 1);
    }
}