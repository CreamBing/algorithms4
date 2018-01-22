package com.bing.algorithms4.fundamentals.programming_model;

/**
 * Created by zhaobing on 2018/1/22
 */
public class Project119 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(toBinaryString(10));
        System.out.println(decimalToBinary(10));
    }

    public static String toBinaryString(int n){
        String result = "";
        try {
            if(n<Integer.MAX_VALUE&&n>Integer.MIN_VALUE){
                for(int i = n;i>0;i/=2){
                    result = (i%2)+result;
                }
            }
        }catch (Exception e){
            result = "";
        }finally {
            return result;
        }
    }

    public static String decimalToBinary(int n) {
        String resultString = "";
        for (int i = 31; i >= 0; i--)
            resultString = resultString + (n >>> i & 1);
        return resultString;
    }
}
