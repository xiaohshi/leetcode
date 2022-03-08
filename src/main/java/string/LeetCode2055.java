package string;

import java.util.Arrays;
import java.util.TreeSet;

/*
2055. 蜡烛之间的盘子
给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。

同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。

比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。

示例 1:

输入：s = "**|**|***|", queries = [[2,5],[5,9]]
输出：[2,3]
解释：
- queries[0] 有两个盘子在蜡烛之间。
- queries[1] 有三个盘子在蜡烛之间。

示例 2:

输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
输出：[9,0,0,0,0]
解释：
- queries[0] 有 9 个盘子在蜡烛之间。
- 另一个查询没有盘子在蜡烛之间。

提示：

3 <= s.length <= 105
s 只包含字符 '*' 和 '|' 。
1 <= queries.length <= 105
queries[i].length == 2
0 <= lefti <= righti < s.length
 */
public class LeetCode2055 {

    public static void main(String[] args) {
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        System.out.println(Arrays.toString(platesBetweenCandles("***|**|*****|**||**|*", queries)));
    }

    /*
    前缀和，预处理，利用treeSet的特性
     */
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i ++) {
            char c = s.charAt(i);
            if (c == '|') {
                treeSet.add(i);
                preSum[i] = i - 1 < 0 ? 0 : preSum[i - 1];
            } else {
                preSum[i] = i - 1 < 0 ? 1 : preSum[i - 1] + 1;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i ++) {
            int[] query = queries[i];
            // 在这个集合大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
            Integer left = treeSet.ceiling(query[0]);
            // 在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
            Integer right = treeSet.floor(query[1]);
            if (left != null && right != null && left < right) {
                res[i] = preSum[right] - preSum[left];
            }
        }
        return res;
    }

}
