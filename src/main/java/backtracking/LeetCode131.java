package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class LeetCode131 {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.isEmpty()) {
            return res;
        }
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private static void helper(List<List<String>> res, List<String> list, String s, int begin) {
        int len = s.length();
        if (begin == len) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < len; i ++) {
            String sub = s.substring(begin, i + 1);
            if (isPalindromeString(sub)) {
                list.add(sub);
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindromeString(String s) {
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin ++) != s.charAt(end --)) {
                return false;
            }
        }
        return true;
    }

}
