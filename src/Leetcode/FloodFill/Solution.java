package Leetcode.FloodFill;

public class Solution {

    private static void fill(int[][] image, int sr, int sc, int curColor, int newColor){
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != curColor) return;
        image[sr][sc] = newColor;
        fill(image,sr+1,sc,curColor,newColor);
        fill(image,sr-1,sc,curColor,newColor);
        fill(image,sr,sc+1,curColor,newColor);
        fill(image,sr,sc-1,curColor,newColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor){
            return image;
        }
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }


    public static void main(String[] args){
        int[][] image = {{0,0,0},{0,1,1}};

        int sr = 1;
        int sc = 1;
        int newColor = 1;

        image = floodFill(image,sr,sc,newColor);

        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }

}
