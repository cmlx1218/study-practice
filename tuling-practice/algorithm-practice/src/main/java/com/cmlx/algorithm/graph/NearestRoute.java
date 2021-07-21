package com.cmlx.algorithm.graph;

import java.util.Scanner;

/**
 * @Author CMLX
 * @Date -> 2021/7/21 16:07
 * @Desc ->
 **/
public class NearestRoute {

    public static void main(String[] args) {
        int n, m, x; // n个点，m条边,x表示要求的最短路径的点
        Scanner scanner = new Scanner(System.in);
        //System.out.print("请输入点数：");
        n = scanner.nextInt();
        //System.out.print("请输入边数：");
        m = scanner.nextInt();
        //System.out.println("请输入开始点数：");
        x = scanner.nextInt();

        int[][] value = new int[n + 1][n + 1];    // 表示a到b的路径权重
        int[] dis = new int[n + 1];                 // 表示存最短路径

        // 初始化数据，自己到自己0，其他为INF
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (i == j) value[i][j] = 0;
                else value[i][j] = -1;
            }
        }

        // 填充数据
        //System.out.println("请输入权重：");
        for (int i = 0; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int v = scanner.nextInt();
            value[a][b] = v;
            if (a == x) {
                dis[b] = v;
            }
        }


    }

    private static void search(int x, int dis[], int value[][], int n) {
        boolean mark[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            mark[i] = false;
        }

        mark[x] = true;     // 表示当前这个点已经被加过了
        dis[x] = 0;         // 自己走自己
        int count = 1;      // 表示当前加了几个点了

        while (count <= n) {
            int loc = 0;    // 表示贪心策略里面要加的那个点
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!mark[i] && dis[i] < min) {
                    min = dis[i];
                    loc = i;
                }
            }
            if (loc == 0) break;    // 表示当前已经没有点可以加了
            mark[loc] = true;
            count++;

            for (int i = 1; i <= n; i++) {
                if (!mark[i] && value[loc][i] != -1 && (dis[loc] + value[loc][i] < dis[i])) {
                    dis[i] = dis[loc] + value[loc][i];
                }
            }
        }

        System.out.println("以" + x + "为七点的最短路径");
        for (int i = 1; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE){
                System.out.println(i + "最短为：" + dis[i]);
            }
            else System.out.println(i + "没有路");
        }

    }


}
