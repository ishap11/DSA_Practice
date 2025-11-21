class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        
        generateCombinations(1 , n  , k , new ArrayList<>() , ans);
        return ans;
    }

    public void generateCombinations(int st , int n , int k , List<Integer> res , List<List<Integer>> ans){
        if(res.size() == k){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = st ; i <= n ;i++){
            res.add(i);
            generateCombinations(i+1 , n , k , res , ans);
            res.remove(res.size() - 1);
        }
    }
}