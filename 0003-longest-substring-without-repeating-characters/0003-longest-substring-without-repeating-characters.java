class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int maxLen = 0;
        // int currLen = 0;

        // int i=0; 
        // int j= -1;

        // boolean[] set  =new boolean[256];
        // while(i<s.length()){
        //     char ch_to_acquire = s.charAt(i);

        //     // duplicacy & release
        //     while(set[ch_to_acquire] == true) {
        //         j++;
        //         char ch_to_release = s.charAt(j);
        //         set[ch_to_release] = false;
        //     }

        //     // acquire
        //     set[ch_to_acquire] = true;

        //     // update length
        //     currLen = i-j;
        //     if(currLen > maxLen) {
        //         maxLen = currLen;
        //     }
        //     i++;
        // }
        // return maxLen;


        int ans = 0;

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length() - 1) {
                f1 = true;
                i++;

                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) == 2) {
                    break;
                } else {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                }
            }

            while (j < i) {
                f2 = true;
                j++;
                char ch1 = s.charAt(j);
                map.put(ch1, map.getOrDefault(ch1, 0) - 1);

                if (map.get(ch1) == 1) {
                    break;
                }
            }
            if (!f1 && !f2) break;
        }
        return ans;
    }
}
// brute force - kadane's algo
