package com.bing.algorithms4.fundamentals.programming_model;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created by zhaobing on 2018/1/22
 */
public class Project113 {

    public static void main(String[] args) {
        System.out.println("请输入三个整数,形如11 33 44,空格分开,输入q结束");
        String string1 = "";
        while (!string1.equals("q")){
            Scanner scanner2 = new Scanner(System.in);
            scanner2.useDelimiter("\n");
            string1 = scanner2.next();
            if(string1.trim().equals("q")){
                break;
            }
            String[] ss = string1.split(" ");
            if(ss.length!=3){
                System.out.println("格式不对，请输入三个整数,形如11 33 44,空格分开");
            }else {
                try {
                    Integer number1 = Integer.valueOf(ss[0]);
                    Integer number2 = Integer.valueOf(ss[1]);
                    Integer number3 = Integer.valueOf(ss[2]);
                    /*
                    Integer a = new Integer(10);
                    Integer b = new Integer(10);
                    System.out.println(a.equals(b)); ===> TRUE
                    System.out.println(a == b); ===> FALSE
                    but
                    Integer c = Integer.valueOf("10");
                    Integer d = Integer.valueOf("10");
                    System.out.println(c.equals(d)); //true
                    System.out.println(c == d); //true
                    valueof 是int装箱来的，一个对象
                    */
                    if (Objects.equals(number1, number2) && Objects.equals(number1, number3) && Objects.equals(number2, number3)) {//说明一下java中==和equals方法
                        System.out.println("equal");
                    } else {
                        System.out.println("not equal");
                    }
                }catch (Exception e){
                    System.out.println("格式不对，请输入三个整数");
                }
            }
        }
    }
}
