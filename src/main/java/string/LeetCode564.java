package string;

import java.util.ArrayList;
import java.util.List;

public class LeetCode564 {

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("10001"));

        System.out.println(addDigits(38));
    }

    /*
    1、用原数的前半部分替换后半部分得到的回文整数。
    2、用原数的前半部分加一后的结果替换后半部分得到的回文整数。
    3、用原数的前半部分减一后的结果替换后半部分得到的回文整数。
    4、为防止位数变化导致构造的回文整数错误，因此直接构造99...99 和 100...001作为备选答案。
     */
    public static String nearestPalindromic(String n) {
        int len = n.length();
        List<Long> nums = new ArrayList<>();
        // 考虑数据的临界情况
        nums.add((long) (Math.pow(10, len - 1) - 1));
        nums.add((long) (Math.pow(10, len) + 1));

        long pre = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = pre - 1; i <= pre + 1; i ++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            StringBuilder reverse = new StringBuilder(sb).reverse();
            sb.append(reverse.substring(len % 2));
            String s = sb.toString();
            nums.add(Long.parseLong(s));
        }

        long res = 0, sNum = Long.parseLong(n);
        for (long num : nums) {
            if (sNum == num) {
                continue;
            }
            long a = Math.abs(num - sNum);
            long b = Math.abs(res - sNum);
            if (a < b || (a == b && num < res)) {
                res = num;
            }
        }

        return String.valueOf(res);
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int res = 0;
        while (true) {
            int temp = 0;
            while (num != 0) {
                temp += num % 10;
                num = num / 10;
            }
            if (temp < 10) {
                res = temp;
                break;
            }
            num = temp;
        }
        return res;
    }

}
