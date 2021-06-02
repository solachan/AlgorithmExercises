package algorithm.leetcode.algorithm;

/**
 * @Author xiepuxin
 * @Description
 * @Date 2021/6/1 20:35
 *
 * Medium
 * 518. Coin Change 2
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 * Example 1:
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * Constraints:
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 */
public class NO518_CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1,2,5};
        System.out.println(change(amount,coins));

    }
    //dp[i][j] 的定义如下：
    //若只使用前 i 个物品，当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包。
    //如果你不把这第 i 个物品装入背包，也就是说你不使用 coins[i] 这个面值的硬币，那么凑出面额 j 的方法数 dp[i][j] 应该等于 dp[i-1][j]，继承之前的结果。
    //如果你把这第 i 个物品装入了背包，也就是说你使用 coins[i] 这个面值的硬币，那么 dp[i][j] 应该等于 dp[i][j-coins[i-1]]。
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0 ; i <= coins.length ; i++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <= coins.length ; i++){
            for(int j = 1; j <= amount ; j++){
                if(j-coins[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
