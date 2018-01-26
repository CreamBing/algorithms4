package com.bing.algorithms4.sorting.elementary_sorts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaobing on 2018/1/25
 */
public class Insertion extends AbsSort{

    public static <T extends Comparable<T>> void sort(T[] a){
        int N = a.length;
        for(int i = 1;i< N ;i++){
            for(int j = i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
        List<Character> st = Arrays.asList('d','a','c','b','e','f');
        Character[] test = (Character[]) st.toArray();
        sort(test);
        show(test);
    }
}
