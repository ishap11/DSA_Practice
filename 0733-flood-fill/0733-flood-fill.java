class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }

        recurs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void recurs(int[][] image, int sr, int sc, int color, int cur) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length){
            return;
        } 
       
        if(cur != image[sr][sc]){
            return;
        }

        image[sr][sc] = color;
        recurs(image, sr-1, sc, color, cur);
        recurs(image, sr+1, sc, color, cur);
        recurs(image, sr, sc-1, color, cur);
        recurs(image, sr, sc+1, color, cur);
    }
}