package com.company.recursive;

import java.util.ArrayList;
import java.util.LinkedList;

// 一个r行c列的网格，机器人从左上角移动至右下角，其中某些网格不能移动，且只能向下或向右移动，返回其所有可能的路径
public class GetPath {
    public ArrayList<LinkedList<Point>> getPath(int row,int col) {
        boolean[][] maze=new boolean[row+1][col+1];
        for(int i=0;i<row+1;i++) {
            for(int j=0;j<col+1;j++) {
                maze[i][j]=true;
            }
        }

        return subGetPath(maze,row,col);
    }

    private ArrayList<LinkedList<Point>> subGetPath(boolean[][] maze,int row,int col) {
        ArrayList<LinkedList<Point>> arr=new ArrayList<>();
        if(row==0 && col==0) {
            LinkedList<Point> s=new LinkedList<>();
            s.add(new Point(0,0));
            arr.add(s);
            System.out.println("0正在被访问");
            return arr;
        }

        if(row-1>=0 && maze[row][col]) {
            ArrayList<LinkedList<Point>> arr2=getPath(row-1,col);
            for(LinkedList<Point> s:arr2) {
                LinkedList<Point> a=(LinkedList<Point>)s.clone();
                a.add(new Point(row,col));
                arr.add(a);
            }
        }

        if(col-1>=0 && maze[row][col]) {
            ArrayList<LinkedList<Point>> arr3=getPath(row,col-1);
            for(LinkedList<Point> s:arr3) {
                LinkedList<Point> a=(LinkedList<Point>)s.clone();
                a.add(new Point(row,col));
                arr.add(a);
            }
        }
        return arr;
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
        ArrayList<LinkedList<Point>> arr=g.getPath(2,3);
        System.out.println(arr.size());

    }
}
