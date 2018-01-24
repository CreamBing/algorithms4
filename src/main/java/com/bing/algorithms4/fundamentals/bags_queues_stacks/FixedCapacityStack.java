package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Arrays;

/**
 * string数组实现的一个定容栈
 * Created by zhaobing on 2018/1/23
 */
public class FixedCapacityStack<T> {
    private int N;//表示栈的大小
    private T[] stacks;

    public FixedCapacityStack(int n) {
        stacks = (T[])new Object[n];
    }

    public int size(){
        return N;
    }

    public void push(T t){
        stacks[N++] = t;
    }

    public T pop(){
        return stacks[--N];
    }

    public void showStack() {
        Arrays.stream(stacks).forEach(System.out::print);
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stringFixedCapacityStack = new FixedCapacityStack<>(10);
        stringFixedCapacityStack.push("a");
        System.out.println(stringFixedCapacityStack.pop());
        stringFixedCapacityStack.push("b");
        System.out.println(stringFixedCapacityStack.pop());
        System.out.println(stringFixedCapacityStack.size());
//        System.out.println(stringFixedCapacityStack.pop());
        /*stringFixedCapacityStack.push("b");
        stringFixedCapacityStack.push("c");
        System.out.println(stringFixedCapacityStack.pop());
        stringFixedCapacityStack.push("d");
        System.out.println(stringFixedCapacityStack.pop());
        System.out.println(stringFixedCapacityStack.size());*/
        stringFixedCapacityStack.showStack();
    }
}
