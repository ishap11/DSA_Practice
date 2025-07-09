/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void pathSum_(TreeNode root , int targetSum , List<List<Integer>> ans , List<Integer> smallAns) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            if(targetSum - root.val == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                base.add(root.val);
                ans.add(base);
            }
            return;
        }

        smallAns.add(root.val);
        pathSum_(root.left , targetSum - root.val , ans , smallAns);
        pathSum_(root.right , targetSum - root.val , ans , smallAns);

        smallAns.remove(smallAns.size() - 1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        pathSum_(root, targetSum ,ans ,smallAns);

        return ans;
    }
}