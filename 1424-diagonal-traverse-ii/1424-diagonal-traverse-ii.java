class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int total = 0;
        int maxKey = 0;

        // Step 1: Group elements by (i + j)
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {

                int key = i + j;

                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(nums.get(i).get(j));

                maxKey = Math.max(maxKey, key);
                total++;
            }
        }

        // Step 2: Build result
        int[] result = new int[total];
        int index = 0;

        for (int k = 0; k <= maxKey; k++) {
            if (map.containsKey(k)) {
                List<Integer> list = map.get(k);

                // reverse because bottom elements come first
                Collections.reverse(list);

                for (int num : list) {
                    result[index++] = num;
                }
            }
        }

        return result;
    }
}