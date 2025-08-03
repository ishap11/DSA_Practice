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
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while(que.size() > 0) {
            int count = que.size();

            List<Integer> res = new ArrayList<>();

            for(int i=0; i< count ; i++) {
                root = que.remove();
                res.add(root.val);

                if(root.left != null) {
                    que.add(root.left);
                }
                if(root.right != null) {
                    que.add(root.right);
                }
            }

            ans.add(res);
        }
        return ans;
    }
}