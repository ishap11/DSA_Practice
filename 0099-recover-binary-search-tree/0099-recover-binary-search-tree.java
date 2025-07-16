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
    public TreeNode getRightMostTree(TreeNode node , TreeNode curr){
        while(node.right != null && node.right != curr){
            node = node.right;
        }
        return node;
    }
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode a = null;
        TreeNode b = null;

        while(curr != null) {
            TreeNode leftNode = curr.left;

            if(leftNode == null) {
                if(prev != null && prev.val > curr.val) {
                    if(a == null){
                        a = prev;
                    }
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            }else {
                TreeNode rmn = getRightMostTree(leftNode , curr);

                if(rmn.right == null) {
                    rmn.right = curr;
                    curr = curr.left;
                }else {
                    rmn.right = null;
                    if(prev.val > curr.val) {
                        if(a == null){
                            a = prev;
                        }
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        if(a != null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        } 
    }
}