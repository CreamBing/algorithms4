package com.bing.algorithms4.fundamentals.programming_model;

import java.util.Scanner;

/**
 * Created by zhaobing on 2018/1/22
 */
public class Project115 {

    public static void main(String[] args) {
        System.out.println("请输入两个double类型的数据，形如1.3 3.3空格分割,输入q结束");
        String inS = "";
        while (!inS.equals("q")){
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            inS = scanner.next();
            if(inS.equals("q")){
                break;
            }else {
                try {
                    String[] ss = inS.split(" ");
                    if(ss.length!=2){
                        System.out.println("请输入两个double类型的数据，形如1.3 3.3空格分割,输入q结束");
                    }else {
                        Double d1 = Double.parseDouble(ss[0]);
                        Double d2 = Double.parseDouble(ss[1]);
                        if(d1<1&&d1>0&&d2<1&&d2>0){
                            System.out.println(true);
                        }else {
                            System.out.println(false);
                        }
                    }
                }catch (Exception e){
                    System.out.println("请输入double类型的数据");
                }
            }
        }
    }
}
