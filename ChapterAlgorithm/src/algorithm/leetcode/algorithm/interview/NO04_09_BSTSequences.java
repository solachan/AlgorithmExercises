package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.TreeNode;

import java.util.*;

//从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
//
//
//
// 示例：
//给定如下二叉树
//
//         2
//       / \
//      1   3
//
//
// 返回：
//
// [
//   [2,1,3],
//   [2,3,1]
//]
//
// Related Topics 树 二叉搜索树 动态规划 二叉树 👍 82 👎 0


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
public class NO04_09_BSTSequences {
    //定义好结果集
    List<List<Integer>> res;
    public List<List<Integer>> BSTSequences(TreeNode root) {
        res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        if(root == null){
            res.add(path);
            return res;
        }
        Set<TreeNode> set = new HashSet<>();
        set.add(root);
        bfs(set,path);
        return res;
    }

    private void bfs(Set<TreeNode> set, List<Integer> path) {
        //全排列的套路无外乎递归三板斧
        //1.设定终止条件
        if(set.isEmpty()){
            res.add(new LinkedList<>(path));
            return;
        }
        Set<TreeNode> copySet = new HashSet<>(set);
        //2.对当前层数能够访问的元素进行遍历
        for(TreeNode node : copySet){
            //3.1 最关键的一步，设定访问标记，防止重复访问
            path.add(node.val);
            set.remove(node);
            if(node.left != null)set.add(node.left);
            if(node.right != null)set.add(node.right);
            bfs(set,path);
            //3.2 擦除访问标记
            if(node.right != null)set.remove(node.right);
            if(node.left != null)set.remove(node.left);
            set.add(node);
            path.remove(path.size()-1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
