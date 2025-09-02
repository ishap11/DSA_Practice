class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1 , n , k , new ArrayList<>() , ans);
        return ans;
    }

    private void backtrack(int start , int n , int k , List<Integer> res , List<List<Integer>> ans) {
        if(res.size() == k) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = start ; i<=n ; i++) {
            res.add(i);
            backtrack(i+1 , n , k , res , ans);
            res.remove(res.size() - 1);
        }
    }
}