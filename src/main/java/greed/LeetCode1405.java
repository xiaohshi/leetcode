package greed;

import java.util.Arrays;
import java.util.Comparator;

/*
1405. 最长快乐字符串
如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。

给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：

s 是一个尽可能长的快乐字符串。
s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
s 中只含有 'a'、'b' 、'c' 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。

示例 1：
输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc" 也是一种正确答案。

示例 2：
输入：a = 2, b = 2, c = 1
输出："aabbc"

示例 3：
输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。

提示：
0 <= a, b, c <= 100
a + b + c > 0
 */
public class LeetCode1405 {

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));
    }

    /*
    贪心算法：
    优先使用数量最多的字符 来拼凑字符串，当数量最多的与已拼凑的字符串后两位相同时，我们应该使用数量次多的字符 来拼凑字符串，依次往复，最终可以得到我们的结果
     */
    public static String longestDiverseString(int a, int b, int c) {
        int[][] arr = {{'a', a}, {'b', b}, {'c', c}};
        StringBuilder sb = new StringBuilder();
        while (true) {
            // 使用数组维护三个数量的大小关系，每使用一个字符就重新计算数量，重新排序
            Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

            int n = sb.length();
            if (arr[0][1] == 0) {
                break;
            }

            if (n >=2 && sb.charAt(n - 1) == arr[0][0] && sb.charAt(n - 2) == arr[0][0]) {
                if (arr[1][1] == 0) {
                    break;
                }
                sb.append((char)arr[1][0]);
                arr[1][1] --;
            } else {
                sb.append((char)arr[0][0]);
                arr[0][1] --;
            }
        }

        return sb.toString();
    }

}
