package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.TreeNode;

//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
//
// 如果指定节点没有对应的“下一个”节点，则返回null。
//
// 示例 1:
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /
//1
//
//输出: null
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 89 👎 0


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
public class NO04_06_InorderSuccessor {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new Integer[]{5,3,6,2,4,null,null,1});
        TreeNode p = new TreeNode(1);
        System.out.println(inorderSuccessor(root,p));
    }
    //1、递归，中序遍历
    static TreeNode res = null,pre = null;
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        res = null;
        pre = null;
        helper(root,p);
        return res;
    }

    public static void helper(TreeNode root, TreeNode p) {
        if(root == null){
            return;
        }
        helper(root.left,p);
        if(pre != null && p != null && pre.val == p.val){
            res = root;
            pre = root;
            return;
        }else {
            pre = root;
        }
        helper(root.right,p);
    }

    //2、直接根据二叉搜索树和中序遍历的特点
    //(1)p有右子树，则后继节点是右子树的最左节点
    //(2)p没有右子树，则后继节点是查找过程中向左寻找时的上一个节点
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while(root.val!=p.val){
            //右边
            if(p.val > root.val){
                root = root.right;
            }
            //左边
            else{
                pre = root;
                root = root.left;
            }
        }
        //假如没有右子树
        if(root.right==null){
            return pre;
        }
        else{
            root = root.right;
            while(root.left!=null){
                root = root.left;
            }
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}
