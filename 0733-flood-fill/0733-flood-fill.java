class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]){
            return image;
        }

        recurs(image , sr , sc , color , image[sr][sc]);
        return image;
    }

    public void recurs(int[][] image , int sr , int sc , int color , int curr){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ){
            return;
        }
        
        if(image[sr][sc] != curr){
            return;
        }

        image[sr][sc] = color;

        recurs(image , sr - 1 , sc , color , curr);
        recurs(image , sr + 1 , sc , color , curr);
        recurs(image , sr , sc - 1 , color , curr);
        recurs(image , sr , sc + 1 , color , curr);
    }
}