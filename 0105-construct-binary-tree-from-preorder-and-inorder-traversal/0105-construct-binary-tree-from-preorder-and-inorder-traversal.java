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
    public TreeNode buildTree_(int[] preorder, int psi , int pei , int[] inorder , int isi , int iei) {

        if(isi > iei) return null;

        int idx = isi;
        while(inorder[idx] != preorder[psi]) {
            idx++;
        }
        int colse = idx - isi;


        TreeNode root = new TreeNode(preorder[psi]);
        root.left = buildTree_(preorder , psi + 1 , psi + colse , inorder , isi , idx - 1);
        root.right = buildTree_(preorder , psi + colse + 1 , pei , inorder,  idx + 1 , iei);

        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree_(preorder , 0 , n-1 , inorder , 0 , n-1);
    }
}