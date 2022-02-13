package com.pratise.dp.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class MazeObstecale {
    public static void main(String[] args) {
        boolean[][] mazeRes = {{false,false,false},{false,true,false},{false,false,false}};

       // System.out.println(paths(0,maze,0,0));
        //System.out.println(pathsDir("",mazeRes,0,0));


    }
    static int paths(int count,boolean[][] maze,int r,int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            return 1;
        }
        if(maze[r][c]){
            return 0;
        }

        int down =0;
        if(r<maze.length-1)
                down= paths(count,maze,r+1,c);

        int right=0;
        if(c<maze[0].length-1)
            right= paths(count,maze,r,c+1);
        return down+right;
    }
    static ArrayList<String> pathsDir(String p, boolean[][] maze, int r, int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            return new ArrayList<>(Collections.singletonList(p));
        }
        if(maze[r][c]){
            return new ArrayList<>();
        }

        ArrayList<String> list = new ArrayList<>();
        if(r<maze.length-1)
            list.addAll(pathsDir(p+'D',maze,r+1,c));


        if(c<maze[0].length-1)
            list.addAll(pathsDir(p+'R',maze,r,c+1));
        return list;
    }


}
