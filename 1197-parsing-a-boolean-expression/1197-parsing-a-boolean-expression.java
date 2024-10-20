class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if(ch == '!'|| ch == '|' || ch == '&' || ch =='f' || ch == 't'){
                st.push(ch);
            }
            if(ch == '(' ||ch == ','){
                continue;
            }
            if(ch == ')'){
                boolean hasTrue = false, hasFalse = false;

                while(st.peek() != '|' && st.peek() !='&' && st.peek() != '!'){
                    char topValue = st.pop();
                    if (topValue == 't') hasTrue = true;
                    if (topValue == 'f') hasFalse = true;
                }

                char op = st.pop();
                if (op == '!') {
                    st.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    st.push(hasFalse ? 'f' : 't');
                } else {
                    st.push(hasTrue ? 't' : 'f');
                }
            }
        }
        return st.peek() == 't';
    }
}