class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
				
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                st.push(s.charAt(i)); 
            } else if (!st.isEmpty()) {
                st.pop(); 
            }
        }

        // Convert stack content back to a string
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString(); // Reverse because stack is LIFO

    }
}