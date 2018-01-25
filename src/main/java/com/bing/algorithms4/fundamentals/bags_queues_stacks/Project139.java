package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Stack;

/**
 * Created by zhaobing on 2018/1/24
 */
public class Project139 {

    public static String expression(String s){
        char[] chars = s.toCharArray();
        String result = "";
        Stack<String> stack = new Stack<>();
        for (char c : chars){
            String cs = String.valueOf(c);
            if(cs.length()==0){
                continue;
            }
            if(cs.equals(")")){
                String x = stack.pop();
                String y = stack.pop();
                String z = stack.pop();
                String m = "("+z+y+x+")";
                stack.push(m);

            }else {
                stack.push(cs);
            }
        }
        for (String ss : stack){
            result+=ss;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "1+2)*3-4)*5-6)))";
        System.out.println(expression(s));
    }
}
