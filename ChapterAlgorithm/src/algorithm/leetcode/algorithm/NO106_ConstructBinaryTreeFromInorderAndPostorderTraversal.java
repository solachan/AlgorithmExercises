package algorithm.leetcode.algorithm;

/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
Example 1:
    3
   / \
  9  20
    /  \
   15   7
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]


Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */
public class NO106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = buildTree(inorder,postorder);
        System.out.println(root);
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /**
     * 方法1：递归
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0, inEnd = inorder.length-1;
        int postStart = 0, postEnd = inorder.length-1;

        return helper(inorder,inStart,inEnd,postorder,postStart,postEnd);
    }

    public static TreeNode helper(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = inStart;
        for(int i = inStart ; i <= inEnd ; i++){
            if(inorder[i] == postorder[postEnd]){
                inIndex = i;
                break;
            }
        }
        root.left = helper(inorder,inStart,inIndex-1,postorder,postStart,postStart+(inIndex-1-inStart));
        root.right = helper(inorder,inIndex+1,inEnd,postorder,postEnd-1-(inEnd-(inIndex+1)),postEnd-1);
        return root;
    }
}
