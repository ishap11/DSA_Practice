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
    static class DiaPair{
        int ht;
        int dia;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).dia; 
    }
    private DiaPair helper(TreeNode root) {
        if(root == null){
            DiaPair basepair = new DiaPair();
            basepair.ht = -1;
            basepair.dia = 0;
            return basepair;
        }
        DiaPair leftpair = helper(root.left);
        DiaPair rightpair = helper(root.right);

        DiaPair mypair = new DiaPair();
        mypair.ht = Math.max(leftpair.ht , rightpair.ht) +1;
        int size  = leftpair.ht + rightpair.ht + 2;

        mypair.dia = Math.max(size, Math.max(leftpair.dia , rightpair.dia));

        return mypair;
    }
}