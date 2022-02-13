package com.pratise.dp.backtracking;

public class NQueen {
    public static void main(String[] args) {
        int n=4;
        boolean[][] place = new boolean[n][n];
        System.out.println(queens(place,0));
    }
    static int queens(boolean[][] place,int row){
        if(row==place.length){
            display(place);
            return 1;
        }
        int count=0;
        //placing the queen and checking for every row and column
        for(int col=0;col<place.length;col++){
            //place the queen if it's safe
            if(isSafe(place,row,col)){
                place[row][col]=true;
                count += queens(place,row+1);
                place[row][col]=false;
            }
        }
        return count;
    }
    static boolean isSafe(boolean[][] place,int r,int c){
        //check vertical row
        for (int i = 0; i < r; i++) {
            if(place[i][c]){
                return false;
            }
        }
        //Diagonal left
        int maxLeft = Math.min(r,c);
        for (int i = 1; i <=maxLeft ; i++) {
            if(place[r-i][c-i]){
                return false;
            }
        }
        //diagonal Right
        int maxRight= Math.min(r,place.length-c-1);
        for (int i = 1; i <=maxRight ; i++) {
            if(place[r-i][c+i]){
                return false;
            }
        }
        return true;
    }
    static void display(boolean[][] place){
        for (boolean[] row:place) {
            for (boolean column:row){
                if(column){
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
