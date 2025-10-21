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
    public class BSTPair{
        int min;
        int max;
        boolean isBST;
    }
    
    public BSTPair isValidBST_(TreeNode root){
        if(root == null){
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;

            return bp;
        }

        BSTPair lp = isValidBST_(root.left);
        BSTPair rp = isValidBST_(root.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (root.val > lp.max && root.val < rp.min);
        mp.min = Math.min(root.val , Math.min(lp.min , rp.min));
        mp.max = Math.max(root.val , Math.max(lp.max , rp.max));

        return mp;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST_(root).isBST;
    }
}