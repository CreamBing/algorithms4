package com.bing.algorithms4.sorting.elementary_sorts;

import com.bing.algorithms4.util.StdRandom;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by zhaobing on 2018/1/26
 */
public class SortCompare {

    public static  double time(String alg,Comparable[] a){
        double startTime = System.currentTimeMillis();
        try {
            Class<?> clz = Class.forName(alg);
            Method sortM = clz.getMethod("sort",Comparable[].class);
            Object SortObj = clz.newInstance();
            sortM.invoke(SortObj,new Object[]{a});
        }catch (Exception e){
            throw new NoSuchElementException("class not found");
        }
        double end = System.currentTimeMillis();
        return end -startTime;
    }

    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t =0;t<T;t++){
            for(int i=0;i<N;i++){
                a[i] = StdRandom.uniform();
            }
            total +=time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Selection","Insertion","Shell");
        int N =1000;
        int T = 100;
        for (String s: ls){
            String ll  = "com.bing.algorithms4.sorting.elementary_sorts."+s;
            double t = timeRandomInput(ll,N,T);
            System.out.printf("For %d random Doubles,%s takes %fms\n",N,s,t);
        }

    }
}
