package array;

/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class LeetCode59 {

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.println(re[j]);
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (true) {
            for (int i = l; i <= r; i ++) {
                res[t][i] = count ++;
            }
            if (++ t > b) {
                break;
            };
            for (int i = t; i <= b; i ++) {
                res[i][r] = count ++;
            }
            if (-- r < l) {
                break;
            }
            for (int i = r; i >= l; i --) {
                res[b][i] = count ++;
            }
            if (-- b < t) {
                break;
            }
            for (int i = b; i >= t; i --) {
                res[i][l] = count ++;
            }
            if (++ l > r) {
                break;
            }
        }
        return res;
    }

}
