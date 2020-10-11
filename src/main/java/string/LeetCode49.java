package string;

import java.util.*;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

链接：https://leetcode-cn.com/problems/group-anagrams
 */
public class LeetCode49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    // 同利用hash，两个hash表表示相应的
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        int[] a = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(a, 0);
            for (int i = 0; i < str.length(); i ++) {
                a[str.charAt(i) - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i ++) {
                if (a[i] != 0) {
                    sb.append(i + 'a').append(a[i]);
                }
            }
            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>());
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
