package com.bing.algorithms4.sorting.elementary_sorts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaobing on 2018/1/25
 */
public class Shell extends AbsSort {

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3){
            h = 3*h+1;
        }
        while (h>=1){
            for(int i = h;i<N;i++){
                for(int j = i;j>=h&&less(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h/=3;
        }
    }

    public static void main(String[] args) {
        List<Character> st = Arrays.asList('d','a','c','b','e','f');
        Character[] test = (Character[]) st.toArray();
        sort(test);
        show(test);
    }
}
