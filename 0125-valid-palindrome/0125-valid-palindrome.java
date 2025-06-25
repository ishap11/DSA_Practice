class Solution {
    public boolean isPalindrome(String s) {
        // String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]" , "");
        // int i= 0;
        // int j = str.length() -1;

        // while(i<= j) {
        //     if(str.charAt(i) != str.charAt(j)) {
        //         return false;
        //     }else{
        //         i++;
        //         j--;
        //     }
        // }
        // return true;

        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String str = sb.toString();
        int i= 0;
        int j = str.length() -1;

        while(i<= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}