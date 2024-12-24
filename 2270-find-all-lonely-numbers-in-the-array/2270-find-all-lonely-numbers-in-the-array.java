class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums ) {
            map.put(num , map.getOrDefault(num , 0) +1);
        }

        for(int num : map.keySet() ){
            if(map.get(num) == 1 && map.get(num-1) == null && map.get(num+1) == null) {
                ans.add(num);
            }
        }
        return ans;
    }
}