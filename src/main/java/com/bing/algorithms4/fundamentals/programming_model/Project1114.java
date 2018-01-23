package com.bing.algorithms4.fundamentals.programming_model;

/**
 * Created by zhaobing on 2018/1/23
 */
public class Project1114 {

    public static void main(String[] args) {
        System.out.println(maxLogInt(23));
        System.out.println(lg(23));
    }

    /**
     * func:输入N,返回不大于log2N的最大整数
     * 利用2^n>2^(n-1)+..+2^0。所以最大整数即是二进制的最大1所在的位置
     * @param n
     * @return
     */
    public static int maxLogInt(int n){
        return Integer.toBinaryString(n).length()-1;
    }

    private static int lg(int N) {
        int product = 1;
        int x = -1;
        while (product <= N) //*，把等于的情况也纳入进来，从而避免了在如23>5这种情况的自增导致输出结果为3的情况
        {
            product *= 2;
            x++;
        }
        return x;
    }
}
