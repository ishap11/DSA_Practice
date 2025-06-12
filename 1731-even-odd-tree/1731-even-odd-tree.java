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
    public boolean isEvenOddTree(TreeNode root) {
         if (root == null) return true;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                int val = curr.val;

                // ✅ Parity check and order check
                if (level % 2 == 0) {
                    // Even level: must be odd & increasing
                    if (val % 2 == 0 || val <= prev) return false;
                } else {
                    // Odd level: must be even & decreasing
                    if (val % 2 == 1 || val >= prev) return false;
                }

                prev = val;

                // ✅ Add children to queue
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            level++;
        }

        return true;
    }
}