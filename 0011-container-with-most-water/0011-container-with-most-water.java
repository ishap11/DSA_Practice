class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int sum = 0;


        while(i<j){
            int width = j-i;
            int hght = Math.min(height[i] , height[j]);

            int area = width * hght;

            if(area > sum) sum = area;

            if(height[i] < height[j]) {
                i++;
            }else{
                j--;
            }
        }

        return sum;
    }

}