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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String , Integer> map = new HashMap<>();
        getSubtree(root , map  , ans);
        return ans;
    }

    private String getSubtree(TreeNode root , HashMap<String , Integer> map , List<TreeNode> ans ) {
        if(root == null) return "#";

        String s = root.val + "," + getSubtree(root.left , map , ans) + ","  + getSubtree(root.right , map  , ans);

        map.put(s, map.getOrDefault(s, 0) + 1);

        if (map.get(s) == 2) {  // add only when we see the second occurrence
            ans.add(root);
        }

        return s ;
    }
}