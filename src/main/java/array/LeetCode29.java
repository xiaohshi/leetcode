package array;

/*
29. 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例 2:

输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class LeetCode29 {

    public static void main(String[] args) {
        System.out.println(divide(10, 3));

        System.out.println(divide(-2147483648, 2));
    }

    /*
    比如，假定被除数为 20，除数为 3，使用倍乘法的过程如下：
    1、计算 3 的 2^x2 x的最大值（不超过 20），为 3 * 2^2 =12，拿 20 - 12 得到 8，做为新的被除数。
    2、计算 3 的 2^x2 x的最大值（不超过 8），为 3 * 2^1 = 6，拿 8 - 6得到 2，做为新的被除数。
    3、判断新的被除数 2 小于 3 了，退出计算过程，最后的结果就是 2^2 + 2^1 = 62
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            return -dividend;
        }

        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }

        // 将所有的数转化为负数，防止溢出
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int ans = 0;
        while (dividend <= divisor) {
            int temp = divisor, count = 1;
            while (temp >= dividend - temp) {
                // temp和count每次都增加一倍
                temp += temp;
                count += count;
            }
            ans += count;
            dividend -= temp;
        }
        return ans * sign;
    }

}
