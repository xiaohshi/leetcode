package other;

/*
剑指 Offer 62. 圆圈中最后剩下的数字
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。



示例 1：

输入: n = 5, m = 3
输出: 3
示例 2：

输入: n = 10, m = 17
输出: 2
 */
public class Offer62 {

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    public static int lastRemaining(int n, int m) {
        byte[] num = new byte[n];
        int count = n, i = 1, j = 0;
        while (count > 1) {
            if (num[j] == 0) {
                if (i == m) {
                    count --;
                    i = 1;
                    num[j] = 1;
                } else {
                    i ++;
                }
            }
            j ++;
            if (j == n) {
                j = 0;
            }
        }
        for (i = 0; i < n; i ++) {
            if (num[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
