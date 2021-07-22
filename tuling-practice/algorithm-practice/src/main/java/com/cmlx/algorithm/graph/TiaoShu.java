package com.cmlx.algorithm.graph;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author CMLX
 * @Date -> 2021/7/22 9:38
 * @Desc ->
 **/
public class TiaoShu {

    public static void main(String[] args) {
        int n, m; // n个点，m条边
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            int data[][] = new int[n + 1][n + 1];
            int a, b; // 表示a到b有路可以走
            for (int i = 0; i < m; i++) {
                a = cin.nextInt();
                b = cin.nextInt();
                data[a][b] = 1;
            }
            Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
            int start = cin.nextInt();
            int end = cin.nextInt();
            queue.add(start);
            int tot = 0; // 表示有多少条路径可以到
            boolean mark[] = new boolean[n + 1];//用来表示改点是不是已经走过
            mark[start] = true;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int i = 1; i <= n; i++) {
                    if (data[current][i] == 1 && !mark[i]) {
                        if (i == end)
                            tot++;
                        else {
                            queue.add(i);
                            mark[i] = true;
                        }
                    }
                }
            }
            System.out.println("从" + start + "到" + end + "总共有" + tot + "条路径");
        }
    }

}
