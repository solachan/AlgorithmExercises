package algorithm.leetcode.algorithm.interview;
import algorithm.leetcode.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
//
// 示例2:
//
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
//
// 提示：
//
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
// Related Topics 哈希表 链表 双指针 👍 140 👎 0
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class NO02_01_RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode newHead = head;
        set.add(newHead.val);
        while(newHead.next != null){
            if(set.contains(newHead.next.val)){
                newHead.next = newHead.next.next;
            }else {
                set.add(newHead.next.val);
                newHead = newHead.next;
            }
        }
        return head;
    }


}
