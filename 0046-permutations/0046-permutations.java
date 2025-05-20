class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        return generatePermutations(nums, used, current, result, 0);

        // Print all permutations
        // for (List<Integer> perm : result) {
        //     System.out.println(perm);
        // }
    }

     public static List<List<Integer>> generatePermutations(int[] nums, boolean[] used, List<Integer> current,
                                            List<List<Integer>> result, int level) {
        if (level == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current list
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;                     // choose option
                current.add(nums[i]);                // add to current path
                generatePermutations(nums, used, current, result, level + 1); // next level
                current.remove(current.size() - 1); // backtrack
                used[i] = false;                    // un-choose
            }
        }
        return result;
    }
}