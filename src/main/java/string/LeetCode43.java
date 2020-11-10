package string;

import java.math.BigInteger;
import java.util.*;

/*
43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class LeetCode43 {

    public static void main(String[] args) {

        String num1 = "52542636451019833812010341923292821808108157849510110089518543821001023450891023450101580831400118";
        String num2 = "59808560905000158467583737408810718932805314187123001508750187751346758963489534125879101893475";

        long cur = System.currentTimeMillis();
        System.out.println(multiply1(num1, num2));
        System.out.println(System.currentTimeMillis() - cur);

        cur = System.currentTimeMillis();
        System.out.println(multiply2(num1, num2));
        System.out.println(System.currentTimeMillis() - cur);

        BigInteger nums1 = new BigInteger(num1);
        BigInteger nums2 = new BigInteger(num2);

        cur = System.currentTimeMillis();
        System.out.println(nums1.multiply(nums2));
        System.out.println(System.currentTimeMillis() - cur);
    }

    /*
    就是每一位先相乘，然后统一相加
           9  8
         x 2  1
      -------------
          (9)(8)   <---- 第1趟: 98×1的每一位结果
      (18)(16)     <---- 第2趟: 98×2的每一位结果
      -------------
      (18)(25)(8)  <---- 这里就是相对位的和，还没有累加进位

     */
    public static String multiply2(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i ++) {
            for (int j = 0; j < num2.length(); j ++) {
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = res.length - 1; i > 0; i --) {
            if (res[i] >= 10) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i ++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }

    // 用一个数乘以一个数位，类似于小学数学算式，很复杂，而且复杂度很高，不推荐
    private static Map<String, List<Integer>> map = new HashMap<>();
    public static String multiply1(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        if (n == 0 || m == 0) {
            return null;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (n < m) {
            return multiply1(num2, num1);
        }
        int res, flag = 0;
        List<List<Integer>> lists = new ArrayList<>(m);
        for (int i = m - 1; i >= 0; i --) {
            int b = num2.charAt(i) - '0';
            String key = num1 + "x" + b;
            LinkedList<Integer> list = new LinkedList<>();
            if (map.containsKey(key)) {
                list.addAll(map.get(key));
            } else {
                for (int j = n - 1; j >= 0; j --) {
                    int a = num1.charAt(j) - '0';
                    res = a * b + flag;
                    flag = res / 10;
                    list.add(res % 10);
                }
                if (flag != 0) {
                    list.add(flag);
                    flag = 0;
                }
                map.put(key, new ArrayList<>(list));
            }
            for (int c = 0; c < m - i - 1; c ++) {
                list.addFirst(0);
            }
            lists.add(list);
        }
        int len = lists.get(lists.size() - 1).size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i ++) {
            int sum = 0;
            for (int j = 0; j < m; j ++) {
                if (lists.get(j).size() > i) {
                    sum += lists.get(j).get(i);
                }
            }
            res = sum + flag;
            flag = res / 10;
            sb.append(res % 10);
        }
        if (flag != 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}