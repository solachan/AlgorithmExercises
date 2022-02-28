package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
// 示例 1: 给定二叉树 [3,9,20,null,null,15,7]
//      3
//     / \
//    9  20
//  /  \
// 15   7
// 返回 true 。
// 示例 2: 给定二叉树 [1,2,2,3,3,null,null,4,4]
//          1
//         / \
//        2   2
//       / \
//      3   3
//     / \
//    4   4 返回
//false 。 Related Topics 树 深度优先搜索 二叉树 👍 75 👎 0


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
public class NO04_04_IsBalanced {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode node){
        if(!isBalanced){
            return 0;
        }
        if(node == null){
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return Math.max(left,right) + 1;
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
