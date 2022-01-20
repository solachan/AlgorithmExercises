package algorithm.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Hard
 * 887. Super Egg Drop
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break,
 * and any egg dropped at or below floor f will not break.
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it.
 * However, if the egg does not break, you may reuse it in future moves.
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 *
 * Example 1:
 * Input: k = 1, n = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1. If it breaks, we know that f = 0.
 * Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
 * If it does not break, then we know f = 2.
 * Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
 *
 * Example 2:
 * Input: k = 2, n = 6
 * Output: 3
 *
 * Example 3:
 * Input: k = 3, n = 14
 * Output: 4
 *
 * Constraints:
 * 1 <= k <= 100
 * 1 <= n <= 104
 */
public class NO887_SuperEggDrop {
    //动态规划,时间复杂度O(k*n^2)，空间复杂度O(k*n)，运行超时
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int i = 0 ; i <= n ; i++){
            dp[1][i] = i;   //只有1个鸡蛋的话，需要遍历所有情况
            dp[0][i] = 0;   //只有0个鸡蛋的话，无法得到
        }
        for(int j = 0 ; j <= k ; j++){
            dp[j][0] = 0;   //0个阶梯的话不需要操作
        }

        for(int i = 2 ; i <= k ; i++){
            for(int j = 1 ; j <= n ; j++){
                int minStep = Integer.MAX_VALUE;
                for(int x = 1 ; x <= j ; x++){
                    minStep = Math.min(minStep,1+Math.max(dp[i-1][x-1],dp[i][j-x]));
                }
                dp[i][j] = minStep;
            }
        }
        return dp[k][n];
    }
    //动态规划,时间复杂度O(k*n)，空间复杂度O(k*n)
    //我们观察到 dp(k,n) 是一个关于 n 的单调递增函数，也就是说在鸡蛋数 k 固定的情况下，楼层数 n 越多，需要的步数一定不会变少。
    // 在上述的状态转移方程中，第一项 T_1(x) = dp(k-1, x-1)是一个随 x 的增加而单调递增的函数，第二项 T_2(x) = dp(k,n−x) 是一个随着 x 的增加而单调递减的函数。
    //searchTime(K, N) = max( searchTime(K-1, X-1), searchTime(K, N-X) )
    //searchTime(K, N) 假设当N = x时能够获得最小的操作数，则把x将[1,N]分为2部分，在[1,x]区间内searchTime(K, N)是单调递减的，在[x,N]区间内searchTime(K, N)是单调递增的，
    public int superEggDrop2(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int i = 0 ; i <= n ; i++){
            dp[1][i] = i;   //只有1个鸡蛋的话，需要遍历所有情况
            dp[0][i] = 0;   //只有0个鸡蛋的话，无法得到
        }
        for(int j = 0 ; j <= k ; j++){
            dp[j][0] = 0;   //0个阶梯的话不需要操作
        }

        for(int i = 2 ; i <= k ; i++){
            int x = 1;
            for(int j = 1 ; j <= n ; j++){
                while(x < j && Math.max(dp[i-1][x-1],dp[i][j-x]) > Math.max(dp[i-1][x],dp[i][j-x-1]))
                    x++;
                dp[i][j] = 1 + Math.max(dp[i-1][x-1],dp[i][j-x]);
            }
        }
        return dp[k][n];
    }

    Map<Integer, Integer> cache = new HashMap<>();
    //递归时间复杂度O(k*nlogn)，空间复杂度O(k*n)
    public int superEggDrop3(int K, int N) {
        if (N == 0)
            return 0;
        else if (K == 1)
            return N;

        Integer key = N * 1000 + K; // K <= 100
        if (cache.containsKey(key))
            return cache.get(key);

        int low = 1, high = N;
        while (low + 1 < high) {
            int middle = (low + high) / 2;
            int lowVal = superEggDrop3(K - 1, middle - 1);
            int highVal = superEggDrop3(K, N - middle);

            if (lowVal < highVal)
                low = middle;
            else if (lowVal > highVal)
                high = middle;
            else
                low = high = middle;
        }
        int minimum = 1 + Math.min(
                Math.max(superEggDrop3(K - 1, low - 1), superEggDrop3(K, N - low)),
                Math.max(superEggDrop3(K - 1, high - 1), superEggDrop3(K, N - high))
        );

        cache.put(key, minimum);

        return cache.get(key);
    }
}
