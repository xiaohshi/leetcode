package stack;

import java.util.Stack;

/*
32. 最长有效括号 ★
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class Leetcode32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses1(")()())"));

        System.out.println(longestValidParentheses2(")()())"));

        System.out.println(longestValidParentheses3(")()())"));
    }

    // 暴力解法，有效的括号子串的长度肯定是2的倍数
    public static int longestValidParentheses1(String s) {
        int n = s.length(), len = n;
        if (n % 2 != 0) {
            len = n - 1;
        }
        while (len >= 2) {
            for (int i = 0; i <= n - len; i ++) {
                boolean flag = true;
                Stack<Character> stack = new Stack<>();
                for (int j = 0; j < len; j ++) {
                    char c = s.charAt(j + i);
                    if (c == '(') {
                        stack.push(c);
                    } else if (!stack.isEmpty()){
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag && stack.isEmpty()) {
                    return len;
                }
            }
            len -= 2;
        }
        return 0;
    }

    // 利用栈，重点理解该方法
    public static int longestValidParentheses2(String s) {
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        String maxS = null;
        stack.push(-1);
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    if (len < i - stack.peek()) {
                        maxS = s.substring(stack.peek() + 1, i + 1);
                        len = i - stack.peek();
                    }
                }
            }
        }
        System.out.println(maxS);
        return len;
    }

    // 不使用额外的空间，利用计数法
    public static int longestValidParentheses3(String s) {
        int len = 0, left = 0, right = 0, n = s.length();
        for (int i = 0; i < n; i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left == right) {
                len = Math.max(len, 2 * left);
            } else if (right > left){
                right = left = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                len = Math.max(len, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return len;
    }
}
