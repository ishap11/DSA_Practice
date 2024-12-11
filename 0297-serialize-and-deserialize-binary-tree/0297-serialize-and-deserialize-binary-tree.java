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

    // helper code 
    public void serializeHelper(TreeNode root , StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serializeHelper(root.left , sb);
        serializeHelper(root.right , sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root , sb);
        return sb.toString();
    }

    // helper code
    static int idx = 0;
    public TreeNode deserializeHelpr(String[] arr) {
         if(idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserializeHelpr(arr);
        node.right = deserializeHelpr(arr);

        return node;

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if (data == null || data.isEmpty()) {
            return null;
        }
         idx = 0;
        String[] arr = data.split(",");
        return deserializeHelpr(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));