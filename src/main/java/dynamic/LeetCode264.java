package dynamic;

/*
264. 丑数 II
编写一个程序，找出第 n 个丑数。

丑数就是质因数只包含 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:

1 是丑数。
n 不超过1690。
 */
public class LeetCode264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int a = 1, b = 1, c = 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int x = res[a] * 2, y = res[b] * 3, z = res[c] * 5;
            res[i] = Math.min(x, Math.min(y, z));
            if (res[i] == x) {
                a ++;
            }
            if (res[i] == y) {
                b ++;
            }
            if (res[i] == z) {
                c ++;
            }
        }
        return res[n];
    }

}
