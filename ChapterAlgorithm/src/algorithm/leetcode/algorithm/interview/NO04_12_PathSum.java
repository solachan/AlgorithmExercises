package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的
//根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// 3
//解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
//
// 提示：
//
//
// 节点总数 <= 10000
//
// Related Topics 树 深度优先搜索 二叉树 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class NO04_12_PathSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(1,2,null,3,null,4,null,5);
        int sum = 6;
        System.out.println(pathSum(root,sum));
    }
    static int count = 0;
    public static int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        helper(root,sum);
        //遍历每一个节点，以每一个节点为起始点
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }
    //以root为起始点，查看是否有满足和为sum的路径
    public static void helper(TreeNode root, int sum){
        if(root == null)return;
        sum-=root.val;
        if(sum == 0){
            count++;
        }
        helper(root.left,sum);
        helper(root.right,sum);
    }

    Map<Integer, Integer> map;
    int ans;
    public int pathSum2(TreeNode root, int sum) {
        map = new HashMap<>();
        //其实路径长度为0，表示遍历第一个节点之前没有分支
        map.put(0, 1);
        ans = 0;
        dfs(root, 0, sum);
        return ans;
    }

    public void dfs(TreeNode node, int preSum, int target) {
        if (node == null) return ;
        preSum += node.val;
        //如果存在某个节点到当前节点的路径达到目标时，则将起始点到该节点的路径数量加上
        ans += map.getOrDefault(preSum - target, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1); // 记录到当前节点为止路径前缀和
        dfs(node.left, preSum, target);
        dfs(node.right, preSum, target);
        map.put(preSum, map.get(preSum) - 1); // 重点：当前节点及子树已经遍历完，不会再对结果有贡献，所以要及时删除
    }

    //leetcode submit region end(Prohibit modification and deletion)
}
