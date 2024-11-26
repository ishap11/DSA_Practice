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
    public class BSTPair {
        boolean isBST ;
        long min;
        long max;
    }
    public BSTPair isBST(TreeNode root) {
        if(root == null){
            BSTPair basePair = new BSTPair();
            basePair.isBST = true;
            basePair.min = Long.MAX_VALUE;
            basePair.max = Long.MIN_VALUE;

            return basePair;
        }

        BSTPair leftPair = isBST(root.left);
        BSTPair rightPair = isBST(root.right);

        BSTPair mainPair = new BSTPair();
        mainPair.isBST = leftPair.isBST && rightPair.isBST && (root.val > leftPair.max) && (root.val < rightPair.min);
        mainPair.min = Math.min(root.val , Math.min(leftPair.min , rightPair.min)); 
        mainPair.max = Math.max(root.val , Math.max(leftPair.max , rightPair.max));

        return mainPair; 
    }


    public boolean isValidBST(TreeNode root) {
        return isBST(root).isBST; // Extract the isBST property from the BSTPair object
    }
}