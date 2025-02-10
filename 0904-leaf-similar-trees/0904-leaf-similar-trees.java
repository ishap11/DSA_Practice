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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        preorder(root1 , leaf1);
        preorder(root2 , leaf2);

        return leaf1.equals(leaf2);
    }
    
    public void preorder(TreeNode node , List<Integer> leaf) {
        if(node == null) {
            return ;
        }
        if (node.left == null && node.right == null) {
            leaf.add(node.val);
        }
        
        preorder(node.left, leaf);
        preorder(node.right, leaf);
    }

}