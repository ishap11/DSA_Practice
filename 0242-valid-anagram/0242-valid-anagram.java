class Solution {
    public boolean isAnagram(String s, String t) {
        // if (s.length() != t.length()) return false;

        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();

        // Arrays.sort(sArr);
        // Arrays.sort(tArr);

        // for (int i = 0; i < sArr.length; i++) {
        //     if (sArr[i] != tArr[i]) {
        //         return false;
        //     }
        // }

        // return true;

        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for(int i= 0 ; i< s.length() ; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}