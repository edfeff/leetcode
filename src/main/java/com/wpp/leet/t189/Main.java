package com.wpp.leet.t189;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};

        new Solution().rotate(arr, 2);
//        new Solution().reverse(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}

/**
 * 要求空间复杂度 O(1)
 * 即原地解法
 * <p>
 * i   ni   (i+k)%(len)
 * 0   3       (0+3)%7=3
 * 1   4       (1+3)%7=4
 * 2   5       (2+3)%7=5
 * 3   6       (3+3)%7=6
 * 4   0       (4+3)%7=0
 * 5   1       (5+3)%7=1
 * 6   2       (6+3)%7=2
 * [1,2,3,4,5,6,7]
 * <p>
 * [5,6,7,1,2,3,4]
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}

/**
 * 双 O(N)解法
 */
class Solution0 {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
//        复制出一个数组
        int[] backup = new int[nums.length];
        System.arraycopy(nums, 0, backup, 0, nums.length);
        int len = backup.length;
        k = k % len;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = backup[(i + (len - k)) % len];
        }

    }
}