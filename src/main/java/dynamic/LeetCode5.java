package dynamic;

/*
5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
示例 4：

输入：s = "ac"
输出："a"


提示：

1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    // 由于回文段的特性，此题就相当于s与s的反转字符串的最长公共字符串
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length(), maxLen = 0, maxEnd = 0;
        String ss = new StringBuilder(s).reverse().toString();
        int[][] res = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (s.charAt(i - 1) == ss.charAt(j - 1)) {
                    res[i][j] = res[i -1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
                if (res[i][j] > maxLen) {
                    int beforeRev = n - 1 - j;
                    if (beforeRev + res[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = res[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

}
