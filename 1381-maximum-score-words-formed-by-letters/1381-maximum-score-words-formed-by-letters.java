class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char ch : letters) {
            freq[ch - 'a']++;
        }
        return solution(words , freq , score , 0);
    }

    public int solution(String[] words , int[] freq , int[] score , int idx) {
        if(idx == words.length) {
            return 0;
        }

        int sno = 0 + solution(words , freq , score , idx + 1);

        int sword = 0;
        String word = words[idx];
        boolean flag = true;

        int[] temp = freq.clone(); // clone for backtracking

         for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (temp[ch - 'a'] == 0) {
                flag = false;
            }

            temp[ch - 'a']--;
            sword += score[ch - 'a'];
        }

        int syes = 0;
        if(flag ) {
            syes = sword + solution(words , temp , score , idx + 1);

        }

        return Math.max(sno , syes);
    }
}