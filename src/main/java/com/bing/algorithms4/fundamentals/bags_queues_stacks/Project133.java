package com.bing.algorithms4.fundamentals.bags_queues_stacks;

import java.util.Iterator;

/**
 * Created by zhaobing on 2018/1/24
 */
public class Project133<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item top() {
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private Node p = first;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Item next() {
            Item item = p.item;
            p = p.next;
            return item;
        }

    }

    public static boolean isValid(int[] seq) {
        Project133<Integer> stack = new Project133<Integer>();
        int currentNum = 9;
        int index = 9;
        while (currentNum >= 0) {
            if (index >= 0 && seq[index] == currentNum) {
                index--;
                currentNum--;
            } else if (!stack.isEmpty() && stack.top() == currentNum) {
                stack.pop();
                currentNum--;
            } else {
                if (index < 0)
                    break;
                stack.push(seq[index]);
                index--;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String line = "4 3 2 1 0 9 8 7 6 5\n" +
                "4 6 8 7 5 3 2 9 0 1\n" +
                "2 5 6 7 4 8 9 3 1 0\n" +
                "4 3 2 1 0 5 6 7 8 9\n" +
                "1 2 3 4 5 6 9 8 7 0\n" +
                "0 4 6 5 3 8 1 7 2 9\n" +
                "1 4 7 9 8 6 5 3 0 2\n" +
                "2 1 4 3 6 5 8 7 9 0";
        String[] values = line.split("\n");
        int[] nums = new int[10];

        for (int i = 0; i < values.length; i++) {
            String[] ss= values[i].split(" ");
            for(int j = 0;j< ss.length;j++){
                nums[j] = Integer.parseInt(ss[j]);
            }
            if (isValid(nums)) {
                System.out.println("OK");
            } else {
                System.out.println("No");
            }
        }
    }
}
