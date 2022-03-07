package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;

//堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最
//高的一堆箱子。箱堆的高度为每个箱子高度的总和。
//
// 输入使用数组[wi, di, hi]表示每个箱子。
//
// 示例1:
//
//  输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
// 输出：6
//
//
// 示例2:
//
//  输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
// 输出：10
//
//
// 提示:
//
//
// 箱子的数目不大于3000个。
//
// Related Topics 数组 动态规划 排序 👍 63 👎 0
public class NO08_13_PileBox {
    public static void main(String[] args) {
//        int[][] box = new int[][]{{1, 1, 1},{2, 2, 2},{3, 3, 3}};
        int[][] box = new int[][]{{1, 1, 1},{2, 3, 4},{2, 6, 7},{3, 4, 5}};
        System.out.println(pileBox(box));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public static int pileBox(int[][] box) {
        int n = box.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        Arrays.sort(box,(o1, o2) -> o1[0]-o2[0] != 0 ? o1[0]-o2[0] : o1[1] - o2[1] != 0 ?  o1[1]-o2[1] : o1[2]-o2[2]);
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            dp[i+1] = box[i][2];
            for(int j = 0 ; j < i ; j++){
                if(box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]){
                    dp[i+1] = Math.max(dp[i+1],dp[j+1] + box[i][2]);
                }
            }
            max = Math.max(max,dp[i+1]);
        }
        return max;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
