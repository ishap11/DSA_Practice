class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // TLE
        // int n = values.length;
        // int maxScore = Integer.MIN_VALUE; 
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int score = values[i] + values[j] + i - j;
        //         maxScore = Math.max(maxScore, score);
        //     }
        // }
        
        // return maxScore;


        int n = values.length;
        int max_score = Integer.MIN_VALUE; 
        int max_left = values[0];
        
        for (int j = 1; j < n; j++) {
            int score = max_left + values[j] - j;
            // Update the maximum score
            max_score  = Math.max(max_score , score);
            // Update maxLeft for the next iteration
            max_left = Math.max(max_left, values[j] + j);
        }
        
        return max_score;
    }
}