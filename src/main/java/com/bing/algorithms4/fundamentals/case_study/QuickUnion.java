package com.bing.algorithms4.fundamentals.case_study;

import com.bing.algorithms4.util.FileUtil;
import com.bing.algorithms4.util.StdOut;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhaobing on 2018/1/25
 */
public class QuickUnion {

    private int[] ids;
    private int counts;

    public QuickUnion(int n) {
        counts = n;
        ids = new int[n];
        for(int i= 0;i<n;i++){
            ids[i] = i;
        }
    }

    private int find(int q){
        while (q!=ids[q]){
            q = ids[q];
        }
        return q;
    }

    private void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)return;
        ids[pRoot] = qRoot;
        counts--;
    }

    private boolean connected(int p,int q){
        return find(p) == find(q);
    }

    private int count(){
        return counts;
    }

    public static void main(String[] args) {
        try {
            InputStream inputStream = QuickUnion.class.getClassLoader().getResourceAsStream("fundamentals/case_study/largeUF.txt");
            String s = FileUtil.readFile(inputStream);
            /*System.out.printf("tinyUF.txt contents:%s\n",s);
            System.out.println("*********************************");*/
            String[] ss = s.split("\n");
            QuickUnion uf = null;
            long start = System.currentTimeMillis();
            for (String str : ss) {
                String[] strs = str.split(" ");
                if (strs.length == 1) {
                    uf = new QuickUnion(Integer.valueOf(strs[0]));
                } else {
                    int p = Integer.valueOf(strs[0]);
                    int q = Integer.valueOf(strs[1]);
                    if (uf.connected(p, q)) continue;
                    uf.union(p, q);
                    StdOut.println(p + " " + q);
                }
            }
            StdOut.println(uf.counts + " components");
            long end = System.currentTimeMillis();
            System.out.printf("it takes %d ms",(end - start));
            //6 components
            //it takes 5075967 ms
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
