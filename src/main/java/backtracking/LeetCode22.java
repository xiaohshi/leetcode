package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */
public class LeetCode22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private static void helper(List<String> res, StringBuilder sb, int n, int left, int right) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            helper(res, sb, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            helper(res, sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
