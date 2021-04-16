package array;

import java.util.*;

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]


提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class LeetCode15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    // 该思想利用哈希表，遍历数组的时候，将其中一个数字固定，变成两数和的问题
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        // 需要先排序
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        Integer t;
        int target;
        for(int i = 0; i < nums.length; ++i){
            target = -nums[i];
            //去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; ++ j){
                // 同样避免重复
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if((t = map.get(target - nums[j])) != null){
                    //可以避免重复计算以及无效的结果
                    if(t <= j) {
                        break;
                    }
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[t])));
                }
            }
        }
        return res;
    }

}
