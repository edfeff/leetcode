package com.wpp.leet.t217;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(new Solution().containsDuplicate(arr));
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}