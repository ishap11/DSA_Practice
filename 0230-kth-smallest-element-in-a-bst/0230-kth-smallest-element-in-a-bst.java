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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        
        // In-order traversal
        while (root != null || !st.isEmpty()) {
            // Traverse the left subtree
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            // Pop the top node from the stack
            root = st.pop();
            
            // Decrement k, as we've visited one more node
            k--;
            
            // If k is 0, we've found the k-th smallest element
            if (k == 0) {
                return root.val;
            }
            
            // Move to the right subtree
            root = root.right;
        }
         throw new IllegalArgumentException("k is larger than the number of nodes in the tree");
    }
}