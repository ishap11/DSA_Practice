/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serialize_(root , sb);
        return sb.toString();
    }

    public void serialize_(TreeNode root , StringBuilder sb ) {
        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        serialize_(root.left , sb);
        serialize_(root.right , sb);
    }

    // Decodes your encoded data to tree.
    static int idx = 0;
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }

        idx = 0;
        String[] arr = data.split(",");
        return deserialize_(arr);
    }

    public TreeNode deserialize_(String[] arr){
        if(idx >= arr.length|| arr[idx].equals("null")){
            idx++;
            return null;
        }


        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize_(arr);
        node.right = deserialize_(arr);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));