package dynamic;

public class LeetCode300 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(change(5, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] res = new int[amount + 1];
        res[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i ++) {
                if (i - coin >= 0) {
                    res[i] += res[i - coin];
                }
            }
        }
        return res[amount];
    }
}
