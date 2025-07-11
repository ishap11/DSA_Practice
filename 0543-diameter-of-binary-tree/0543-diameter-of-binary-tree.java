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
    public class DiaPair {
        int ht ;
        int dia;
    }

    private DiaPair diameterOfBinaryTree_(TreeNode root) {
        if(root == null) {
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }

        DiaPair lp = diameterOfBinaryTree_(root.left);
        DiaPair rp = diameterOfBinaryTree_(root.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht , rp.ht) + 1;
        int size = lp.ht + rp.ht + 2;

        mp.dia = Math.max(size , Math.max(lp.dia , rp.dia));
        return mp;
    } 
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTree_(root).dia;
    }
}