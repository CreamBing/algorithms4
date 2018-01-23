package com.bing.algorithms4.fundamentals.programming_model;

/**
 * Created by zhaobing on 2018/1/23
 */
public class Project1116 {

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }

    public static String exR1(int n){
        if(n<=0){
            return "";
        }
        return exR1(n-3) + n + exR1(n-2)+n;
    }
}

