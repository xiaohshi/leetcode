package review.review01;

import java.util.ArrayList;
import java.util.List;

public class Review01 {

    public static void main(String[] args) {
        int[][] nums = {
                {0, 1, 1, 1},
                {2, -1, 0, 1},
                {2, -1, 0, 1},
                {2, 2, 2, 0}
        };
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0, 0);
        List<Integer> list = res.get(res.size() - 1);
        list.add(nums[nums.length - 1][nums[0].length - 1]);
        System.out.println(list);
    }

    private static int ans = Integer.MAX_VALUE;
    private static void helper(List<List<Integer>> res, List<Integer> list, int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || nums[i][j] == -1) {
            return;
        }
        if (i == nums.length - 1 && j == nums[0].length - 1) {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            if (sum < ans) {
                ans = sum;
                res.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[i][j]);
        int temp = nums[i][j];
        nums[i][j] = -1;
        helper(res, list, nums, i - 1, j);
        helper(res, list, nums, i + 1, j);
        helper(res, list, nums, i, j - 1);
        helper(res, list, nums, i, j + 1);
        nums[i][j] = temp;
        list.remove(list.size() - 1);
    }

}
