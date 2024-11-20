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
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();
        // TreeNode node = root;

        // while(node !=null || !st.isEmpty()){
        //     while(node != null){
        //         st.push(node);
        //         list.add(node.val);
        //         node = node.left;
        //     }
        //     node=st.pop();
        //     node = node.right;
        // }
        // return list;

        ArrayList<Integer> ans = new ArrayList<>(); //to store answers
        preorder(root, ans);
        return ans;
    }
    public void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        
        ans.add(root.val); // Add current node's value
        preorder(root.left, ans); // Recursion on left subtree
        preorder(root.right, ans); // Recursion on right subtree
    }
}