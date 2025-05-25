package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.ListNode;

//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
//
//
//
// 进阶：
//
//
// 你是否可以不用额外空间解决此题？
//
//
//
// Related Topics 哈希表 链表 双指针 👍 93 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class NO02_08_DetectCycle {
    /*
    解题思路：
        1）用快慢指针判断是否存在环

        2）找到存在环
            设快指针走了n圈，慢指针走了m圈
            因为快的速度是慢的两倍，所以路程是慢的两倍
            x，y, z
            x + n(y+z) + y = 2(x+m(y+z)+y)
            (n-2m)(y+z) = x+y
            环-y = x
            (n-2m)z = x
*/
    public ListNode detectCycle(ListNode head) {
        //对空链表，及不可能成环情况进行处理
        if (head==null || head.next == null){
            return null;
        }
        ListNode slow=head, fast=head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            //存在环形链表
            if (slow == fast){
                //
                fast = head;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;

            }
        }
        return null;

    }


    public ListNode detectCycle2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head,slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast.next == null || fast.next.next == null){
            return null;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
