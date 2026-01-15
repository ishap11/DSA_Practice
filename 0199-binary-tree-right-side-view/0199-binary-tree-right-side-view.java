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

        if(root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        Integer rightMostVal = null;

        while(que.size() > 0){
            int size = que.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode node = que.remove();
                rightMostVal = node.val;

                if(node.left != null){
                    que.add(node.left);
                }

                if(node.right != null){
                    que.add(node.right);
                }
            }
            ans.add(rightMostVal);
        }

        return ans;
    }
}