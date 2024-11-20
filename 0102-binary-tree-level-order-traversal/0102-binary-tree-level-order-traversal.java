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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> res = new ArrayList<>();
        // if (root == null) return res;

        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);

        // while (!queue.isEmpty()) {
        //     int levelsize = queue.size();
        //     List<Integer> currlevel = new ArrayList<>();

        //     for (int i = 0; i < levelsize; i++) {
        //         TreeNode currNode = queue.poll();

        //         currlevel.add(currNode.val);
        //         if (currNode.left != null) queue.add(currNode.left);
        //         if (currNode.right != null) queue.add(currNode.right);
        //     }

        //     res.add(currlevel);
        // }

        // return res;


        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();

            // Create a temporary list to store values of nodes at this level.
            List<Integer> currLevel = new ArrayList<>();

            // Process each node at the current level.
            for (int i = 0; i < count; i++) {
                TreeNode currNode = queue.remove(); // Dequeue the front node.
                
                // Add the value of the current node to the current level's list.
                currLevel.add(currNode.val);

                // If the left child exists, enqueue it for the next level.
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                // If the right child exists, enqueue it for the next level.
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }

            // After processing all nodes at the current level, add the level's list to the result.
            ans.add(currLevel);
        }
        return ans;
    }
}