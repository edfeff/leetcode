package com.wpp;

import java.util.*;

/**
 * @author wpp
 */
public class SortStack {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 2, 4, 3, 1, 1);
        Stack<Integer> stack = new Stack<>();
        list.forEach(stack::push);

        Stack<Integer> result = new Solution().run2(stack);
        while (!result.empty()) {
            System.out.println(result.pop());
        }

    }

    static class Solution {
        /**
         * 排序栈
         * 空间复杂度为 O(N)
         * 事件复杂度 O(NlogN)
         *
         * @param source
         * @return
         */
        public Stack<Integer> run(Stack<Integer> source) {
            if (source == null || source.isEmpty()) {
                return source;
            }
            List<Integer> list = new ArrayList<>(source);
            list.sort(Comparator.naturalOrder());
            Stack<Integer> result = new Stack<>();
            list.forEach(result::push);
            return result;
        }

        /**
         * 排序栈
         * 空间复杂度为 O(1)
         * 时间复杂度O(N*N)
         *
         * @param source
         * @return
         */
        public Stack<Integer> run2(Stack<Integer> source) {
            if (source == null || source.isEmpty()) {
                return source;
            }
            Stack<Integer> result = new Stack<>();
            int temp = source.pop();
            //此处取出了一个元素,所以source的尺寸会比原来的小一个
            int total = source.size();
            while (result.size() < total) {
                if (result.isEmpty() || result.peek() <= temp) {
                    result.push(temp);
                    temp = source.pop();
                } else {
                    //result.peek() <= temp
                    source.push(result.pop());
                }
            }
            //最后取出的一个值,还没有放入到result中,此时放入到result中
            result.push(temp);
            return result;
        }
    }
}

