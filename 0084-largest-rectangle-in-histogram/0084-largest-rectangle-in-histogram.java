class Solution {
    public int largestRectangleArea(int[] heights) {
        // next smaller index on the right
        int[] rb = new int[heights.length];
        Stack<Integer> rst = new Stack<>();

        rst.push(heights.length -1 );
        rb[heights.length - 1 ] = heights.length;

        for(int i = heights.length - 2  ; i>= 0 ; i--) {
            while(rst.size() > 0 && heights[i]  <= heights[rst.peek()]) {
                rst.pop();
            }
            if (rst.isEmpty()) {
                rb[i] = heights.length;
            } else {
                rb[i] = rst.peek();  
            }

            rst.push(i); 
        }

        // next smaller index on left  
        int[] lb = new int[heights.length];
        Stack<Integer> lst = new Stack<>();

        lst.push(0);
        lb[0] = -1;

        for(int i = 1 ; i < heights.length  ; i++) {
            while(lst.size() > 0 && heights[i]  <= heights[lst.peek()] ) {
                lst.pop();
            }
            if(lst.isEmpty()) {
                lb[i] = -1; 
            }else {
                lb[i] = lst.peek();
            }

            lst.push(i);
        }

        int maxArea = 0;
        for(int i=0 ; i< heights.length ; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(area , maxArea);
        }

        return maxArea;
    }
}