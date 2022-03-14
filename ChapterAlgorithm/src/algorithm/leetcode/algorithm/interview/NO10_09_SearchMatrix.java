package algorithm.leetcode.algorithm.interview;

//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
// Related Topics 数组 二分查找 分治 矩阵 👍 36 👎 0
public class NO10_09_SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30},};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //矩阵搜索有点像二叉树
    //从右上角开始查找，比target小就往下，比target大就往左
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int M = matrix.length, N = matrix[0].length;
        int i = 0, j = N - 1;
        while (i < M && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
