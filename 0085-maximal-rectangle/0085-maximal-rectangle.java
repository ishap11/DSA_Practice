class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int maxArea = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }
                else{
                    height[j] += 1;
                }
            }

            maxArea = Math.max(maxArea , largestRectangle(height));
        }

        return maxArea;
    }

    private int largestRectangle(int[] height){
        int n = height.length;
        int maxArea = 0;

        Stack<Integer> st= new Stack<>();

        for(int i = 0 ; i <= n ; i++){
            int h = (i == n) ? -1 : height[i];

            while(!st.isEmpty() && h < height[st.peek()]){
                int hght = height[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;

                int area = width * hght; 

                maxArea = Math.max(maxArea , area);
            }
            st.push(i);
        }

        return maxArea;
    }
}