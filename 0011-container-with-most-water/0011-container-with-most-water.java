class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int max = 0;
        while(i < j){
            int hght = Math.max(height[i] , height[j]);
            int width = height[j] - height[i] + 1;

            int ans = width * hght;

            if(ans > max){
                max = ans;
            }

            if(height[i] < height[j]) i++;
            else j--;
        }

        return max;
    }
}