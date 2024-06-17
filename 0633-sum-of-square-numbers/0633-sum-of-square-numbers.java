class Solution {
    public boolean judgeSquareSum(int c) {

        // for(long i=0; i*i <= c ; i++){
        //     long bs = c - i*i;
        //     if(isPerfectSquare(bs)){
        //         return true;
        //     }
        // }
        // return false;


        // binary search
        long left =0; 
        long right = (long)Math.sqrt(c);
       
        while(left <= right){
            long sum = left*left + right*right;
            if(sum == c){
                return true;
            }else if(sum < c){
                left++;
            }else{
                right--;
            }
        }
        return false;

    }

    // public static boolean isPerfectSquare(long n) {
    //     if(n ==0 || n ==1 ){
    //         return true;
    //     }
	// 	long start = 1;
	// 	long end = n;
	// 	long ans = 0;

	// 	while(start <= end){
	// 		long mid = (start + end)/2;

	// 		if(mid*mid == n){
	// 			return true;
	// 		}
	// 		else if(mid*mid < n){
	// 			start = mid +1;
	// 		}else{
	// 			end = mid -1;
	// 		}
	// 	}
	// 	return false;
    // }

}