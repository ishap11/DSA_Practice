class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    //    List<List<Integer>> res = new ArrayList<>();
    //     List<Integer> subset = new ArrayList<>();
    //     createSubsets(nums, nums.length - 1, res, subset);
    //     return res;

           return res(nums, 0); 
    }

    public static  List<List<Integer>> res(int[] nums , int index) {
        // base case
        if(index == nums.length ) {
            List<List<Integer>> baseres = new ArrayList<>();
            baseres.add(new ArrayList<>());
            return baseres;
        }

        List<List<Integer>> rrestres = res(nums, index + 1);
        List<List<Integer>> myres = new ArrayList<>();

        for(List<Integer> subset : rrestres) {
            myres.add(new ArrayList<>(subset));

            List<Integer> withCurr = new ArrayList<>(subset);
            withCurr.add(0, nums[index]); // insert current element at the front
            myres.add(withCurr);
        }

        return myres;
    }









    // public void createSubsets(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
    //     // Base case: if index is less than 0, add the current subset to result and return
    //     if (index < 0) {
    //         res.add(new ArrayList<>(subset));
    //         return;
    //     }

    //     // Exclude the current element and move to the next element (towards the start)
    //     createSubsets(nums, index - 1, res, subset);

    //     // Include the current element in the subset and move to the next element (towards the start)
    //     subset.add(nums[index]);
    //     createSubsets(nums, index - 1, res, subset);

    //     // Backtrack by removing the last element added
    //     subset.remove(subset.size() - 1);
    // }
}