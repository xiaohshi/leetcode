package backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "1111"
输出：["1.1.1.1"]
示例 4：

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
示例 5：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class LeetCode93 {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) {
            return list;
        }
        helper(list, s, new LinkedList<>(), len, 0);
        return list;
    }

    /*
    path：保存数字的链表
    len：字符串的长度
    begin：截取ip段的起始位置
     */
    private static void helper(List<String> list, String s, LinkedList<String> path, int len, int begin) {
        // split表示已经存在的ip段
        int split = path.size();
        // 当起始位置为长度的时候并且ip段为4的时候加入结果集
        if (begin == len && split == 4) {
            list.add(String.join(".", path));
            return;
        }
        // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
            return;
        }
        for (int i = 0; i < 3; i ++) {
            if (begin + i >= len) {
                break;
            }
            int num = judgeIpNum(s, begin, begin + i);
            if (num > -1) {
                path.add(String.valueOf(num));
                helper(list, s, path, len, begin + i + 1);
                path.removeLast();
            }
        }
    }

    // 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
    private static int judgeIpNum(String s, int begin, int end) {
        int len = end - begin + 1;
        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(begin) == '0') {
            return -1;
        }
        int res = 0;
        for (int i = begin; i <= end; i ++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        if (res > 255) {
            return -1;
        }
        return res;
    }
}
