package com.wpp.leet.t9;

/**
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数
 * <p>
 * 1111
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1000));
        ;
        int num = 22222222;
        int back = num;
        int sum = 0;
        int last = 0;
        boolean exit = false;
        //最后一位
        while (num > 0 && !exit) {
            last = num % 10;
            num = num / 10;
            if (Integer.MAX_VALUE / 100 < sum && num > 100) {
                exit = true;
            } else if (Integer.MAX_VALUE / 10 < sum) {
                exit = true;
            } else {
                sum = sum * 10 + last;
            }
        }
        if (sum == back) {
            System.out.println("===");
        }
//        2147483647
        System.out.println(sum);
        System.out.println(Integer.MAX_VALUE);
    }

}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int sum = 0;
        int last = 0;
        boolean exit = false;
        //最后一位
        while (num > 0 && !exit) {
            last = num % 10;
            num = num / 10;
            if (Integer.MAX_VALUE / 100 < sum && num > 100) {
                exit = true;
            } else if (Integer.MAX_VALUE / 10 < sum) {
                exit = true;
            } else {
                sum = sum * 10 + last;
            }
        }

        return sum == x;
    }
}

