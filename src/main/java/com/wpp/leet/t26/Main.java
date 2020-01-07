package com.wpp.leet.t26;

public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[]{};
//        int[] arr = new int[]{1};
//        int[] arr = new int[]{1, 1};
//        int[] arr = new int[]{1, 2};
        int[] arr = new int[]{1, 1, 2};
//        int[] arr = new int[]{1, 1, 2};
//        int[] arr = new int[]{1, 1, 2,2,2};
//        int[] arr = new int[]{1, 1, 2,2,2,3,3,3};
//        int[] arr = new int[]{1, 1, 2,2,2,3,3,4,4,4,5};
        int i = new Solution().removeDuplicates(arr);
        System.out.println(i);
        System.out.println();
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
//        1 保证 空数据和长度为0的数组是正确
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        总体思想是,将数组切分成两组 [0,tag][tag+1,length-1]
//        使用 tag 进行分割
//        [0,tag] 称为 目标组,用于盛放所有不同的数据
//        [tag+1,length-1] 称为待定组,所有待比较或者未通过的元素都在此区间

//      起始目标区间为[0,0]
        int tag = 0;
//      起始待定区间为[1,length-1]
        int right = tag + 1;

//       下面就是元素在两个区间移动的逻辑

//        2 right的移动范围限制
        while (right < nums.length) {
//            3 比较 目标区间最后一个值 和待定区间的第一个值

//            3.1 如果相等,说明不能添加到目标区间中,所以直接把right后移一位
            if (nums[tag] == nums[right]) {
                right++;
            } else {
//                3.2 如果不相等,说明可以添加到目标区间中
//                直接把tag扩增一位,然后把待定区间的数字复制过来,然后right在后移一位,以便下一次判断
                nums[++tag] = nums[right++];
            }
        }
//    4 返回目标区间的长度
        return tag + 1;
    }
}