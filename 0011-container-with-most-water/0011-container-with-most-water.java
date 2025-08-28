class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j = n - 1;
        int sum =0;

        while(i<j){
            int width = j-i;
            int hght = Math.min(height[i] , height[j]);
            int area = width * hght;

            if(sum < area) {
                sum = area;
            }

            if(height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }

        return sum;
    }
}