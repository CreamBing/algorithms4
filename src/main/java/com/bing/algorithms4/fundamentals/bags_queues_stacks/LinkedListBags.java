package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Iterator;

/**
 * 利用链表实现背包
 * Created by zhaobing on 2018/1/24
 */
public class LinkedListBags<T> implements Iterable<T>{

    private class Node{
        T t;
        Node next;
    }

    private Node first;//放入背包的当前元素
    private int N; //背包大小

    public void add(T t){
        Node temp = first;
        first = new Node();
        first.t = t;
        first.next = temp;
        N++;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return first==null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListBagsIterator();
    }

    private class LinkedListBagsIterator implements Iterator<T>{

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
        LinkedListBags<String> stringStack = new LinkedListBags<>();
        System.out.println(stringStack.size());
        System.out.println(stringStack.isEmpty());
        stringStack.add("a");
        stringStack.add("b");
        stringStack.add("c");
        stringStack.add("d");
        System.out.println("\n***********使用迭代器***********");
        stringStack.add("c");
        stringStack.add("d");
        stringStack.forEach(System.out::print);//使用迭代器
    }
}
