package com.wpp.leet.t122;

public class Main {
    public static void main(String[] args) {
        int[] arr = null;
        new Solution().maxProfit(arr);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int d = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            d = prices[i + 1] - prices[i];
            if (d > 0) {
                ans += d;
            }
        }
        return ans;
    }
}
