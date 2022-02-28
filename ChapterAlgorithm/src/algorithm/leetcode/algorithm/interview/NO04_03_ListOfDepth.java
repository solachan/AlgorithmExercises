package algorithm.leetcode.algorithm.interview;
import algorithm.leetcode.algorithm.ListNode;
import algorithm.leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
//
//
// 示例：
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
//
// Related Topics 树 广度优先搜索 链表 二叉树 👍 66 👎 0


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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class NO04_03_ListOfDepth {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new Integer[]{1,2,3,4,5,null,7,8});
        System.out.println(listOfDepth(treeNode));
    }
    public static ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<ListNode> ll = new ArrayList<>();
        queue.offer(tree);
        TreeNode node;
        while(!queue.isEmpty()){
            int length = queue.size();
            node = queue.poll();
            ListNode head = new ListNode(node.val);
            ll.add(head);
            for(int i = 0 ; i < length ; i++){
                if(i != 0){
                    node = queue.poll();
                    head.next = new ListNode(node.val);
                    head = head.next;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        ListNode[] result = new ListNode[ll.size()];
        for(int i = 0 ; i < ll.size() ; i++){
            result[i] = ll.get(i);
        }
        return result;
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
