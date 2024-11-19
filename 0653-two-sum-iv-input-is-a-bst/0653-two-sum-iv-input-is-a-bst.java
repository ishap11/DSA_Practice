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
    public static class ITPair {
        TreeNode root ;
        int state =0;

        ITPair(TreeNode root , int state){
            this.root = root;
            this.state = state;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        Stack<ITPair> ls =  new Stack<>();
        Stack<ITPair> rs = new Stack<>();

        ls.push(new ITPair(root , 0));
        rs.push(new ITPair(root , 0));

        TreeNode left =  getNextFromNormalInorder(ls);
        TreeNode right = getNextFromReverseInorder(rs);

        while(left.val < right.val){
            if(left.val + right.val  < k){
                left = getNextFromNormalInorder(ls);
            }else if(left.val + right.val > k){
                right = getNextFromReverseInorder(rs);
            }else{
                left =  getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
                return true;
            }
        }
        return false;
    }
    public TreeNode getNextFromNormalInorder(Stack<ITPair> st) {
        while(st.size() > 0){
            ITPair top  = st.peek();
            if(top.state == 0){
                if(top.root.left != null){
                    st.push(new ITPair(top.root.left , 0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.root.right != null){
                    st.push(new ITPair(top.root.right , 0));
                }
                top.state++;
                return top.root;
            }else{
                st.pop();
            }
        }
        return null;
    }
    public TreeNode getNextFromReverseInorder(Stack<ITPair> st) {
        while(st.size() > 0){
            ITPair top  = st.peek();
            if(top.state == 0){
                if(top.root.right != null){
                    st.push(new ITPair(top.root.right , 0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.root.left != null){
                    st.push(new ITPair(top.root.left , 0));
                }
                top.state++;
                return top.root;
            }else{
                st.pop();
            }
        }
        return null;
    }
}