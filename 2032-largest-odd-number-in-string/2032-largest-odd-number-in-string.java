class Solution {
    public String largestOddNumber(String num) {
        String ans = "";
        
        // Loop through the string from the end to the beginning
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                ans = num.substring(0, i + 1);
                return ans;  
            }
        }
        return "";
    }
}