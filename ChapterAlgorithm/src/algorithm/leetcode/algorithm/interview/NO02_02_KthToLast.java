package algorithm.leetcode.algorithm.interview;

//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动
//
// 示例：
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4
//
// 说明：
//
// 给定的 k 保证是有效的。
// Related Topics 链表 双指针 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import algorithm.leetcode.algorithm.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class NO02_02_KthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head,slow = head;
        for(int i = 1 ; i < k ; i++){
            if(fast.next != null){
                fast = fast.next;
            }
        }
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
