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
        boolean isBST;
        long min;
        long max;
    }

    public BSTPair isBST_(TreeNode root) {
        if(root == null) {
            BSTPair bp =new BSTPair();
            bp.isBST = true;
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;

            return bp;
        }

        BSTPair lp = isBST_(root.left) ;
        BSTPair rp = isBST_(root.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (root.val > lp.max && root.val < rp.min);
        mp.min = Math.min(root.val , Math.min(lp.min , rp.min));
        mp.max = Math.max(root.val , Math.max(lp.max, rp.max));

        return mp;
    }
    public boolean isValidBST(TreeNode root) {
        return isBST_(root).isBST;
    }
}