package com.wpp;

/**
 * 一些无用的递归算法研究
 *
 * @author wpp
 */
public class RecursiveStudy {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, -1, -4, -2, -1, 9, 10};
        System.out.println(new RecursiveStudy().findMax(arr));
        System.out.println(new RecursiveStudy().sum(arr));
    }


    /**
     * 求和的递归解法
     *
     * @param arr
     * @return
     */
    public int sum(int[] arr) {
        return sum(arr, 0, arr.length - 1);
    }

    private int sum(int[] arr, int low, int high) {
        if (low >= high) {
            return arr[low];
        }
        int mid = (low + high) / 2;
        return sum(arr, low, mid) + sum(arr, mid + 1, high);
    }

    /**
     * 求最大值的递归解法
     *
     * @param arr
     * @return
     */
    public int findMax(int[] arr) {
        return findMax(arr, 0, arr.length - 1);
    }

    private int findMax(int[] arr, int low, int high) {
        if (low >= high) {
            return arr[low];
        }
        int mid = (low + high) / 2;
        int leftMax = findMax(arr, low, mid);
        int rightMax = findMax(arr, mid + 1, high);
        return leftMax > rightMax ? leftMax : rightMax;
    }
}
