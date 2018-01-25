package com.bing.algorithms4.fundamentals.case_study;

import com.bing.algorithms4.util.FileUtil;
import com.bing.algorithms4.util.StdOut;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhaobing on 2018/1/25
 */
public class UnionFind {
    private int count;//记录连通分支数
    private int[] id;

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)//完成将id初始化0~N-1
            id[i] = i;
    }

    public int find(int p) {
        return id[p];
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {//缺点：一般无法处理大规模问题，因为每次调用它都需要扫描一次数组，对于最终值得到少量连通分量的问题运行时间是平方级别的
        int pID = id[p];
        int qID = id[q];
        if (pID == qID) //思路：利用判断id[q]和id[p]是否相等来判断它们是否在同一个连通分量中
            return;//如果相等就什么也不做，因为它们本来就在一个连通分支里面
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;//将p所在的连通支路全部改为q，合并两个连通分支
        }
        count--;//合并之后因为连通分支数少一，所以减一
    }

    public static void main(String[] args) {
        try {
            InputStream inputStream = UnionFind.class.getClassLoader().getResourceAsStream("fundamentals/case_study/mediumUF.txt");
            String s = FileUtil.readFile(inputStream);
            /*System.out.printf("tinyUF.txt contents:%s\n",s);
            System.out.println("*********************************");*/
            String[] ss = s.split("\n");
            UnionFind uf = null;
            long start = System.currentTimeMillis();
            for (String str : ss) {
                String[] strs = str.split(" ");
                if (strs.length == 1) {
                    uf = new UnionFind(Integer.valueOf(strs[0]));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

