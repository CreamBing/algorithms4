package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Iterator;

/**
 * 利用链表结构实现的下压栈
 * Created by zhaobing on 2018/1/24
 */
public class LinkedListStack<T> implements Iterable<T>{

    private class Node{
        T t;//节点内容
        Node next;//下一个节点的指针
    }
    private Node first;//最新入栈的节点:栈顶
    private int N;//栈的大小

    public void push(T t){
        Node oldFirst = first;
        first = new Node();
        first.t = t;
        first.next = oldFirst;
        N++;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T t = first.t;
        first = first.next;
        N--;
        return t;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseLinkedListIterator();
    }

    private class ReverseLinkedListIterator implements Iterator<T>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.next;
            return t;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        LinkedListStack<String> stringStack = new LinkedListStack<>();
        stringStack.push("a");
        System.out.println(stringStack.pop());
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        System.out.println("\n***********使用迭代器***********");
        stringStack.push("c");
        stringStack.push("d");
        stringStack.forEach(System.out::print);//使用迭代器
    }
}
