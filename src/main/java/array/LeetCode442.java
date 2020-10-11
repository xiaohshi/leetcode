package array;

import java.util.ArrayList;
import java.util.List;

/*
442. 数组中重复的数据
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]
 */
public class LeetCode442 {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i ++) {
//            while (nums[i] != i + 1) {
//                if (nums[nums[i] - 1] == nums[i]) {
//                    if (!list.contains(nums[i])) {
//                        list.add(nums[i]);
//                    }
//                    break;
//                }
//                int temp = nums[i];
//                nums[i] = nums[temp - 1];
//                nums[temp - 1] = temp;
//            }
//        }
        for (int i = 0; i < nums.length; i ++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                list.add(num);
            }
        }
        return list;
    }

}
