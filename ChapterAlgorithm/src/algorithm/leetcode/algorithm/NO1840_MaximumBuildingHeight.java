package algorithm.leetcode.algorithm;
//Hard
//1840. Maximum Building Height
//在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。
//
// 这座城市对这些新建筑有一些规定：
//
//
// 每栋建筑的高度必须是一个非负整数。
// 第一栋建筑的高度 必须 是 0 。
// 任意两栋相邻建筑的高度差 不能超过 1 。
//
//
// 除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [
//idi, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。
//
// 题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。
//
// 请你返回 最高 建筑能达到的 最高高度 。
//
//
//
// 示例 1：
//
//
//输入：n = 5, restrictions = [[2,1],[4,1]]
//输出：2
//解释：上图中的绿色区域为每栋建筑被允许的最高高度。
//我们可以使建筑高度分别为 [0,1,2,1,2] ，最高建筑的高度为 2 。
//
// 示例 2：
//
//
//输入：n = 6, restrictions = []
//输出：5
//解释：上图中的绿色区域为每栋建筑被允许的最高高度。
//我们可以使建筑高度分别为 [0,1,2,3,4,5] ，最高建筑的高度为 5 。
//
//
// 示例 3：
//
//
//输入：n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]]
//输出：5
//解释：上图中的绿色区域为每栋建筑被允许的最高高度。
//我们可以使建筑高度分别为 [0,1,2,3,3,4,4,5,4,3] ，最高建筑的高度为 5 。
//
//
//
//
// 提示：
//
//
// 2 <= n <= 10⁹
// 0 <= restrictions.length <= min(n - 1, 10⁵)
// 2 <= idi <= n
// idi 是 唯一的 。
// 0 <= maxHeighti <= 10⁹
//
// Related Topics 数组 数学 👍 31 👎 0

import com.sun.prism.PresentableState;

import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class NO1840_MaximumBuildingHeight {
    public static void main(String[] args) {
        int n = 10;
        int[][] restrictions = new int[][]{
            new int[]{8,5},
            new int[]{9,0},
            new int[]{6,2},
            new int[]{4,0},
            new int[]{3,2},
            new int[]{10,0},
            new int[]{5,3},
            new int[]{7,3},
            new int[]{2,4}
        };
        System.out.println(maxBuilding(n,restrictions));
    }

    public static int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, Comparator.comparingInt(o -> o[0]));
        int length = restrictions.length + 2;
        int[][] res = new int[length][2];
        res[0][0] = 1;
        res[0][1] = 0;
        res[length-1][0] = n;
        res[length-1][1] = n - 1;
        for(int i = 0 ; i < restrictions.length ; i++){
            res[i+1] = restrictions[i];
        }
        //最终结果
        //从左往右计算限制节点最高高度
        for(int i = 1 ; i <= length-1 ; i++){
            res[i][1] = Math.min(res[i-1][1] + res[i][0] - res[i-1][0],res[i][1]);
        }
        //从右往左计算限制节点最高高度
        for(int i = length - 2 ; i >= 1 ; i--){
            res[i][1] = Math.min(res[i+1][1] + res[i+1][0] - res[i][0],res[i][1]);
        }
        int max = 0;

        //计算两个楼之间最高高度 计算以相邻两个节点之间的斜率为1和-1的线相交节点大小，取整，则该高度为两楼之间的最高高度
        for(int i = 0; i< length - 1; ++i){
            int j = res[i][0], h1 = res[i][1], k = res[i+1][0], h2 = res[i+1][1];

            // calculating difference between heights of both buildings.
            int diff = Math.max(h1, h2) - Math.min(h1, h2);
            j += diff;

            // calculating maximum height possible between both buildings.
            max = Math.max(max, Math.max(h1, h2) + (k - j)/2);
        }
        return max;
    }

    public static int maxBuilding2(int n, int[][] restrictions) {
        Arrays.sort(restrictions,(o1, o2) -> o1[0] - o2[0]);
        //从左往右最高高度
        int[] left = new int[n];
        Arrays.fill(left,-1);
        left[0] = 0;
        //从右往左最高高度
        int[] right = new int[n];
        Arrays.fill(right,-1);
        right[0] = 0;
        //最终结果
        int[] result = new int[n];
        if(restrictions != null && restrictions.length != 0){
            for(int[] res : restrictions){
                left[res[0]-1] = res[1];
                right[res[0]-1] = res[1];
            }
        }
        for(int i = 1 ; i <= n-1 ; i++){
            if(left[i] < 0){
                left[i] = left[i-1] + 1;
            }else {
                left[i] = Math.min(left[i-1] + 1,left[i]);
            }
        }
        right[n-1] = left[n-1];
        for(int i = n-2 ; i >= 1 ; i--){
            if(right[i] < 0) {
                right[i] = right[i + 1] + 1;
            }else {
                right[i] = Math.min(right[i + 1] + 1,right[i]);
            }
        }
        int max = 0;
        for(int i = 1 ; i <= n-1 ; i++){
            max = Math.max(max,Math.min(left[i],right[i]));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
