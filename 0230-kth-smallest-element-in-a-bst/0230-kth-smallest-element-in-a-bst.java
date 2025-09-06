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
    private TreeNode getRightMostNode(TreeNode leftNode , TreeNode curr){
        while(leftNode.right != curr && leftNode.right != null){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count  = 0;

        while(curr != null){
            TreeNode leftNode = curr.left;

            if(leftNode == null) {
                count++;
                if(count == k){
                    return curr.val;
                }
                curr = curr.right;
            }
            else{
                TreeNode rmn = getRightMostNode(leftNode , curr);
                if(rmn.right == null){
                    rmn.right = curr;
                    curr = curr.left;
                }else{
                    rmn.right = null;
                    count++;
                    if(count == k) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}