class Solution {
    public int trap(int[] height) {
        // TC - O(n2) SC - O(1)
        // int totalWater =  0;
        // int n = height.length;

        // for(int i =1 ; i< n-1 ; i++) {
        //     int leftMax = height[i];

        //     for(int j= 0 ; j< i ; j++) {
        //         leftMax = Math.max(leftMax, height[j]);
        //     }

        //     int rightMax = height[i];
        //     for(int j = i+1  ; j< n; j++) {
        //         rightMax = Math.max(rightMax , height[j]);
        //     }

        //     totalWater += Math.min(leftMax, rightMax) - height[i];
        // }
        // return totalWater;

        // TC - O(n) SC - O(n);
        // int totalWater =  0;
        // int n = height.length;
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];

        // leftMax[0] = height[0];
        // rightMax[n - 1] = height[n - 1];

        // for(int i=1 ; i<n ; i++) {
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        // }

        // for(int i=n-2 ; i>=0 ; i--) {
        //     rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        // }


        // for(int i= 0; i< n;  i++) {
        //     totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        // } 
        
        // return totalWater;


        // TC - O(n) SC - O(1)
        int n = height.length ;
        int l = 0;
        int r = n-1;
        int lmax = 0;
        int rmax = 0;
        int ans = 0;
        
        while(l < r) {
            lmax = Math.max(lmax , height[l]);
            rmax = Math.max(rmax , height[r]);

            if(lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }
        return ans;
    }
}