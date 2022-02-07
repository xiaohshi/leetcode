package dynamic;

/*
978. 最长湍流子数组
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

返回 A 的最大湍流子数组的长度。

示例 1：
输入：[9,4,2,10,7,8,8,1,9]
输出：5
解释：(A[1] > A[2] < A[3] > A[4] < A[5])

示例 2：
输入：[4,8,12,16]
输出：2

示例 3：
输入：[100]
输出：1

提示：

1 <= A.length <= 40000
0 <= A[i] <= 10^9

 */
public class LeetCode978 {

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(maxTurbulenceSize1(arr));
    }

    // 动态规划，利用两个数据，一个记录上升的的个数，一个记录下降的个数，时间复杂度是O(n)，空间复杂度是O(n)
    public static int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int n = arr.length, res = 1;
        int[] up = new int[n];
        int[] down = new int[n];

        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < arr.length; i ++) {
            if (arr[i] > arr[i - 1]) {
                up[i] = 1;
                down[i] = up[i - 1] + 1;
            } else if (arr[i] < arr[i - 1]) {
                down[i] = 1;
                up[i] = down[i - 1] + 1;
            } else {
                up[i] = 1;
                down[i] = 1;
            }

            res = Math.max(res, Math.max(down[i], up[i]));

        }

        return res;
    }

    // 双指针，时间复杂度是O(n)，空间复杂度是O(1)
    public static int maxTurbulenceSize1(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len;
        }

        int left = 0, right = 1, res = 1;
        // 为 true 表示 arr[i - 1] < arr[i]
        boolean pre = false;
        while (right < len) {
            boolean current = arr[right - 1] < arr[right];
            if (current == pre) {
                left = right - 1;
            }
            if (arr[right - 1] == arr[right]) {
                left = right;
            }
            right++;
            res = Math.max(res, right - left);
            pre = current;
        }
        return res;
    }

}
