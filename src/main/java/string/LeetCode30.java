package string;

import java.util.*;

/*
30. 串联所有单词的子串
给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。

示例 1：
输入：s = "barfoothefoobarman", words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
输出：[]

示例 3：
输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
输出：[6,9,12]

提示：

1 <= s.length <= 104
s 由小写英文字母组成
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] 由小写英文字母组成
 */
public class LeetCode30 {

    public static void main(String[] args) {

        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
        System.out.println(findSubstring2(s, words));

        s = "barfoothefoobarman";
        words = new String[]{"foo","bar"};
        System.out.println(findSubstring2(s, words));

        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word","good","best","word"};
        System.out.println(findSubstring2(s, words));

        s = "barfoofoobarthefoobarman";
        words = new String[]{"bar","foo","the"};
        System.out.println(findSubstring2(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length(), word_num = words.length, all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        HashMap<String, Integer> tmp_map = new HashMap<>();
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            boolean flag = false;
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                if (!map.containsKey(w)) {
                    flag = true;
                    break;
                }
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (!flag && map.equals(tmp_map)) {
                res.add(i);
            }
            tmp_map.clear();
        }
        return res;
    }

    public static List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 单词个数 、 单词长度
        int count = words.length, len = words[0].length(), n = s.length();
        int fullLen = count * len;
        Map<String, Integer> indexMap = new HashMap<>();
        for (String word : words) {
            indexMap.putIfAbsent(word, indexMap.size());
        }
        // 单词出现次数，对应indexMap的索引
        int[] wordCount = new int[indexMap.size()];
        for (String word : words) wordCount[indexMap.get(word)]++;
        // 用来对比次数的数组
        int[] tempCount = new int[indexMap.size()];
        for (int i = 0; i < len; i++) {
            for (int start = i, end = start + fullLen - len; start <= end && end + len <= n; end -= len) {
                String temp = s.substring(end, end + len);
                Integer index = indexMap.get(temp);
                // 单词错误 或者 单词出现次数多余结果，跳到下一个字符串
                if (index == null || wordCount[index] == tempCount[index]) {
                    start = end + len;
                    // 每遍历一次都会减一个单位的单词，所以这里不用处理
                    end = start + fullLen;
                    // 重置
                    Arrays.fill(tempCount,0);
                    continue;
                }
                tempCount[index]++;
                // 说明这一串字符串是正确答案，添加结果，从第二个单词开始选择
                if (start == end) {
                    res.add(start);
                    start += len;
                    // 每遍历一次都会减一个单位的单词，所以这里不用处理
                    end = start + fullLen;
                    // 重置
                    Arrays.fill(tempCount,0);
                }
            }
            // 重置
            Arrays.fill(tempCount,0);
        }
        return res;
    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int wordLen = words[0].length(), wordNum = words.length, all_len = wordLen * wordNum;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            //每次移动一个单词长度
            for (int i = j; i < s.length() - all_len + 1; i = i + wordLen) {
                boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (!map.containsKey(word)) {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    hasWords.put(word, hasWords.getOrDefault(word, 0) + 1);
                    //出现情况三，遇到了符合的单词，但是次数超了
                    if (hasWords.get(word) > map.get(word)) {
                        hasRemoved = true;
                        int removeNum = 0;
                        //一直移除单词，直到次数符合了
                        while (hasWords.get(word) > map.get(word)) {
                            String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                            int v = hasWords.get(firstWord);
                            hasWords.put(firstWord, v - 1);
                            removeNum++;
                        }
                        num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                        i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                        break;
                    }
                    num++;
                }
                if (map.equals(hasWords)) {
                    res.add(i);
                }
                //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }
            }
        }
        return res;
    }

}
