package com.wpp.leet.t66;

import java.util.ArrayList;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{9, 9, 9};
        System.out.println(new Solution().arr2int(b));
        System.out.println(new Solution().int2arr(1000));
        System.out.println(new Solution().int2arr(999));
        System.out.println(new Solution().int2arr(10));
        System.out.println(new Solution().int2arr(1));
        System.out.println(new Solution().int2arr(0));


    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        return int2arr(arr2int(digits) + 1);
    }

    public int arr2int(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum = sum * 10 + digits[i];
        }
        return sum;
    }

    public int[] int2arr(int num) {
        int len = 0;
        while (num > 0) {
            int last = num % 10;
            num = num / 10;
            len++;
        }
        System.out.println(len);

        return null;

    }
}