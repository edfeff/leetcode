package com.wpp.leet.t136;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * O(N) O(1)
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3, 4, 4, 1};
        System.out.println(new Solution().singleNumber(nums));
    }
}

//数学
//2∗(a+b+c)−(a+a+b+b+c)=c
class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Integer sum = list.stream().reduce(Integer::sum).get();
        Integer setSum2 = 2 * list.stream().distinct().reduce(Integer::sum).get();

        return setSum2 - sum;
    }
}

//异或
class Solution2 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }

}

class Solution1 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == counts.get(nums[i])) {
                counts.put(nums[i], 1);
            } else {
                counts.put(nums[i], counts.get(nums[i]) + 1);
            }
        }
        for (Integer k : counts.keySet()) {
            if (counts.get(k) == 1) {
                return k;
            }
        }
        return -1;
    }
}
