package algorithm.leetcode.algorithm.interview;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
//
// 示例 1:
//
// 输入:
//[
// [0,0,0],
// [0,1,0],
// [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释:
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
//
// 说明：r 和 c 的值均不超过 100。
// Related Topics 数组 动态规划 回溯 矩阵 👍 85 👎 0
public class NO08_02_PathWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(pathWithObstacles(obstacleGrid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static List<List<Integer>> res = null;
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        res = new LinkedList<>();
        List<List<Integer>> path = new LinkedList<>();
        path.add(Arrays.asList(0,0));
        int[][] dirs = new int[][]{{0,1},{1,0}};
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        dfs(obstacleGrid,path,dirs,0,0, visited);
        return res;
    }

    private static void dfs(int[][] obstacleGrid, List<List<Integer>> path, int[][] dirs, int x, int y, boolean[][] visited) {
        if(x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1 || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        if(x == obstacleGrid.length-1 && y == obstacleGrid[0].length-1){
            res = new LinkedList<>(path);
            return;
        }
        for(int[] dir : dirs){
            path.add(Arrays.asList(x+dir[0],y+dir[1]));
            dfs(obstacleGrid,path,dirs,x+dir[0],y+dir[1], visited);
            path.remove(path.size()-1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
