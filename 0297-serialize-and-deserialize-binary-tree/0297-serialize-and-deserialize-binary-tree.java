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

    public void serialize(TreeNode root , StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serialize(root.left , sb);
        serialize(root.right , sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root , sb);
        return sb.toString();
    }

    static int idx = 0;
    public TreeNode deserialize(String[] arr) {
        if(idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        idx=  0;
        String[] arr = data.split(",");

        return deserialize(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));