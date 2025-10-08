class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        
        double xpnb2 = myPow(x, n/2);
        double xpn = xpnb2 * xpnb2;

        if(n % 2 == 1){
            xpn *= x;
        }else if(n % 2 == -1){
            xpn /= x;
        }

        return xpn;
    }
}