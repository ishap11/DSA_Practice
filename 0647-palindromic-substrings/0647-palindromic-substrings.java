class Solution {
    public int countSubstrings(String s) {
        int count =  0;

        for(int center = 0 ; center < s.length() ; center++){
            count += expandAroundCenter(s , center , center);
            count += expandAroundCenter(s , center , center + 1);
        }

        return count;
    }

    private int expandAroundCenter(String s , int left , int right){
        int cnt = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            cnt++;
            left--;
            right++;
        }

        return cnt;
    }
}