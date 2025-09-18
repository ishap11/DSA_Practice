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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        boolean leftToRight = true;

        st1.push(root);

        while(!st1.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            while(!st1.isEmpty()){
                TreeNode node = st1.pop();

                level.add(node.val);

                if(leftToRight){
                    if(node.left != null) st2.push(node.left);
                    if(node.right != null) st2.push(node.right);
                }else{
                    if(node.right != null) st2.push(node.right);
                    if(node.left != null) st2.push(node.left);
                }
            }
            ans.add(level);

            Stack<TreeNode> temp = st1;
            st1 = st2;
            st2 = temp; 
            leftToRight = !leftToRight;
        }

        return ans;
        
    }
}