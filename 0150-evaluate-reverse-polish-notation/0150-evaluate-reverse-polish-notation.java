class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String elem : tokens){
            if(!isOperator(elem)){
                st.push(Integer.parseInt(elem));
            }else{
                int b = st.pop();
                int a = st.pop();
                int res = 0;
                
                switch(elem){
                    case "+" : res = a + b; break;
                    case "-" : res = a - b; break;
                    case "*" : res = a * b; break;
                    case "/" : res = a / b; break; 
                }
                st.push(res);
            }
        }
        return st.pop();
    }
    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || 
               s.equals("*") || s.equals("/") || 
               s.equals("^");
    }
}