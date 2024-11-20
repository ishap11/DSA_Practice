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
    public List<Integer> postorderTraversal(TreeNode root) {
    
        // List<Integer> ans = new ArrayList<>();
        // postorder(root , ans);
        // return ans;


        // usng 2 stacks
        // List<Integer> ans = new ArrayList<Integer>();
        // Stack<TreeNode> st1 = new Stack<TreeNode>();
        // Stack<TreeNode> st2 =  new Stack<TreeNode>();

        // if(root == null){
        //     return ans;
        // }
        // st1.push(root);
        // while(!st1.isEmpty()){
        //     root=  st1.pop();
        //     st2.add(root);

        //     if(root.left != null) {
        //         st1.push(root.left);
        //     }
        //     if(root.right != null){
        //         st1.push(root.right);
        //     }
        // }
        // while(!st2.isEmpty()){
        //     ans.add(st2.pop().val);
        // }
        // return ans;



        // using 1 stack
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();

        TreeNode curr = root;

        while(curr!= null  || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp =  st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.val);

                    while(!st.isEmpty()  && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return ans;
    }
    // public void postorder(TreeNode root , List<Integer> ans ){
    //     if(root == null){
    //         return ;
    //     }
    //     postorder(root.left , ans);
    //     postorder(root.right , ans);
    //     ans.add(root.val);
    // }
}