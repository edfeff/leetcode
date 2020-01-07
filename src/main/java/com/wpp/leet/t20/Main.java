package com.wpp.leet.t20;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * *
 * * 有效字符串需满足：
 * *
 * *
 * * 左括号必须用相同类型的右括号闭合。
 * * 左括号必须以正确的顺序闭合。
 * *
 * *
 * * 注意空字符串可被认为是有效字符串。
 * *
 * * 示例 1:
 * *
 * * 输入: "()"
 * * 输出: true
 * *
 * *
 * * 示例 2:
 * *
 * * 输入: "()[]{}"
 * * 输出: true
 * *
 * *
 * * 示例 3:
 * *
 * * 输入: "(]"
 * * 输出: false
 * *
 * *
 * * 示例 4:
 * *
 * * 输入: "([)]"
 * * 输出: false
 * *
 * *
 * * 示例 5:
 * *
 * * 输入: "{[]}"
 * * 输出: true
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')') {
                if ('(' == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if ('{' == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if ('[' == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}