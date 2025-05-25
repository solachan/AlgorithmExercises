package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.TreeNode;

//实现一个函数，检查一棵二叉树是否为二叉搜索树。
// 示例 1: 输入:
//          2
//         / \
//        1   3
// 输出: true
// 示例 2: 输入:
//          5
//         / \
//        1   4
//       / \
//      3   6
// 输出: false
// 解释:
// 输入为: [5,1,4,null,null,3,6]。
// 根节点的值为 5 ，但是其右子节点值为 4 。
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 68 👎 0


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
public class NO04_05_IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long min,long max) {
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValidBST(root.left,min, root.val) && isValidBST(root.right,root.val,max);
    }


    //leetcode submit region end(Prohibit modification and deletion)
}
