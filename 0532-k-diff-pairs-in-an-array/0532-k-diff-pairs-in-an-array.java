class Solution {
    public int findPairs(int[] nums, int k) {
         if (k < 0) return 0;

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> pairs = new HashSet<>();

        if (k == 0) {
            // special case: count numbers that appear twice
            HashSet<Integer> duplicates = new HashSet<>();
            for (int n : nums) {
                if (!seen.add(n)) { // if n already exists in seen → duplicate found
                    duplicates.add(n);
                }
            }
            return duplicates.size();
        }

        // k > 0
        for (int n : nums) {
            if (seen.contains(n - k)) pairs.add(n - k);
            if (seen.contains(n + k)) pairs.add(n);
            seen.add(n);
        }

        return pairs.size();
    }
}