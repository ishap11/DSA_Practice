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
    public int rangeSumBST(TreeNode root, int low, int high) {
         if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            // Traverse both subtrees, as they might contain other nodes in the range.
            sum += rangeSumBST(root.left, low, high);
            sum += rangeSumBST(root.right, low, high);
        } 
        // If the current node's value is less than the low bound, 
        // all values in its left subtree will also be too small.
        // We only need to check the right subtree.
        else if (root.val < low) {
            sum += rangeSumBST(root.right, low, high);
        }
        // If the current node's value is greater than the high bound,
        // all values in its right subtree will also be too large.
        // We only need to check the left subtree.
        else { // root.val > high
            sum += rangeSumBST(root.left, low, high);
        }
        
        return sum;
    }
}