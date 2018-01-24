package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Stack;

/**
 * Created by zhaobing on 2018/1/23
 */
public class Dijkstra {

    private String expression;

    public Dijkstra(String expression) {
        this.expression = expression;
    }

    public double evaluate() {
        Stack<String> opts = new Stack<>();
        Stack<Double> vals = new Stack<>();
        char[] chars = expression.toCharArray();
        for (char c : chars) {
            String cs = String.valueOf(c);
            switch (cs) {
                case "(":
                    break;
                case "+":
                    opts.push("+");
                    break;
                case "-":
                    opts.push("-");
                    break;
                case "*":
                    opts.push("*");
                    break;
                case "/":
                    opts.push("/");
                    break;
                case ")":
                    double x = vals.pop();
                    String opt = opts.pop();
                    double y = vals.pop();
                    double result = 0;
                    switch (opt) {
                        case "+":
                            result = x + y;
                            break;
                        case "-":
                            result = x - y;
                            break;
                        case "*":
                            result = x * y;
                            break;
                        case "/":
                            result = x / y;
                            break;
                    }
                    vals.push(result);
                    break;
                    default:
                        vals.push(Double.parseDouble(cs));
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        Dijkstra s = new Dijkstra("(1+((2+3)*(4*5)))");
        System.out.println(s.evaluate());
    }
}
