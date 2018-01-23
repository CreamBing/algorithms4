package com.bing.algorithms4.fundamentals.programming_model;

/**
 * Created by zhaobing on 2018/1/23
 */
public class Project1113 {

    public static void main(String[] args) {
        int[][] test = {{2,3,4},{2,4,5}};
        int[][] convertTest = convertMatrix(test);
        showInt(test);
        showInt(convertTest);

    }

    public static void showInt(int[][] ints){
        for(int i =0;i<ints.length;i++){
            for (int j = 0;j<ints[i].length;j++){
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] convertMatrix(int[][] ints){
        if(ints.length<=0){
            return null;
        }
        int m = ints.length;
        int n = ints[0].length;
        int[][] matrix = new int[n][m];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                matrix[j][i] = ints[i][j];
            }
        }
        return matrix;
    }
}
