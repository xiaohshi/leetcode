package string;

import java.util.LinkedList;
import java.util.Stack;

/*
394. 字符串解码 ★
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。



示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：

输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：

输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：

输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
通过次数87,174提交次数160,547
 */
public class LeetCode394 {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[bc]]"));
    }

    private static int i = 0;
    public static String decodeString(String s) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (i < s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                list.addLast(getDigit(s));
            } else if (Character.isLetter(c) || c == '[') {
                list.addLast(String.valueOf(c));
                i ++;
            } else {
                Stack<String> sub = new Stack<>();
                while (!"[".equals(list.peekLast())) {
                    sub.push(list.removeLast());
                }
                list.removeLast();
                int num = Integer.parseInt(list.removeLast());
                StringBuilder str = new StringBuilder();
                while (!sub.isEmpty()) {
                    str.append(sub.pop());
                }
                String o = str.toString();
                StringBuilder ss = new StringBuilder();
                for (int j = 0; j < num; j ++) {
                    ss.append(o);
                }
                list.addLast(ss.toString());
                i ++;
            }
        }

        for (String ss : list) {
            sb.append(ss);
        }
        return sb.toString();
    }

    private static String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i ++));
        }
        return sb.toString();
    }

}
