class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Wrong Answer 70 / 130 testcases passed
		// int countOnes = 0;
        // for(int i=0; i< flowerbed.length ; i++) {
		//     if (flowerbed[i] == 1 ) countOnes++;
		// }
		// if(countOnes %2 == 0 && n %2 != 0 ) {
		// 	return true;
		// }else {
		// 	return false;
		// }


        
        int max = 0;
        int fi = -1;
        int li = -1;

        for(int i= 0 ; i< flowerbed.length ; i++) {
            if( flowerbed[i] == 0) {
                continue;
            }else if(fi == -1) {
                fi = i;
                li = i;
            }else {
                li =  i ;
            }
        }
        // all zeroes 
        if(fi == -1) {
            max = (flowerbed.length + 1) /2;
        }else {
            int left = fi;
            int right =flowerbed.length -1 - li ;

            max = left/2;
            max += right/2;

            int count =0;
            for(int i=fi +1; i <= li -1; i++) {
                if(flowerbed[i] == 0) {
                    count++;
                }else {
                    max += (count -1)/2;
                    count = 0;
                }
            }
            max += (count -1)/2;
        }

        return n <= max;
    }
}