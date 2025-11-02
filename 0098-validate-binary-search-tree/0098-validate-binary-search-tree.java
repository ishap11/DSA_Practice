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
        long min;
        long max;
        boolean isBST;
    }
    public Pair isValidBST_(TreeNode root) {
        if(root == null){
            Pair bp = new Pair();
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;
            bp.isBST = true;

            return bp;
        }

        Pair lp = isValidBST_(root.left);
        Pair rp = isValidBST_(root.right);


        Pair mp = new Pair();
        mp.isBST = lp.isBST && rp.isBST && (lp.max < root.val && root.val < rp.min);
        mp.min = Math.min(root.val , Math.min(lp.min , rp.min));
        mp.max = Math.max(root.val , Math.max(lp.max , rp.max));

        return mp;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST_(root).isBST;
    }
}