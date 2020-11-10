package divide_conpuer;

import java.util.Arrays;

// 归并排序
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {52, 45, 77, 33, 45, 22, 77, 43};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("最终排序是：" + Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int low, int high){
        int mid = (low + high) / 2;
        if(low < high){
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            // 归并排序的优化
            if (nums[mid] <= nums[mid + 1]) {
                return;
            }
            merge(nums, low, mid, high);
            System.out.println(Arrays.toString(nums));
        }
    }

    // 合并过程
    private static void merge(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k] = nums[i ++];
            } else {
                temp[k] = nums[j ++];
            }
            k ++;
        }
        while (i <= mid) {
            temp[k ++] = nums[i ++];
        }
        while (j <= high) {
            temp[k ++] = nums[j ++];
        }
        for (k = 0; k < temp.length; k ++) {
            nums[k + low] = temp[k];
        }
    }

}
