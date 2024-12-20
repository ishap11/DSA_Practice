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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;

        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        ms.push(root);
        boolean isOddLevel = false;

        while(!ms.isEmpty()) {
            List<TreeNode> levelNode = new ArrayList<>();

            while(!ms.isEmpty()) {
                TreeNode node = ms.pop();
                levelNode.add(node);

                if (node.left != null) cs.push(node.left);
                if (node.right != null) cs.push(node.right);
            }

            if(isOddLevel ) {
                int left =  0;
                int right =  levelNode.size() - 1;

                while(left < right) {
                    int temp = levelNode.get(left).val ;
                    levelNode.get(left).val = levelNode.get(right).val;
                    levelNode.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            Stack<TreeNode> temp = ms;
            ms = cs;
            cs = temp;
            isOddLevel = !isOddLevel;

        }
        return root;
    }
}