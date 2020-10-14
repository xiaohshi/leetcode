package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static String[] keys = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        helper(list, new StringBuilder(), digits);
        return list;
    }

    private static void helper(List<String> list, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        int currentDigit = digits.charAt(sb.length()) - '0';
        String str = keys[currentDigit - 1];
        for (int i = 0; i < str.length(); i ++) {
            sb.append(str.charAt(i));
            helper(list, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
