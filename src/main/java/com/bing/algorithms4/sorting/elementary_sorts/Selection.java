package com.bing.algorithms4.sorting.elementary_sorts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaobing on 2018/1/25
 */
public class Selection extends AbsSort {

    public static void sort(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            int min =i;
            for(int j = i;j<a.length-1;j++){
                if(less(a[j+1],a[min])){
                    min = j+1;
                }
            }
            exch(a,i,min);
        }
    }

    public static void main(String[] args) {
        List<Character> st = Arrays.asList('d','a','c','b','e','f');
        Character[] test = (Character[]) st.toArray();
        sort(test);
        show(test);
    }
}
