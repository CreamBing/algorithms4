package com.bing.algorithms4.fundamentals.programming_model;

import java.util.Locale;

/**
 * Created by zhaobing on 2018/1/22
 */
public class Project1111 {

    public static void main(String[] args) {
        boolean[][] booleans = {{true,false},{false,true},{true,false}}; //new boolean[3][2]
        printout(booleans);

    }

    private static void printout(boolean[][] a1){
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                if (a1[i][j]){
                    System.out.println(String.format(Locale.CHINA,"%d  %d *",i+1,j+1));
                } else {
                    System.out.println(String.format(Locale.CHINA,"%d  %d /",i+1,j+1));
                }
            }
        }
    }
}
