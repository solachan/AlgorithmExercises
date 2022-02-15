package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.ListNode;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你不需要 保留 每个分区中各节点的初始相对位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [2,1], x = 2
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 200] 内
// -100 <= Node.val <= 100
// -200 <= x <= 200
//
// Related Topics 链表 双指针 👍 85 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class NO02_04_Partition {
    //双指针
    public ListNode partition(ListNode head, int x) {
        ListNode left = head, right = head;
        while (left != null && left.val < x) {
            left = left.next;
        }
        right = left;
        int tmp;
        while (right != null && left != null) {
            right = left.next;
            while (right != null && right.val >= x) {
                right = right.next;
            }
            if (right != null && left != null) {
                tmp = right.val;
                right.val = left.val;
                left.val = tmp;
                while (left != null && left.val < x) {
                    left = left.next;
                }
            }
        }
        return head;
    }

    //头插法思路：遍历链表，每遇到一个小于x的节点，就将其插到头节点之前，并将其设置为头节点。
    //由于题目说明不需要保留每个分组中节点的初始相对位置，所以可以使用头插法。
    public ListNode partition2(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode prev = head, curr = head.next;
        while (curr != null) {
            if (curr.val < x) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
