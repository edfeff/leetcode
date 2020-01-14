package com.wpp;

/**
 * 一些无用的递归算法研究
 *
 * @author wpp
 */
public class RecursiveStudy {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, -1, -4, -2, -1, 9, 10};
        int[] arr2 = new int[]{1, 2, 3, 1, 4, 2, 1, 9, 10};
//        System.out.println(new RecursiveStudy().findMax(arr));
//        System.out.println(new RecursiveStudy().sum(arr));
        System.out.println(new RecursiveStudy().maxSubArrSum(arr));
        System.out.println(new RecursiveStudy().maxSubArrSum(arr2));
//        System.out.println(new RecursiveStudy().maxCrossingArrSum(arr, 0, 0, 1));
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


    /**
     * 最大子串和
     *
     * @param arr
     * @return
     */
    public int maxSubArrSum(int[] arr) {
        return maxSubArrSum(arr, 0, arr.length - 1);
    }

    private int maxSubArrSum(int[] arr, int low, int high) {
        if (low >= high) {
            return arr[low];
        }
        int mid = (low + high) / 2;
        int leftMax = maxSubArrSum(arr, low, mid);
//        System.out.println("left: " + low + "--" + mid + " = " + leftMax);

        int rightMax = maxSubArrSum(arr, mid + 1, high);
//        System.out.println("right: " + (mid + 1) + "--" + high + " = " + rightMax);

        int midMax = maxCrossingArrSum(arr, low, mid, high);
//        System.out.println("Cross: " + low + "--" + mid + "--" + high + " = " + midMax);

        int max = leftMax > rightMax ? leftMax : rightMax;
        max = max > midMax ? max : midMax;
        return max;
    }

    /**
     * 跨越中点的最子数组之和
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private int maxCrossingArrSum(int[] arr, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int lSum = 0;
        for (int i = mid; i >= low; i--) {
            lSum += arr[i];
            leftMax = lSum > leftMax ? lSum : leftMax;
        }
        int rSum = 0;
        for (int i = mid + 1; i <= high; i++) {
            rSum += arr[i];
            rightMax = rSum > rightMax ? rSum : rightMax;
        }
        return leftMax + rightMax;
    }

    public int maxSubArrSumN2(int[] arr) {
        return 0;
    }
}
