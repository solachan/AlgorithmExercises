package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;

//给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR)
// 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
//
// 示例 1:
//
// 输入: s = "1^0|0|1", result = 0
//
//输出: 2
//解释:两种可能的括号方法是
//1^(0|(0|1))
//1^((0|0)|1)
//
//
// 示例 2:
//
// 输入: s = "0&0&0&1^1|0", result = 1
//
//输出: 10
//
// 提示：
//
//
// 运算符的数量不超过 19 个
//
// Related Topics 记忆化搜索 字符串 动态规划 👍 64 👎 0
public class NO08_14_CountEval {
    public static void main(String[] args) {
        NO08_14_CountEval ins = new NO08_14_CountEval();
        String s = "0&0&0&1^1|0";
        int target = 1;
        System.out.println(ins.countEval(s,target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, n-1, result, dp, s);
    }

    private int helper(int start, int end, int target, int[][][] dp, String s) {
        if (start == end) {
            return s.charAt(start) - '0' == target ? 1 : 0;
        }
        if (dp[start][end][target] != -1) {
            return dp[start][end][target];
        }
        int res = 0;
        for (int k = start; k < end; k += 2) {
            char operator = s.charAt(k + 1);
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (calculate(i, j, operator) == target) {
                        res += helper(start,k,i,dp,s) * helper(k+2,end,j,dp,s);
                    }
                }
            }
        }
        dp[start][end][target] = res;
        return res;
    }

    private int calculate(int i, int j, char operator) {
        switch (operator) {
            case '&':
                return i & j;
            case '|':
                return i | j;
            case '^':
                return i ^ j;
        }
        return i & j;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
