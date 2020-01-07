package com.wpp.leet.t7;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(-1002));
        System.out.println(new Solution().reverse(1000000002));
        ;
    }
}

class Solution {
    public int reverse(int x) {
        int flag = x >= 0 ? 1 : -1;
        x = x * flag;

        int num = x;
        int sum = 0;
        int last = 0;
        boolean exit = false;
        //最后一位
        while (num > 0 && !exit) {
            last = num % 10;
            num = num / 10;
            if (Integer.MAX_VALUE / 100 < sum && num > 100) {
                sum = 0;
                exit = true;
            } else if (Integer.MAX_VALUE / 10 < sum) {
                sum = 0;
                exit = true;
            } else {
                sum = sum * 10 + last;
            }
        }
        return sum * flag;
    }
}