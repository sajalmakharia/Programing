package com.pratise.dp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Maze {
    public static void main(String[] args) {
        //System.out.println(count(3,3));
        //path("",3,3);
        //System.out.println(printReturnDiagonal("",3,3));
        boolean[][] visited = {{false,false,false},{false,false,false},{false,false,false}};
        int[][] pathMatrix={{0,0,0},{0,0,0},{0,0,0}};
     //   allFourDirectionPath("",visited,0,0);
        printMatrixForPath("",visited,pathMatrix,0,0,1);
    }
    //start is taken as 1,1 and end is 3,3
    //number of path to go from(0,0)->(2,2) in a 3x3 matrix so top left to bottom right
    // direction allowed Right and down
    static int count(int r,int c){
        if(r==1||c==1){
            return 1;
        }
        int left = count(r-1,c);
        int right = count(r,c-1);
        return left+right;
    }

    //Print the path instead of the count
    // direction allowed Right and down
    static void path(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            path(p+"D",r-1,c);
        }
        if(c>1){
            path(p+"R",r,c-1);
        }
    }
    // direction allowed Right and down
    static ArrayList<String> printReturnDiagonal(String p,int r,int c){
        if(r==1&&c==1){
            return new ArrayList<>(Collections.singletonList(p));
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1&&c>1){
            list.addAll(printReturnDiagonal(p+'d',r-1,c-1));
        }
        if(r>1){
            list.addAll(printReturnDiagonal(p+'D',r-1,c));
        }
        if (c > 1) {
            list.addAll(printReturnDiagonal(p+'R',r,c-1));
        }
        return list;
    }
    static void allFourDirectionPath(String p,boolean[][] visited,int r,int c){
        if(r==visited.length-1 && c==visited[0].length-1){
            System.out.println(p);
            return;
        }
        if(visited[r][c]){
            return;
        }
        visited[r][c]=true;
        if(r<visited.length-1){
            allFourDirectionPath(p+'D',visited,r+1,c);
        }
        if(r>0){
            allFourDirectionPath(p+'U',visited,r-1,c);
        }
        if(c<visited[0].length-1){
            allFourDirectionPath(p+'R',visited,r,c+1);
        }
        if(c>0){
            allFourDirectionPath(p+'L',visited,r,c-1);
        }
        // this is the line where the function will be over
        //so before the function get removed from stack, remove the changes made in that function.
        visited[r][c]=false;
    }

    static void printMatrixForPath(String p,boolean[][] visited,int[][] pathMatrix,int r,int c,int level){
        if(r==visited.length-1 && c==visited[0].length-1){
            pathMatrix[r][c]=level;
            for(int[] path:pathMatrix) {
                System.out.println(Arrays.toString(path));
            }
            System.out.println(p);
            return;
        }
        if(visited[r][c]){
            return;
        }
        visited[r][c]=true;

        pathMatrix[r][c]=level;
        if(r<visited.length-1){
            printMatrixForPath(p+'D',visited,pathMatrix,r+1,c,level+1);
        }
        if(r>0){
            printMatrixForPath(p+'U',visited,pathMatrix,r-1,c,level+1);
        }
        if(c<visited[0].length-1){
            printMatrixForPath(p+'R',visited,pathMatrix,r,c+1,level+1);
        }
        if(c>0){
            printMatrixForPath(p+'L',visited,pathMatrix,r,c-1,level+1);
        }
        visited[r][c]=false;
        pathMatrix[r][c]=0;
    }
}
