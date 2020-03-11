package com.company.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

// 一个r行c列的网格，机器人从左上角移动至右下角，其中某些网格不能移动，且只能向下或向右移动，返回其路径
public class GetPath {
    public ArrayList<Point> getPath() {
        boolean[][] maze=new boolean[6][5];
        for(int i=0;i<maze.length;i++) {
            for(int j=0;j<maze[0].length;j++) {
                maze[i][j]=true;
            }
        }

        ArrayList<Point> path=new ArrayList<>();
        HashSet<Point> failedPoints=new HashSet<>();
        if(subGetPath(maze,maze.length-1,maze[0].length-1,path,failedPoints)) {
            return path;
        }
        return null;
    }

    private boolean subGetPath(boolean[][] maze,int row,int col,ArrayList<Point> path,HashSet<Point> failedPoints) {
        if(row<0 || col<0 || !maze[row][col]) {
            return false;
        }

        Point p=new Point(row,col);
        if(failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin=row==0 && col==0;

        if(isAtOrigin || subGetPath(maze,row-1,col,path,failedPoints) || subGetPath(maze,row,col-1,path,failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }

    private class Point {
        private int row;
        private int col;
        public Point(int row,int col) {
            this.row=row;
            this.col=col;
        }

        public String toString() {
            return row+","+col;
        }
    }

    public static void main(String[] args) {
        GetPath g=new GetPath();
        ArrayList<Point> arr=g.getPath();
        System.out.println(arr);
    }
}
