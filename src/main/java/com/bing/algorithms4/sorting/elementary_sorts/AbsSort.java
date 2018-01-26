package com.bing.algorithms4.sorting.elementary_sorts;

/**
 * Created by zhaobing on 2018/1/25
 */
public class AbsSort {

        public static <T extends Comparable<T>> boolean less(T a,T b){
            return a.compareTo(b)<0;
        }

        public static void exch(Comparable[] a,int i,int j){
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        public static void show(Comparable[] a){
            for(Comparable i : a){
                System.out.print(i+" ");
            }
            System.out.println();
        }


}
