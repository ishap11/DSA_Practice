class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] bool = new boolean[n];
        for (int i = 2; i< bool.length; i++) {
            bool[i] = true;
        }
        for (int i = 2; i< Math.sqrt(n);i++){
            if(bool[i] == true) {
                for(int j = (i*i); j<n; j = j+i) {
                    bool[j] = false;
                }
            }
        }  
        int count=0;
        for(int i=2;i<n;i++){
            if(bool[i]==true){
                count++;
            }
        }
        return count;     
    }
}