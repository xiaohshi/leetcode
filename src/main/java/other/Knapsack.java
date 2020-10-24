package other;

import java.util.List;

/* 01背包-回溯法
有n件物品，每件物品的重量为w[i]，价值为v[i]。现有一个容量为c的背包，问如何选取物品放入背包，使得背包内物品的总价值最大。其中
每种物品都只有一件。
 */
public class Knapsack {

    /**
     * curValue 表示当前价值
     * curWeight 表示当前重量
     * maxValue 表示最大重量，也就是最优解
     * res 最后存放结果的地方
     */
    private static int curValue, curWeight, maxValue;
    private static int[] res, tmp;

    public static void main(String[] args) {
        // n表示物品的数量，c表示为背包的体积
        int n = 4, c = 10;
        int[] w = {2, 5, 4, 2};
        int[] v = {6, 3, 5, 4};
        res = new int[n];
        tmp = new int[n];
        helper(w, v, c, n, 0);
        System.out.println("最大的背包的最大价值为：" + maxValue);

        StringBuilder sb = new StringBuilder();
        sb.append("放入背包的物品顺序是：");
        for (int i= 0; i < n; i ++) {
            if (res[i] == 1) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    /*
    其中t表示物品的序号
    根据题意进行构造树，其中左子树表示拿该物品，右子树表示不拿该物品，树的高度就是n
    其中剪枝的策略分为左子树和右子树
    左子树剪枝的策略是当重量超过背包容量c时候就剪枝
    右子树剪枝的策略是剩下全拿的价值ideaValue加上当前的价值curValue小于maxValue，即ideaValue + curValue < maxValue表示剩下的就算全拿也不会比之前更大，就直接减掉
     */
    private static void helper(int[] w, int[] v, int c, int n, int t) {
        // 当回溯到树底的时候就退出，将结果记录下来
        if (t > n - 1) {
            for (int i = 0; i < n; i ++) {
                res[i] = tmp[i];
            }
            maxValue = curValue;
            return;
        }

        // 左子树的回溯
        if (curWeight + w[t] <= c) {
            tmp[t] = 1;
            curWeight += w[t];
            curValue += v[t];
            helper(w, v, c, n, t + 1);
            tmp[t] = 0;
            curWeight -= w[t];
            curValue -= v[t];
        }

        // 表示剩下的全部都拿走的价值
        int ideaValue = 0;
        for (int i = t +1; i < n; i ++) {
            ideaValue += v[i];
        }

        //右子树的回溯
        if (ideaValue + curValue > maxValue) {
            tmp[t] = 0;
            helper(w, v, c, n, t + 1);
        }
    }

}
