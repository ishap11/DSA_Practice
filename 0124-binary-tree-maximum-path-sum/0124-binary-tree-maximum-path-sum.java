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
    int maxsum = Integer.MIN_VALUE; 

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxsum; 
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0; 
        }

        int left = Math.max(0, calculateMaxPathSum(node.left));
        int right = Math.max(0, calculateMaxPathSum(node.right));

        maxsum = Math.max(maxsum, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
