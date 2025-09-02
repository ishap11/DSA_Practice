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

        preorder(root1, leaf1);
        preorder(root2 , leaf2);

        return leaf1.equals(leaf2);
    }

    public void preorder(TreeNode root , List<Integer> leaf){
        if(root == null) return;

        if(root.left == null && root.right == null){
            leaf.add(root.val);
        }

        preorder(root.left , leaf);
        preorder(root.right , leaf);
    }
}