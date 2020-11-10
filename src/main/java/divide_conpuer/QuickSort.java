package divide_conpuer;

import java.util.Arrays;

// 快速排序，同样是分治法
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 8, 7, 1, 3, 5, 6, 4, 5, 1, 9, 6};
        System.out.println("迭代过程：");
        quickSort(nums, 0, nums.length - 1);
        System.out.println("最终排序是：" + Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);

            // 记录结果便于观察
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = p; i <= r; i ++) {
                sb.append(nums[i]);
                if (i == q) {
                    sb.append("*");
                }
                if (i != r) {
                    sb.append(",").append(" ");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());

            quickSort(nums, p, q - 1);
            quickSort(nums, q + 1, r);
        }
    }

    private static int partition(int[] nums, int p, int r) {
        int x = nums[r], i = p - 1;
        for (int j = p; j < r; j ++) {
            if (nums[j] <= x) {
                i ++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int p, int r) {
        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;
    }

}
