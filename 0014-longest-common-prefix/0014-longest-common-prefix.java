class Solution {
    public class Node {
        Node[] childs = new Node[26];
        boolean isEnd = false;
    }

    public void insert(Node curr , String s) {
        for(int i=0 ; i< s.length() ; i++) {
            char ch = s.charAt(i);

            if(curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }
            curr = curr.childs[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        
        Node root = new Node();

        for(String s : strs) {
            insert(root , s);
        }

        StringBuilder sb = new StringBuilder();
        Node curr = root;
       
        while (true) {
            int count = 0;
            int nextIdx = -1;

            // Check how many children this node has
            for (int i = 0; i < 26; i++) {
                if (curr.childs[i] != null) {
                    count++;
                    nextIdx = i;
                }
            }

            // ✅ Stop if there is more than one branch or end of word
            if (count == 1 && !curr.isEnd) {
                sb.append((char) (nextIdx + 'a'));
                curr = curr.childs[nextIdx];
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
