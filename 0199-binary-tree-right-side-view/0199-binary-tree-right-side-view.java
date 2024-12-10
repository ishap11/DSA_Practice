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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer rightmostValue = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rightmostValue = node.val; // Keep updating to the last node's value in this level
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            ans.add(rightmostValue); // Add the last node value of this level to the result
        }

        return ans;
    }
}