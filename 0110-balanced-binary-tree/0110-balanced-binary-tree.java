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
    public class Pair{
        int ht;
        boolean isBal;
    }

    private Pair isBalance(TreeNode root) {
        if(root == null) {
            Pair bp = new Pair();
            bp.ht = 0;
            bp.isBal = true;
            return bp;
        }

        Pair lp = isBalance(root.left);
        Pair rp = isBalance(root.right);

        Pair mp = new Pair();
        mp.isBal = Math.abs(lp.ht - rp.ht) <= 1 && lp.isBal && rp.isBal;
        mp.ht = Math.max(lp.ht , rp.ht) + 1;

        return mp;
    }
    public boolean isBalanced(TreeNode root) {
        return isBalance(root).isBal;
    }
}