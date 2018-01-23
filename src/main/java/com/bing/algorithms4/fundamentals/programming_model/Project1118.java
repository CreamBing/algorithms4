package com.bing.algorithms4.fundamentals.programming_model;

/**
 * Created by zhaobing on 2018/1/23
 */
public class Project1118 {

    public static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    public static int mystery1(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return mystery1(a*a, b/2);
        return mystery1(a*a, b/2) * a;
    }

    //这道题目考了一个思想，数据和操作，即第一个参数是数据，第二个参数是操作的。这在实际编程中也是一种解耦的思想
    public static void main(String args[]) {
        System.out.println(mystery(2,25));  // 输出50
        System.out.println(mystery(3,11));  //输出33
        System.out.println(mystery1(2,10));  // 输出33554432
        System.out.println(mystery1(3,11));  //输出177147
    }

}
