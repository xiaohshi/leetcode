package divide_conpuer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
315. 计算右侧小于当前元素的个数
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例：

输入：nums = [5,2,6,1]
输出：[2,1,1,0]
解释：
5 的右侧有 2 个更小的元素 (2 和 1)
2 的右侧仅有 1 个更小的元素 (1)
6 的右侧有 1 个更小的元素 (1)
1 的右侧有 0 个更小的元素


提示：

0 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
 */
public class LeetCode315 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return list;
        }
        // 索引数组
        int[] index = new int[len];
        int[] res = new int[len];

        for (int i = 0; i < len; i ++) {
            index[i] = i;
        }

        mergeSort(nums, 0, len - 1, index, res);
        for (int num : res) {
            list.add(num);
        }
        return list;
    }

    private static void mergeSort(int[] nums, int low, int high, int[] index, int[] res) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid, index, res);
        mergeSort(nums, mid + 1, high, index, res);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, low, mid, high, index, res);
    }

    private static void merge(int[] nums, int low, int mid, int high, int[] index, int[] res) {
        int[] temp = new int[high - low + 1];
        int[] tempIndex = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                tempIndex[k] = index[i];
                res[index[i ++]] += j - (mid + 1);
            } else {
                temp[k] = nums[j];
                tempIndex[k] = index[j ++];
            }
            k ++;
        }
        while (i <= mid) {
            res[index[i]] += j - (mid + 1);
            temp[k] = nums[i];
            tempIndex[k ++] = index[i ++];
        }
        while (j <= high) {
            temp[k] = nums[j];
            tempIndex[k ++] = index[j ++];
        }
        for (k = 0; k < temp.length; k ++) {
            nums[k + low] = temp[k];
            index[k + low] = tempIndex[k];
        }
    }
}
