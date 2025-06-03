class Solution {
    public int maxArea(int[] height) {
        int sum = 0;
        int i= 0; 
        int j = height.length - 1;

        while(i< j) {
            int width = j - i;
            int hght = Math.min(height[j] , height[i]);
            int area = width*hght;
            if(sum < area ) {
                 sum = area;
            }

            if(height[j] > height[i]) i++;
            else j--;
        }
        return sum;
    }
}