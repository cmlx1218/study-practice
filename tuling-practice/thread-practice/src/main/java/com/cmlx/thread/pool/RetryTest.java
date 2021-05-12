package com.cmlx.thread.pool;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 20:07
 * @Desc ->
 **/
public class RetryTest {

    public static void testContinue() {
        cmlx:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(j + ",");
                if (j == 3) {
                    continue cmlx;
                }
            }
            System.out.println();
        }
    }

    public static void testBreak() {
        cmlx:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(j + ",");
                if (j == 3) {
                    break cmlx;
                }
            }
        }
    }

    public static void testBreak1() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(j + ",");
                if (j == 3) {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        testContinue();
        System.out.println();
        testBreak();
        System.out.println();
        testBreak1();

    }

}
