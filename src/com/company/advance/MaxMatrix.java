package com.company.advance;

// 给定一个由正整数和负整数组成的NxN矩阵，求和最大的子矩阵
public class MaxMatrix {
    public static SubMatrix getSubMatrix(int[][] matrix) {
        int rowCount=matrix.length;
        int colCount=matrix[0].length;
        SubMatrix maxMatrix=null;
        for(int rowStart=0;rowStart<rowCount;rowStart++) {
            int[] partialSum=new int[colCount];  // 存储每一列的和
            for(int rowEnd=rowStart;rowEnd<rowCount;rowEnd++) {  // 寻找rowStart-rowEnd和最大的子矩阵
                for(int col=0;col<colCount;col++) {
                    partialSum[col]+=matrix[rowEnd][col];
                }
                Range best=getMaxSum(partialSum);
                if(maxMatrix==null || best.sum>maxMatrix.sum ) {
                    maxMatrix=new SubMatrix(rowStart,rowEnd,best.start,best.end,best.sum);
                }
            }
        }
        return maxMatrix;
    }

    // 获取总和最大的连续数列
    public static Range getMaxSum(int[] a) {
        int sum=0;
        int start=0;
        Range best=null;
        for(int i=0;i<a.length;i++) {
            sum+=a[i];
            if(best==null || sum>best.sum) {
                best=new Range(start,i,sum);
            }

            if(sum<0) {
                start=i+1;
                sum=0;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[5][];
        matrix[0]=new int[]{3,4,5,-2,6};
        matrix[1]=new int[]{-2,6,9,-5,-12};
        matrix[2]=new int[]{3,12,-5,6,-9};
        matrix[3]=new int[]{6,-2,5,9,-4};
        matrix[4]=new int[]{-3,4,2,3,5};
        System.out.println(getSubMatrix(matrix));
    }
}

class Range {
    int start;
    int end;
    int sum;

    Range(int start,int end,int sum) {
        this.start=start;
        this.end=end;
        this.sum=sum;
    }

    public String toString() {
        return start+","+end+"->"+sum;
    }
}

class SubMatrix {
    int c1,c2,r1,r2,sum;

    SubMatrix(int c1,int c2,int r1,int r2,int sum) {
        this.c1=c1;
        this.c2=c2;
        this.r1=r1;
        this.r2=r2;
        this.sum=sum;
    }

    @Override
    public String toString() {
        return c1+" "+c2+" "+r1+" "+r2+" "+sum;
    }
}