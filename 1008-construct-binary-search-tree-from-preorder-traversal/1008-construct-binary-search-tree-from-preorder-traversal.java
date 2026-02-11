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
    private int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
       return bstFromPreorder_(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder_(int[] preorder , int l , int r){
        if(idx >= preorder.length || preorder[idx] < l  || preorder[idx] > r){
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = bstFromPreorder_(preorder , l , root.val );
        root.right = bstFromPreorder_(preorder , root.val , r);

        return root;
    }
}