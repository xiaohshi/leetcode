package string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
451. 根据字符出现频率排序
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。
 */
public class LeetCode451 {

    public static void main(String[] args) {
        System.out.println(frequencySort1("Aabb"));
    }

    // 方法1：利用hash表和最大堆进行计算
    public static String frequencySort1(String s) {
        if (s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHead = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        for (char key : map.keySet()) {
            maxHead.offer(key);
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHead.isEmpty()) {
            char c = maxHead.poll();
            int count = map.get(c);
            for (int i = 0; i < count; i ++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 方法2：利用hash表，依次遍历找值
    public static String frequencySort2(String s) {
        char[] chars = s.toCharArray();
        int[] cs = new int[128];
        for (char aChar : chars) {
            cs[aChar]++;
        }
        int c = 0;
        for (int i = 0; i < 128; i++) {
            int max = i;
            // 找最大值的索引
            for (int j = 0; j < 128; j++) {
                if (cs[j] > cs[max]) max = j;
            }
            for (int k = 0; k < cs[max]; k++) {
                chars[c++] = (char)(max);
            }
            // 将max所在的值变为0，方便后面继续找出最大值
            cs[max] = 0;
            if (c == chars.length) break;
        }
        return new String(chars);
    }

}
