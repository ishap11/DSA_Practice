class Solution {
    public long pickGifts(int[] gifts, int k) {
        Arrays.sort(gifts);

        int i = gifts.length -1 ;
        while(k != 0 ) {
            gifts[i] = (int) Math.sqrt(Math.floor(gifts[i]));
  
            Arrays.sort(gifts); 
            i = gifts.length - 1;  
            k--; 
        }

        long sum =  0;
        for(int j= 0 ; j< gifts.length ; j++){
            sum += gifts[j];
        }
        return sum;
    }
}