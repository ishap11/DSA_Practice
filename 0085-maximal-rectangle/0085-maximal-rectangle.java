class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0) return 0;
        int[] heights = new int[m];
        int maxArea = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] =='0'){
                    heights[j] = 0;
                }else{
                    heights[j] += 1;
                }
            }

            maxArea = Math.max(maxArea , largestRectangle(heights));
        }
        return maxArea;
    }

    public int largestRectangle(int[] heights){
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i =0 ; i <= n ;i++){
            int h = (i == n) ? 0 : heights[i];

            while(!st.isEmpty() && h < heights[st.peek()]){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;

                int area = height * width;

                maxArea = Math.max(maxArea , area);
            }
            st.push(i);
        }
        return maxArea;
    }
}