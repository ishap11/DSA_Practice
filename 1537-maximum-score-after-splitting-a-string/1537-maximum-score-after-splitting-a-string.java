class Solution {
    public int maxScore(String s) {

        // int totalOnes = 0;
        // int zerosCount = 0;
        // int onesCount = 0;
        // int bestScore = Integer.MIN_VALUE;

        // // Count total ones in the string
        // for (char ch : s.toCharArray()) {
        //     if (ch == '1') totalOnes++; //4
        // }

        // // Traverse the string and calculate scores
        // for (int i = 0; i < s.length() - 1; i++) {
        //     if (s.charAt(i) == '0') zerosCount++; //2
        //     else onesCount++; //3

        //     // Calculate score
        //     int currentScore = zerosCount + (totalOnes - onesCount); //
        //     bestScore = Math.max(bestScore, currentScore);

        // }

        // return bestScore;

        int n = s.length();
        int ons = 0;
        int curr = s.charAt(0) == '0' ? 1 : 0;
        int score = curr;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                curr++;
            } else {
                ons++;
                curr--;
            }
            if (curr > score) {
                score = curr;
            }
        }
        ons += s.charAt(n - 1) == '1' ? 1 : 0;

        return ons + score;

    }
}
