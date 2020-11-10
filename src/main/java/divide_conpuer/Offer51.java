package divide_conpuer;

/*
剑指 Offer 51. 数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。



示例 1:

输入: [7,5,6,4]
输出: 5
 */
public class Offer51 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7};
        System.out.println(reversePairs(nums));
    }

    private static int res = 0;
    // 例如分治法，就是在归并排序的过程中可以找出所有的逆序对
    public static int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private static void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            // 归并排序的优化
            if (nums[mid] <= nums[mid + 1]) {
                return;
            }
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i ++];
            } else {
                temp[k] = nums[j ++];
                // 表示所有[i, mid]中所有的数都比nums[j]大，由于j不同，则其不会重复计算
                res += mid - i + 1;
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
