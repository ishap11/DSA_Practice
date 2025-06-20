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
    private TreeNode getRmn(TreeNode rmn  , TreeNode curr) {
        while(rmn.right != null && rmn.right != curr) {
            rmn = rmn.right;
        } 
        return rmn;
    }
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null; // used to connect flattened nodes

        while (curr != null) {
            TreeNode leftNode = curr.left;

            if (leftNode == null) {
                // If there's no left child, move to the right
                if (prev != null) {
                    prev.right = curr;
                    prev.left = null; // maintain left null
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode rmn = getRmn(leftNode, curr);

                if (rmn.right == null) {
                    rmn.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;

                    if (prev != null) {
                        prev.right = curr;
                        prev.left = null;
                    }

                    prev = curr;
                    curr = curr.right;
                } else {
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}