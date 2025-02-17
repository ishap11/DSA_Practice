class Solution {
    public int maxVowels(String s, int k) {
        int max_vowel = 0;
        int vowel = 0;

        int i=0 ;
        int j=0;

        while(j < s.length()) {
            char ch = s.charAt(j);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            }

            if(j- i + 1 < k) {
                j++;
            }else if (j - i + 1 == k) {
                max_vowel = Math.max(max_vowel , vowel);
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                    vowel--;
                }
                i++;
                j++;
            }
        }
        return max_vowel;
    }
}