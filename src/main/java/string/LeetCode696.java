package string;

/*
696. 计数二进制子串
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

重复出现的子串要计算它们出现的次数。

示例 1 :

输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

请注意，一些重复出现的子串要计算它们出现的次数。

另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :

输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
注意：

s.length 在1到50,000之间。
s 只包含“0”或“1”字符。
 */
public class LeetCode696 {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }

    /*
    1、按照0和1的连续段分组，例如s=00111011，就可以得出count数组为{2,3,1,2}
    2、假设counts 数组中两个相邻的数字为u或者v，它们对应着u个0和v个 11，或者u个1和v个0。它们能组成的满足条件的子串数目为min{u,v}
    3、遍历所有的相邻的数对，求和即可
     */
    public static int countBinarySubstrings(String s) {
        int i = 0, res = 0, temp = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                i ++;
                count ++;
            }
            res += Math.min(count, temp);
            temp = count;
        }
        return res;
    }
}
