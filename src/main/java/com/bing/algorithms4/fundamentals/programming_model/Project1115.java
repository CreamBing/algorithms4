package com.bing.algorithms4.fundamentals.programming_model;

import java.util.Arrays;

/**
 * Created by zhaobing on 2018/1/23
 */
public class Project1115 {

    public static void main(String[] args) {
        int[] test = {1,2,3,4,2,5,3,5,3,2,4};
        int[] result = histogram(test,11);
        int[] result2 = histogram2(test,11);
        Arrays.stream(result).forEach(System.out::print);
        System.out.println();
        Arrays.stream(result2).forEach(System.out::print);
    }

    //直方图
    public static int[] histogram(int[] ints,int m){
        int[] M = new int[m];
        for(int i=0;i<m;i++){
            int count = 0;
            for (int j=0,l = ints.length;j<l;j++){
                if(ints[j] == i){
                    count++;
                }
            }
            M[i] = count;
        }
        return M;
    }

    public static int[] histogram2(int[] a,int M)//直方图
    {
        int[] h = new int[M];
        int N = a.length;
        for (int i = 0; i < N; i++)
            if (a[i] < M)
                h[a[i]]++;
        return h;
    }
}
