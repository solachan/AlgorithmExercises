package algorithm.leetcode.algorithm.interview;

//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
//
// 示例1:
//
//
// 输入：n = 3
// 输出：4
// 说明: 有四种走法
//
//
// 示例2:
//
//
// 输入：n = 5
// 输出：13
//
//
// 提示:
//
//
// n范围在[1, 1000000]之间
//
// Related Topics 记忆化搜索 数学 动态规划 👍 75 👎 0

public class NO08_01_WaysToStep {
    public static void main(String[] args) {
        System.out.println(waysToStep2(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //1、O(n)空间复杂度
    public int waysToStep(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        int mod = 1000000007;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4 ; i <= n ; i++){
            dp[i] = (((dp[i-3] + dp[i-2]) % mod) + dp[i-1]) % mod;
        }
        return dp[n];
    }

    //2、O(1)空间复杂度
    public static int waysToStep2(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[3];
        int mod = 1000000007;
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i = 3 ; i < n ; i++){
            dp[i%3] = (((dp[i%3] + dp[(i-2)%3]) % mod) + dp[(i-1)%3]) % mod;
        }
        return dp[(n-1)%3];
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
