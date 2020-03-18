package com.company.medium;

// 给定两条线段的起点和终点，计算其交点
public class LinesIntersect {
    public Point linesIntersect(Point start,Point end,Point start2,Point end2) {
        if(start.x>end.x) swap(start,end);
        if(start2.x>end2.x) swap(start2,end2);
        if(start.x>start2.x) {
            swap(start,start2);
            swap(end,end2);
        }

        Line line=new Line(start,end);
        Line line2=new Line(start2,end2);

        if(line.slope==line2.slope) {  // 斜率相同
            if(line.intercept!=line.intercept) {  // 截距不同
                return null;
            }
            else {
                if(start2.x>=start.x && start2.x<=end.x) {
                    return start2;
                }
                else {
                    return null;
                }
            }
        }
        else {  // 斜率不同
            double xIntersect=(line.intercept-line2.intercept)/(line2.slope-line.slope);  // 交点坐标
            double yIntersect=line.slope*xIntersect+line.intercept;
            if(xIntersect>=start.x && xIntersect<=end.x && xIntersect>=start2.x && xIntersect<=end2.x) {
                return new Point(xIntersect,yIntersect);
            }
            return null;
        }
    }

    private void swap(Point x,Point y) {
        Point temp=x;
        x=y;
        y=temp;
    }

    private class Line {
        double slope;
        double intercept;

        Line(Point start,Point end) {
            slope=(end.y-start.y)/(end.x-start.x);
            intercept=end.y-slope*end.x;
        }
    }

    private static class Point {
        double x;
        double y;

        Point(double x,double y) {
            this.x=x;
            this.y=y;
        }

        public String toString() {
            return x+","+y;
        }
    }

    public static void main(String[] args) {
        LinesIntersect li=new LinesIntersect();
        Point result=li.linesIntersect(new Point(3,4),new Point(6,8),new Point(-2,5),new Point(6,4));
        System.out.println(result);
    }
}
