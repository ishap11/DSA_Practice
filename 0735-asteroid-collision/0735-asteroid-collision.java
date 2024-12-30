class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st = new Stack<>();
        
        for(int i=0; i< asteroids.length ; i++) {
            int pele = asteroids[i];
            if(pele > 0) {
                st.push(pele);
            }else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(pele)) {
                    st.pop();
                }
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(pele); 
                }else if (st.peek() == Math.abs(pele)) {
                    st.pop(); // Both asteroids destroy each other
                } 
            }     
        }

        int[] ans = new int[st.size()];
         for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}