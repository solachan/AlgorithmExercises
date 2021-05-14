package algorithm.leetcode.algorithm;
/**
 * Hard
 * 1373. Maximum Sum BST in Binary Tree
 * Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * Output: 20
 * Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
 *
 * Example 2:
 * Input: root = [4,3,null,1,2]
 * Output: 2
 * Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
 *
 * Example 3:
 * Input: root = [-4,-2,-5]
 * Output: 0
 * Explanation: All values are negatives. Return an empty BST.
 *
 * Example 4:
 * Input: root = [2,1,3]
 * Output: 6
 *
 * Example 5:
 * Input: root = [5,4,8,3,null,6,3]
 * Output: 7
 *
 * Constraints:
 * The given binary tree will have between 1 and 40000 nodes.
 * Each node's value is between [-4 * 10^4 , 4 * 10^4].
 */
public class NO1373_MaximumSumBSTInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new Integer[]{1,4,3,2,4,2,5,null,null,null,null,null,null,4,6});
        int result = maxSumBST(root);
        System.out.println(result);
    }

    public static int max = 0;
    public static int maxSumBST(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    public static int[] helper(TreeNode root){
        //[isBST,min,max,sum]
        int[] result = new int[4];
        result[0] = 1;
        result[1] = Integer.MAX_VALUE;
        result[2] = Integer.MIN_VALUE;
        result[3] = 0;
        if(root == null){
            return result;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if(left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            result[1] = Math.min(root.val,left[1]);
            result[2] = Math.max(root.val,right[2]);
            result[3] = left[3] + right[3] + root.val;
            max = Math.max(max,result[3]);
        }else {
            result[0] = -1;
        }
        return result;
    }
}
