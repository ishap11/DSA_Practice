class Solution {
    public int distributeCandies(int[] candyType) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< candyType.length  ;i++){
            if(!set.contains(candyType[i])){
                set.add(candyType[i]);
            }
        }
        int n=candyType.length/2;
        if(n>=set.size()){
            return set.size();
        }
        else{
            return n;
        }
    }
}