package review.shopee;

import java.util.PriorityQueue;

public class FirstCode {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 5, 4};
        System.out.println(helper(nums, 0, nums.length - 1, (nums.length - 1) / 2));

        System.out.println(helper1(nums));
    }

    // 利用快排划分的思想
    private static int helper(int[] nums, int p, int q, int k) {
        if (p >= q) {
            return nums[p];
        }
        int x = nums[q];
        int i = p - 1;
        for (int j = p; j < q; j ++) {
            if (nums[j] < x) {
                i ++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, q);
        int r = i + 1, s = r - p;
        if (s == k) {
            return nums[r];
        } else if (s > k) {
            return helper(nums, p, r - 1, k);
        } else {
            return helper(nums, r + 1, q, k - r - 1);
        }
    }

    private static void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    // 利用最大堆，该题就转化为topk问题
    private static int helper1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int n = nums.length, k = 0;
        if (n % 2 == 0) {
            k = n / 2;
        } else {
            k = (n + 1) / 2;
        }

        for (int i = 0; i < k; i ++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i ++) {
            if (queue.peek() > nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        return queue.peek();
    }

}
