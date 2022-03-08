package string;

/*
537. 复数乘法
复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：

实部 是一个整数，取值范围是 [-100, 100]
虚部 也是一个整数，取值范围是 [-100, 100]
i2 == -1
给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。

示例 1：

输入：num1 = "1+1i", num2 = "1+1i"
输出："0+2i"
解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。

示例 2：

输入：num1 = "1+-1i", num2 = "1+-1i"
输出："0+-2i"
解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。


提示：

num1 和 num2 都是有效的复数表示。
 */
public class LeetCode537 {

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));

        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));

    }

    public static String complexNumberMultiply(String num1, String num2) {
        int[] res1 = helper(num1);
        int[] res2 = helper(num2);

        int first = res1[0] * res2[0] + res1[1] * res2[1] * -1;
        int second = res1[0] * res2[1] + res1[1] * res2[0];

        return first + "+" + second + "i";
    }

    private static int[] helper(String num) {
        String[] split = num.split("\\+");
        int[] res = new int[2];
        res[0] = Integer.parseInt(split[0]);
        res[1] = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
        return res;
    }

}
