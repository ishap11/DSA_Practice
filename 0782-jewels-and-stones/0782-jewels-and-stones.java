class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : jewels.toCharArray()) {
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        for(char ch : stones.toCharArray()) {
            if (map.containsKey(ch)) {
                count++;
            }
        }
        return count;
    }
}