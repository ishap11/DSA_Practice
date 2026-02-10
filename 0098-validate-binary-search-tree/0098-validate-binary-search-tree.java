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
    class Pair{
        long min;
        long max;
        boolean isBst;
    }

    public Pair isValidBST_(TreeNode root) {
        if(root == null){
            Pair bp = new Pair();
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;
            bp.isBst= true;

            return bp;
        }

        Pair lp = isValidBST_(root.left);
        Pair rp = isValidBST_(root.right);
        Pair mp = new Pair();
        mp.isBst = lp.isBst && rp.isBst && (lp.max <= root.val && rp.min >= root.val);
        mp.min = Math.min(root.val , Math.min(rp.min , lp.min));
        mp.max = Math.max(root.val , Math.max(rp.max , lp.max));

        return mp;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST_(root).isBst;
    }
}