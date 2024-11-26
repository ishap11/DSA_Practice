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
    static boolean isBal;
    public int isBalancedHelper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left  = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);

        int gap  = Math.abs(left - right);
        if(gap > 1){
            isBal = false;
        }
        return Math.max(left, right) + 1; // Return height of the current subtree
    }
    public boolean isBalanced(TreeNode root) {
        isBal = true; // Reset before starting
        isBalancedHelper(root); // Perform recursive height checks
        return isBal; // Return the final result
    }
}