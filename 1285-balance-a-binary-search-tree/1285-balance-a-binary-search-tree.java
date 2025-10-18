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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root , list);
        return balancedBST(list , 0 , list.size() - 1);
    }

    void inorder(TreeNode root , ArrayList<Integer> list){
        if(root == null) return;

        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
    }

    TreeNode balancedBST(ArrayList<Integer> list , int lo , int hi){
        if(lo > hi) return null;

        int mid = (lo + hi)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = balancedBST(list , lo , mid - 1);
        node.right = balancedBST(list , mid + 1 , hi);

        return node;
    }
}