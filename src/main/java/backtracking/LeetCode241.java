package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
241. 为运算表达式设计优先级
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

示例 1:

输入: "2-1-1"
输出: [0, 2]
解释:
((2-1)-1) = 0
(2-(1-1)) = 2
示例 2:

输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */
public class LeetCode241 {

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    // map集合避免进行重复的计算，用空间换时间
    private static final Map<String, List<Integer>> map = new HashMap<>();

    // 利用分治法+递归完成
    // 该问题就可以划分为X op Y的问题，op就相当于操作符，X就相当于op的左边，Y就相当于op的右边
    public static List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> res = new ArrayList<>();
        int num = 0, i = 0;
        for (; i < input.length(); i ++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            num = num * 10 + c - '0';
        }
        // 表示纯数字
        if (i == input.length()) {
            res.add(num);
            map.put(input, res);
            return res;
        }
        for (; i < input.length(); i ++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 计算左边的表达式
                List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));
                // 计算右边的表达式
                List<Integer> rightRes = diffWaysToCompute(input.substring(i + 1));
                // 计算，进行组合
                for (int leftNum : leftRes) {
                    for (int rightNum : rightRes) {
                        int ans = 0;
                        switch (c) {
                            case '+':
                                ans = leftNum + rightNum;
                                break;
                            case '-':
                                ans = leftNum - rightNum;
                                break;
                            case '*':
                                ans = leftNum * rightNum;
                                break;
                        }
                        res.add(ans);
                    }
                }
            }
        }
        map.put(input, res);
        return res;
    }

}
