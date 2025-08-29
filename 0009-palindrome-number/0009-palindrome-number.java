class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        if(x == 0) return true;

        int originalNo = x;
        int ans = 0;

        while(x != 0) {
            int rem = x % 10;
            x = x/10;

            ans = ans * 10 + rem;
        }

        return ans == originalNo;
    }
}