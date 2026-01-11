class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character , Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int ans = 0;

        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch , map.getOrDefault(ch , 0) + 1);

            maxFreq = Math.max(maxFreq , map.get(ch));

            int winsize = j - i + 1;

            while(winsize - maxFreq > k){
                char left = s.charAt(i);
                map.put(left , map.get(left) - 1);
                i++;
                winsize = j - i + 1;
            }

            ans = Math.max(ans , winsize);
            j++;
        }

        return ans;
    }
}
