package string;

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */
public class LeetCode14 {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    // 横向扫描，逐个对比
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            int length = Math.min(prefix.length(), strs[i].length());
            int index = 0;
            while (index < length && prefix.charAt(index) == strs[i].charAt(index)) {
                index ++;
            }
            prefix = prefix.substring(0, index);
            if (prefix.isEmpty()) {
                return null;
            }
        }
        return prefix;
    }
}
