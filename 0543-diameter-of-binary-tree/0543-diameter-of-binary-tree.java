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
        int dia;
    }
    public Pair diameter_(TreeNode root){
        if(root == null){
            Pair bp = new Pair();
            bp.ht = -1;
            bp.dia = 0;

            return bp;
        }
        
        Pair lp = diameter_(root.left);
        Pair rp = diameter_(root.right);

        Pair mp = new Pair();
        mp.ht = Math.max(lp.ht , rp.ht) + 1;
        int size  = lp.ht + rp.ht + 2;
        mp.dia = Math.max(size , Math.max(lp.dia , rp.dia));

        return mp;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter_(root).dia;
    }
}