package review.vivo;

import java.util.ArrayList;
import java.util.List;

/*
给两个数为m, n，从0-m中找出一个组合之和为m, 同时组合的长度为n，求这个组合的个数，元素不限使用，组合不能重复
 */
public class Firstcode {

    public static void main(String[] args) {
        System.out.println(connect(3, 3));
    }

    public static int connect (int m, int n) {
        // write code here
        helper(new ArrayList<>(), m, m, n, 0);
        return res;
    }

    private static int res = 0;
    private static void helper(List<Integer> list, int sum, int m, int n, int start) {
        if (list.size() == n) {
            if (sum == 0) {
                res ++;
            }
            return;
        }
        for (int i = start; i <= m; i ++) {
            if (i > sum) {
                continue;
            }
            list.add(i);
            helper(list, sum - i, m, n, i);
            list.remove(list.size() - 1);
        }
    }
}
