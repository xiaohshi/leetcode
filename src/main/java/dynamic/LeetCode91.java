package dynamic;

import java.util.HashMap;
import java.util.Map;

/*
91. 解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

题目数据保证答案肯定是一个 32 位的整数。



示例 1：

输入："12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2：

输入："226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
示例 3：

输入：s = "0"
输出：0
示例 4：

输入：s = "1"
输出：1
示例 5：

输入：s = "2"
输出：1
 */
public class LeetCode91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("23426"));
    }

    // 动态规划
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    // 利用递归进行求解，利用map保存结果，性能较低
    private static final Map<String, Integer> map = new HashMap<>();
    public static int numDecodings2(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int res = -1, n = s.length();
        if (n == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            res = 0;
        } else if (n == 1) {
            res = 1;
        }
        if (res != -1) {
            map.put(s, res);
            return res;
        }
        // 其中有两种方案，一种就是最后两个+前面字符，还有一种就是最后一个+前面字符。需要判断最后分割的字符是否符合条件
        res = helper(String.valueOf(s.charAt(n - 1))) * numDecodings2(s.substring(0, n - 1))
                + helper(s.substring(n - 2, n)) * (numDecodings2(s.substring(0, n - 2)));
        map.put(s, res);
        return res;
    }

    // 判断字符是否符合规范，不符合就表示该划分是错误的
    private static int helper(String s) {
        if (s.charAt(0) == '0' || (Integer.parseInt(s) > 26)) {
            return 0;
        }
        return 1;
    }
}
