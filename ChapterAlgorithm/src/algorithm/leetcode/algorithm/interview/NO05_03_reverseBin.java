package algorithm.leetcode.algorithm.interview;

//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
//
// 示例 1：
//
// 输入: num = 1775(11011101111)
//输出: 8
//
//
// 示例 2：
//
// 输入: num = 7(0111)
//输出: 4
//
// Related Topics 位运算 动态规划 👍 65 👎 0
public class NO05_03_reverseBin {
    public static void main(String[] args) {
        int num =  2147483647;
        System.out.println(reverseBits(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //1、dp
    //0: dp[i][0] = 0
    //   dp[i][1] = dp[i-1][0] + 1
    //1: dp[i][0] = dp[i-1][0] + 1
    //   dp[i][0] = dp[i-1][1] + 1
    public static int reverseBits(int num) {
        StringBuilder sb = new StringBuilder();
        int tmp = num;
        sb.append(Integer.toBinaryString(num));
        int max = 0;
        int[][]dp = new int[33][2];
        for(int i = 0 ; i <= 32 ; i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = 0;
            }else {
                if(i <= sb.length() && sb.charAt(i-1) == '1'){
                    dp[i][0] = dp[i-1][0]+1;
                    dp[i][1] = dp[i-1][1]+1;
                }else {
                    dp[i][0] = 0;
                    dp[i][1] = dp[i-1][0] + 1;
                }
            }
            max = Math.max(max,dp[i][1]);
        }
        return max;
    }

    //2、滑动窗口法
    public int reverseBits2(int num) {
        int count = 0;//记录窗口中0的数量
        int max = 0;
        int right = 0;//窗口右边界

        for(int left = 0;left<32;left++){//窗口左边界
            //左边界扫描到一个0时，count+1
            if((num&(1<<left))==0) ++count;

            //count>1时，开始收缩右边界，直到满足要求为止
            while(count>1){
                if((num&(1<<right))==0)
                    count-=1;
                ++right;
            }
            max = Math.max(max,left-right+1);
        }
        return max;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
