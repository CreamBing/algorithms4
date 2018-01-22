package com.bing.algorithms4.fundamentals.programming_model;

/**
 * Created by zhaobing on 2018/1/22
 */
public class Project117 {
    public static void main(String[] args) {
        //a
        double a = 9.0;
        while (Math.abs(a - 9.0/a) > .001){
            a = (9.0/a + a)/2.0;
        }
        System.out.printf("%.5f\n",a);
        //b
        int b = 0;
        for(int i = 1;i<1000;i++){
            for(int j = 0;j<i;j++){
                b++;
            }
        }
        System.out.println(b);

        //c
        int c = 0;
        for(int i = 1;i<1000;i*=2){
            for(int j = 0;j<1000;j++){
                c++;
            }
        }
        System.out.println(c);
    }
}
