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
    public class vPair {
        TreeNode node = null;
        int hl  = 0;

        vPair(TreeNode node , int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    public void width(TreeNode root , int hl , int[] minMax) {
        if(root == null) return;

        minMax[0] = Math.min(minMax[0] , hl);
        minMax[1] = Math.max(minMax[1] , hl);

        width(root.left , hl - 1 , minMax);
        width(root.right , hl + 1 , minMax);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<vPair> parQue = new PriorityQueue<>((a, b) -> { return a.node.val - b.node.val; });
        PriorityQueue<vPair> chQue = new PriorityQueue<>((a,b)->{ return a.node.val - b.node.val; } );

        int [] minMax = new int[2];
        width(root , 0 , minMax);

        int len = minMax[1] - minMax[0] + 1;
        for(int i=0 ; i< len ; i++) {
            ans.add(new ArrayList<>());
        }

        parQue.add(new vPair(root , Math.abs(minMax[0])));

        while(parQue.size() > 0) {
            int size = parQue.size();

            while(size-- > 0) {
                vPair rp = parQue.remove();
                TreeNode node = rp.node;
                int hl = rp.hl;

                ans.get(hl).add(node.val);

                if(node.left != null) {
                    chQue.add(new vPair(node.left , hl - 1));
                }
                if(node.right != null) {
                    chQue.add(new vPair(node.right , hl + 1));
                }

            }

            PriorityQueue<vPair> temp = parQue;
            parQue = chQue;
            chQue = temp;
        }
        return ans;
    }
}