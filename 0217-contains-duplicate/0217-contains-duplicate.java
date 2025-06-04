class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashMap<Integer , Integer> map = new HashMap<>();

        // for(int num : nums) {
        //     map.put(num , map.getOrDefault(num , 0)+1);
        // }

        // for(int freq : map.values()) {
        //     if(freq >= 2) {
        //         return true;
        //     }
        // }
        // return false;

        //  HashSet<Integer> set= new HashSet<>();
        // for(int i: nums) {
        //     if(set.contains(i)) return true;
        //     set.add(i);
        // }
        // return false;

         Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (!s.add(num)) { // If num already exists, set.add returns false
                return true;
            }
        }
        return false;
    }
}