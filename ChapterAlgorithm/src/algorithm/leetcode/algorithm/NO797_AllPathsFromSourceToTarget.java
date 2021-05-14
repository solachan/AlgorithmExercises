package algorithm.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 * 797. All Paths From Source to Target
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 * Example 3:
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 *
 * Example 4:
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 *
 * Example 5:
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 *
 * Constraints:
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * The input graph is guaranteed to be a DAG.
 */
public class NO797_AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph,result,path,0);
        return result;
    }

    //图的遍历框架
    private void traverse(int[][] graph, List<List<Integer>> result, LinkedList<Integer> path,int n) {
        //添加节点，记录路径
        path.add(n);
        //到达目的节点
        if(n-1 == graph.length){
            result.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        //递归遍历相邻节点
        for(int next : graph[n]){
            traverse(graph,result,path,next);
        }
        //回滚，移出节点
        path.removeLast();
    }


}
