package bit;

// 一个数组中，数字三个三个出现，只有一个数字是单独出现，找出这个数字
public class ThreeNum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 5, 3, 4, 4, 4};
        System.out.println(getAloneSum(nums));
    }

    private static int getAloneSum(int[] nums) {
        int[] res = new int[32];
        for (int num : nums) {
            int j = 0;
            while (num != 0) {
                res[j ++] += num % 2;
                num = num / 2;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i ++) {
            if (res[i] % 3 != 0) {
                ans += Math.pow(2, i);
            }
        }
        return ans;
    }

}
