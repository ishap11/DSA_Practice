class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        // odd case
        for(int ax = 0; ax < s.length() ; ax++){
            int orb = 1;
            int len = 1;

            while(ax - orb >= 0 && ax + orb < s.length()){
                if(s.charAt(ax - orb) == s.charAt(ax + orb)) {
                    orb++;
                    len += 2;
                }else{
                    break;
                }
            }

            if(len > res.length()) {
                int si = ax - len/2;
                res = s.substring(si , si + len);
            }
        }

        // even 
        for(int ax = 0; ax < s.length() - 1 ; ax++){
            int orb = 1;
            int len = 0;

            while(ax - orb + 1 >= 0 && ax + orb < s.length()) {
                if(s.charAt(ax - orb + 1) == s.charAt(ax + orb)) {
                    orb++;
                    len += 2;
                }else{
                    break;
                }
            }

            if(len > res.length()) {
                int si = ax - len/2 + 1;
                res = s.substring(si , si + len);
            }
        }

        return res;



        // ~~~~~~~~~~~~~~~~~~~~~ APPROACH - 1 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // if (s == null || s.length() < 1) return "";
        // String longest = "";

        // for(int i=0 ; i< s.length() ; i++){
        //     for(int j= i ; j< s.length() ; j++) {
        //         String sub = s.substring(i , j+1);
        //         if (isPalindrome(sub) && sub.length() > longest.length()) {
        //             longest = sub;
        //         }
        //     }
        // }
        // return longest;
    }

    // public boolean isPalindrome(String str) {
    //     int left = 0;
    //     int right = str.length() - 1;

    //     while (left < right) {
    //         if (str.charAt(left) != str.charAt(right))
    //             return false;
    //         left++;
    //         right--;
    //     }

    //     return true;
        
    // }
}