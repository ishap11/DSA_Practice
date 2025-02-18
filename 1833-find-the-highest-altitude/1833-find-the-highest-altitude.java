class Solution {
    public int largestAltitude(int[] gain) {
        // int max_height = Integee.MIN_VALUE;
        // int height =0;

        // for(int i=1 ; i< gain.length ; i++){
        //     gain[i] = gain[i-1]  + gain[i];
        //     max_height = Math.max(max_height , gain[i]);
        // }

        // return max_height >0 :  max_height ?0  ;

        int max_height = 0;
        int height = 0;
        
        for (int i = 0; i < gain.length; i++) {
            height += gain[i];
            max_height = Math.max(max_height, height);
        }
        
        return max_height;
    }
}