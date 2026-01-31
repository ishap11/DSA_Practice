class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        int[] count = new int[1];
        HashMap<Long , Integer> map = new HashMap<>();
        solve(root , targetSum , map , 0L , count);
        return count[0];
    }

    public void solve(TreeNode root, int k , HashMap<Long , Integer> map , long sum , int[] count){
        if(root == null) return;

        sum += root.val;

        if(sum == k) count[0]++;

        if(map.containsKey(sum - k))  
            count[0] += map.get(sum - k);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        solve(root.left , k , map , sum , count);
        solve(root.right , k , map , sum , count);

        map.put(sum, map.get(sum) - 1);
    }
}
