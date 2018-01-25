package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Iterator;

/**
 * 利用链表实现的队列
 * Created by zhaobing on 2018/1/24
 */
public class LinkedListQueue<T> implements Iterable<T> {

    private class Node {
        T t;
        Node next;
    }

    private Node first;//对首
    private Node last;//对尾
    private int N;//队列大小

    /*
    public void enqueue(T t) {
        if (first == null) {
            Node in = new Node();
            in.t = t;
            first = last = in;
            N++;
        } else {
            Node in = new Node();
            in.t = t;                      //last = in 提到前面
            last.next = in;               //Node oldLast = last;
            last = in;                    //oldLast.next = last
            N++;
        }
    }
    */


    public void enqueue(T t) {
        Node lastNode = last;
        last = new Node();
        last.t = t;
        last.next = null;//明确指明这个是对尾
        if(isEmpty()){
            first = last;
        }else {
            lastNode.next = last;
        }
        N++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T t = first.t;
        first = first.next;
        if(isEmpty()){//避免对象游离
            last = null;
        }
        N--;
        return t;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListQueueIterator();
    }

    private class LinkedListQueueIterator implements Iterator<T>{
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
        LinkedListQueue<String> stringStack = new LinkedListQueue<>();
        stringStack.enqueue("a");
        System.out.println(stringStack.dequeue());
        stringStack.enqueue("b");
        stringStack.enqueue("c");
        stringStack.enqueue("d");
        System.out.println(stringStack.dequeue());
        System.out.println(stringStack.size());
        System.out.println(stringStack.dequeue());
        System.out.println(stringStack.dequeue());
        System.out.println(stringStack.size());
        System.out.println(stringStack.dequeue());
        System.out.println(stringStack.size());
        System.out.println("\n***********使用迭代器***********");
        stringStack.enqueue("c");
        stringStack.enqueue("d");
        stringStack.forEach(System.out::print);//使用迭代器
    }
}
