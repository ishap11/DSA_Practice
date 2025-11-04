class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int l = 0;
        int h = height.length - 1;

        int lmax = 0;
        int rmax = 0;

        while(l < h){
            lmax = Math.max(lmax , height[l]);
            rmax = Math.max(rmax , height[h]);

            if(lmax < rmax){
                ans += lmax - height[l];
                l++;
            }else{
                ans += rmax - height[h];
                h--;
            }
        }
        return ans;
    }
}