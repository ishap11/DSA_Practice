class Solution {
     public long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        /*  good numbers ==> b/w (0-9)  -> 
        "if the digits at even indices are even and the digits at odd indices are prime"
        even no. => 0 , 2, 4, 6, 8   ...... total 5 numbers
        prime no. => 2, 3, 5 , 7     ......total 4 numbers
         */

        /*
        //  Brute force - TLE  TC->O(N)
        long ans = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // even index
                ans = (ans * 5) % MOD;
            } else {
                // odd index
                ans = (ans * 4) % MOD;
            }
        }
        return (int) ans;
        */

        // optimized approach - TC->O(logy) --> pre-requistic -> pow(x,n)
        // find no. of odd places and no. of even places
        long even = (n+1)/2;
        long odd = n/2;

        return (int)(power(5,even)*power(4,odd)%MOD);

    }
    public long power(long x , long n){
        if(n==0){
            return 1;
        }

        long temp = power(x, n / 2);
        // If n is even, return (x^(n/2))^2
        if(n%2==0){
            return (temp * temp)% MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else{
            return (x * temp * temp)% MOD;
        }
    }
}