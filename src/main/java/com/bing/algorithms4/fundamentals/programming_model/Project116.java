package com.bing.algorithms4.fundamentals.programming_model;

/**
 * Created by zhaobing on 2018/1/22
 */
public class Project116 {

    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for(int i = 0;i<=15;i++){
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
