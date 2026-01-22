class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1 , n ,  k , new ArrayList<>() , ans);

        return ans;
    }

    public void solve(int st , int n , int k , List<Integer> res , List<List<Integer>> ans){
        if(res.size() == k){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = st ; i <= n ; i++){
            res.add(i);
            solve(i + 1 , n , k , res , ans);
            res.remove(res.size() - 1);
        }
    }
}