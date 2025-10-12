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

        if (root == null)  // check for null root
        return ans;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while(que.size() > 0){
            int size = que.size();
            List<Integer> res = new ArrayList<>();

            for(int i = 0 ; i< size ; i++){
                TreeNode node = que.remove();
                res.add(node.val);

                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
            ans.add(res);
        }
        return ans;
    }
}