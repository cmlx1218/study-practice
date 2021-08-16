package com.cmlx.data.search;

/**
 * @Author CMLX
 * @Date -> 2021/8/16 12:21
 * @Desc -> 二分查找，猜数字游戏
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int data[] = {1, 3, 5, 6, 87, 90};
        int i = binarySearch(data, 6);
        System.out.println(i);
        int i1 = binarySearch(data, 6, 0, data.length - 1);
        System.out.println(i1);
    }

    public static int binarySearch(int data[], int x, int low, int high) {
        if (low > high || x > data[high] || x < data[low]) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (data[mid] > x) {
            return binarySearch(data, x, low, mid - 1);
        } else if (data[mid] < x) {
            return binarySearch(data, x, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static int binarySearch(int data[], int x) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] > x) {
                high = mid - 1;
            }
            if (data[mid] < x) {
                low = mid + 1;
            }
            if (data[mid] == x) {
                return mid;
            }
        }
        return -1;
    }
}
