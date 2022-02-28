package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.TreeNode;

//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
// 示例: 给定有序数组: [-10,-3,0,5,9], 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//       0
//      / \
//     -3  9
//     /   /
//   -10  5
//   Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 113 👎 0

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
public class NO04_02_SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public static TreeNode helper(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int index = (start + end)/2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums,start,index-1);
        node.right = helper(nums,index+1,end);
        return node;
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
