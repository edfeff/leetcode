package com.wpp.leet.t53;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{-2, 1};
//        System.out.println(new Solution().maxSubArray(arr));
        System.out.println(new Solution().maxSubArray(arr));

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
//        return solution1(nums);
        return solution2(nums, 0, nums.length - 1);
    }

    private int solution2(int[] nums, int low, int high) {
        if (low >= high) {
            return nums[low];
        }
        int mid = (low + high) / 2;
        int leftM = solution2(nums, low, mid);
        int rightM = solution2(nums, mid + 1, high);
        int crossM = maxCrossSub(nums, low, mid, high);

        int max = leftM > rightM ? leftM : rightM;
        max = max > crossM ? max : crossM;
        return max;
    }

    private int maxCrossSub(int[] nums, int low, int mid, int high) {
        int sum = 0;
        int lM = Integer.MIN_VALUE;
        int rM = Integer.MIN_VALUE;

        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            lM = lM > sum ? lM : sum;
        }
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            rM = rM > sum ? rM : sum;
        }
        return lM + rM;
    }

    private int solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                list.add(sum(nums, i, j));
            }
        }
        int max = list.get(0);
        for (Integer item : list) {
            max = max > item ? max : item;
        }
        return max;
    }

    private Integer sum(int[] nums, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += nums[k];
        }
        return s;
    }

}