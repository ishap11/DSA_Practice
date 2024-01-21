class Solution {
    public double myPow(double x, int n) {
       // TC - O(logn) Sc - O(logn)
        if (n == 0) {
            return 1;
        }
        double xpnb2 = myPow(x, n / 2);
        double xpn = xpnb2 * xpnb2;

        if (n % 2 == 1) {
            xpn = xpn * x; // For odd exponent, multiply by x.
        } else if (n % 2 == -1) {
            // For negative odd exponent, divide by x.
            xpn /= x;
        }
        return xpn;
    }
}