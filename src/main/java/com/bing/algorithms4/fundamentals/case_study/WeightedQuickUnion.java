package com.bing.algorithms4.fundamentals.case_study;

import com.bing.algorithms4.util.FileUtil;
import com.bing.algorithms4.util.StdOut;

import java.io.InputStream;

/**
 * Created by zhaobing on 2018/1/25
 */
public class WeightedQuickUnion {

    private int[] ids;
    private int[] weights;
    private int count;

    public WeightedQuickUnion(int N) {
        count = N;
        ids = new int[N];
        weights = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            weights[i] = 1;
        }
    }

    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int Rootp = find(p);
        int Rootq = find(q);
        if (Rootp == Rootq) return;
        if (weights[Rootp] < weights[Rootq]) {
            ids[Rootp] = Rootq;
            weights[Rootq] += weights[Rootp];
        } else {
            ids[Rootq] = Rootp;
            weights[Rootp] += weights[Rootq];
        }
        count--;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        try {
            InputStream in = WeightedQuickUnion.class.getClassLoader().getResourceAsStream("fundamentals/case_study/largeUF.txt");
            String s = FileUtil.readFile(in);
            String[] ss = s.split("\n");
            WeightedQuickUnion uf = null;
            long start = System.currentTimeMillis();
            for (String str : ss) {
                String[] strs = str.split(" ");
                if (strs.length == 1) {
                    uf = new WeightedQuickUnion(Integer.valueOf(strs[0]));
                } else {
                    int p = Integer.valueOf(strs[0]);
                    int q = Integer.valueOf(strs[1]);
                    if (uf.connected(p, q)) continue;
                    uf.union(p, q);
                    StdOut.println(p + " " + q);
                }
            }
            StdOut.println(uf.count + " components");
            long end = System.currentTimeMillis();
            System.out.printf("it takes %d ms",(end - start));
            //6 components
            //it takes 13039 ms
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
