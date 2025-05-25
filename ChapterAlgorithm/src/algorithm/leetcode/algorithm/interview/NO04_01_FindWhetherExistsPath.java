package algorithm.leetcode.algorithm.interview;

//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
//
// 示例1:
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
//
//
// 示例2:
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
//
//
// 提示：
//
//
// 节点数量n在[0, 1e5]范围内。
// 节点编号大于等于 0 小于 n。
// 图中可能存在自环和平行边。
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 49 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class NO04_01_FindWhetherExistsPath {
    public static void main(String[] args) {
        int n = 3;
        int[][] graph = new int[][]{{0,1},{0,2},{1,2},{1,2}};
        int start = 0,target = 2;
        System.out.println(findWhetherExistsPath(n,graph,start,target));
    }
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(start == target)return true;
        if(graph.length == 0)return false;
        Map<Integer, List<Integer>> pathMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] path : graph){
            if(!pathMap.containsKey(path[0])){
                pathMap.put(path[0],new ArrayList<>());
            }
            pathMap.get(path[0]).add(path[1]);
        }
        visited.add(start);
        return helper(visited,pathMap,graph,start,target);
    }

    public static boolean helper(Set<Integer> visited,Map<Integer,List<Integer>> pathMap,int[][] graph,int start,int target){
        if(start == target)return true;
        if(pathMap.containsKey(start)){
            // 存储当前层走过的节点
            Set<Integer> nextSet = new HashSet<Integer>();
            for(Integer newStart : pathMap.get(start)){
                if(nextSet.contains(newStart) || visited.contains(newStart))continue;
                nextSet.add(newStart);
                visited.add(newStart);
                if(helper(visited,pathMap,graph,newStart,target)){
                    return true;
                }
                visited.remove(newStart);
            }
        }
        return false;
    }
}
