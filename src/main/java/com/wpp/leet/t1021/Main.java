package com.wpp.leet.t1021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，
 * 其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * <p>
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */
public class Main {
    public static void main(String[] args) {
//        String s = "(()())(())";
        String s = "(()())(())(()(()))";
//        String s = "()()";
//        String s = "()";

        String s1 = new Solution().removeOuterParentheses(s);
//        new Solution().splitToPrimeList2(s);

        System.out.println(s1);

    }
}

class Solution {
    public String removeOuterParentheses(String S) {
        List<String> primeList = splitToPrimeList2(S);
        String result = "";
//        StringBuilder ss = new StringBuilder();
        for (String s1 : primeList) {
//            ss.append(s1);
            result += s1;
        }
        return result;
    }

    /**
     * 时间 O(N)
     * 空间 O(N)
     * 使用数组解决
     *
     * @param s
     * @return
     */
    public List<String> splitToPrimeList2(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        final char L = '(';
        int start = 0, lcount = 0, rcount = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == L) {
                lcount++;
            } else {
                rcount++;
            }
            if (lcount == rcount) {
                list.add(s.substring(start + 1, i));
                start = i + 1;
            }
        }

        return list;

    }

    /**
     * 使用栈解决
     *
     * @param s
     * @return
     */
    private List<String> splitToPrimeList(String s) {
        char[] chars = s.toCharArray();
        final char L = '(';
        final char R = '(';
        Stack<Character> stack = new Stack<>();
        List<StringBuilder> all = new ArrayList<>();

        int lCount = 0;
        int lRount = 0;

        for (char c : chars) {
            stack.push(c);

            if (L == c) {
                lCount++;
            } else {
                lRount++;
            }
            if (lCount == lRount) {
                StringBuilder ss = new StringBuilder();
                while (!stack.isEmpty()) {
                    ss.append(stack.pop());
                }
                all.add(ss);

                lCount = 0;
                lRount = 0;
            }

        }
        List<String> result = new ArrayList<>();
        for (StringBuilder builder : all) {
            String s1 = builder.reverse().toString();
            result.add(s1.substring(1, s1.length() - 1));
        }
        return result;
    }
}