package com.cmlx.data.sparsearray;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author cmlx
 * @date 2021/8/10 21:03
 */
public class SparseArray {

    public static void main(String[] args) throws IOException {
        // 1、创建一个原始数组
        // 0：没有棋子 1：黑子 2：蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始数组
        System.out.println("原始数组为》》》》》》");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 2、原始数组转稀疏数组
        // 2.1、有多少个非0数据
        int num = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    num++;
                }
            }
        }
        // 2.2、初始化稀疏数组
        int[][] sparseArr1 = new int[num + 1][3];
        // 2.3、为稀疏数组填充数据
        // 2.3.1、填充第一行数据 行 列 非0数据个数
        sparseArr1[0][0] = 11;
        sparseArr1[0][1] = 11;
        sparseArr1[0][2] = 2;
        int count = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        // 遍历稀疏数组
        System.out.println("稀疏数组为》》》》》》");
        for (int[] row : sparseArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 2.4、将数组写入到文件
        System.out.println("将稀疏数组写入到文件《《《《《");
        Path path = Paths.get("E:\\test\\data\\sparseArray\\store.txt");
        StringBuilder content = new StringBuilder();
        for (int[] row : sparseArr1) {
            for (int data : row) {
                content.append(data).append(" ");
            }
            content.append("\n");
        }
        Files.write(path,content.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND,StandardOpenOption.CREATE);



        // 3、将稀疏数组恢复成原始数组
        // 3.1、初始化原始数组
        System.out.println("从文件读出稀疏数组《《《《《");
        List<String> list = Files.readAllLines(Paths.get("E:\\test\\data\\sparseArray\\store.txt"));
        int size = list.size();
        int[][] newSparseArray = new int[size][3];
        String[] split = null;
        for (int i = 0; i < list.size(); i++) {
            split = list.get(i).split(" ");
            for (int j = 0; j < split.length; j++) {
                newSparseArray[i][j] = Integer.parseInt(split[j]);
            }
        }


        int[][] chessArr2 = new int[newSparseArray[0][0]][newSparseArray[0][1]];
        for (int i = 1; i < newSparseArray.length; i++) {
            chessArr2[newSparseArray[i][0]][newSparseArray[i][1]] = newSparseArray[i][2];
        }

        // 打印恢复的原始数组
        System.out.println("恢复的原始数组为》》》》》》");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }


}
