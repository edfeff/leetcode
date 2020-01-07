package com.wpp.leet.t5;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 */
public class Main {
    public static void main(String[] args) {

        String s = "aaa";
        System.out.println(new Solution().longestPalindrome(s));
        System.out.println(new Solution().isHui(s));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        return null;
    }

    public boolean isHui(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}