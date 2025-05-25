package algorithm.leetcode.algorithm.interview;

import algorithm.leetcode.algorithm.ListNode;

//编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
//输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
//输出： true
//
//
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针 👍 92 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class NO02_06_IsPalindrome {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(1,2,2,1);
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fakeHead = new ListNode(0);
        //假头，连接前半部分倒转的链表部分
        fakeHead.next = head;
        //快慢指针
        ListNode fast = head.next,slow = head.next;
        head.next = null;
        while(fast.next != null && fast.next.next != null){
            ListNode tmp = slow;
            fast = fast.next.next;
            slow = slow.next;
            tmp.next = fakeHead.next;
            fakeHead.next = tmp;
        }
        //判断是否为奇数个，是则顺移下一个
        if(fast.next != null){
            slow = slow.next;
        }
        //对比前后半段链表
        while(fakeHead.next != null){
            fakeHead = fakeHead.next;
            if(fakeHead.val != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
