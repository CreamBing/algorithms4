package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 利用定容栈当push栈满时，扩容，pop很小时，缩容
 * Created by zhaobing on 2018/1/23
 */
public class Stack<T> implements Iterable<T>{
    private int N;//栈的大小
    private T[] stacks;
    private static final int defaultSize = 10;

    public Stack(int n) {
        stacks = (T[]) new Object[n];
    }

    public Stack() {
        stacks = (T[]) new Object[defaultSize];
    }

    public boolean isEmpty(){
        if(N==0){
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull(){
        if(N==stacks.length-1){
            return true;
        }else {
            return false;
        }
    }

    public void push(T t){
        if(isFull()){
            resize(2*stacks.length);
        }
        stacks[N++] = t;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T t = stacks[--N];
        stacks[N] = null;//避免对象游离
        if(N<stacks.length/4){
            resize(stacks.length/2);
        }
        return t;
    }

    private void resize(int l){
        T[] temp = (T[])new Object[l];
        for(int i=0;i<N;i++){
            temp[i] = stacks[i];
        }
        stacks = temp;
    }

    private int size(){
        return N;
    }

    public void showStack() {
        Arrays.stream(stacks).forEach(System.out::print);
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>(1);
        stringStack.push("a");
        System.out.println(stringStack.pop());
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        stringStack.showStack();
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        stringStack.showStack();
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        stringStack.showStack();
        System.out.println("\n***********使用迭代器***********");
        stringStack.push("c");
        stringStack.push("d");
        stringStack.forEach(System.out::print);//使用迭代器
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public T next() {
            return stacks[--i];
        }

        @Override
        public void remove() {

        }
    }
}
