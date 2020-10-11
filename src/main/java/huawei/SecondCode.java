package huawei;

import java.util.Arrays;

public class SecondCode {

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 5};
        int[] res = helper(nums);
        Arrays.sort(res);
        int i = 0, j = res.length - 1;
        while (i <= j) {
            int temp = res[i];
            res[i ++] = res[j];
            res[j --] = temp;
        }
        for (int num : res) {
            System.out.println(num);
        }
    }

    private static int[] helper(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            int num = 1;
            for (int j = 0; j < nums.length; j ++) {
                if (i != j) {
                    num = num * nums[j];
                }
            }
            res[i] = num;
        }
        return res;
    }

}
