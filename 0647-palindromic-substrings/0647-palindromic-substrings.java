class Solution {

    private int isPalindrome(String s , int i , int j) {
        int count =  0;

        while(i>= 0 && j< s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;

        for(int i=0; i< s.length() ; i++) {

            count+= isPalindrome(s , i , i);
            count+= isPalindrome(s , i , i+1);
        }
        return count;



        // int count =  0;
        // for(int i =0 ; i< s.length() ; i++) {
        //     for(int j= i+1  ; j<= s.length() ; j++) {
        //         String sub = s.substring(i , j);

        //         if (isPalindrome(sub)) {
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }

    // public boolean isPalindrome(String str) {
    //     int left = 0;
    //     int right = str.length() - 1;

    //     while(left < right) {
    //         if(str.charAt(left) != str.charAt(right) ) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
}