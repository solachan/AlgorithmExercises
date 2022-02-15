package algorithm.leetcode.algorithm.interview;
import algorithm.leetcode.algorithm.ListNode;

import java.util.Arrays;

//给定两个用链表表示的整数，每个节点包含一个数位。
//
// 这些数位是反向存放的，也就是个位排在链表首部。
//
// 编写函数对这两个整数求和，并用链表形式返回结果。
//
//
//
// 示例：
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
//
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
//
// 示例：
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
//
// Related Topics 递归 链表 数学 👍 109 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class NO02_05_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getList(5);
        ListNode l2 = ListNode.getList(5);
        System.out.println(addTwoNumbers(l1,l2));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1,node2 = l2;
        int add = 0;
        while(node1 != null && node2 != null){
            node1.val += node2.val + add;
            add = node1.val / 10;
            node1.val %= 10;
            if(node1.next == null){
                if(node2.next == null){
                    if(add > 0){
                        node1.next = new ListNode(0);
                    }
                }else {
                    ListNode tmp = node1.next;
                    node1.next = node2.next;
                    node2.next = tmp;
                }
            }
            node1 = node1.next;
            node2 = node2.next;

        }
        while(add > 0){
            node1.val += add;
            add = node1.val / 10;
            node1.val %= 10;
            if(node1.next == null && add > 0){
                node1.next = new ListNode(0);
            }
            node1 = node1.next;
        }
        return l1;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int x = 0;  // 进位
        ListNode dummy = new ListNode(0);   // 哑节点
        ListNode node = dummy;

        while(l1 != null || l2 != null || x != 0) {
            int sum = x;    // 当前位的和
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(sum % 10);
            x = sum / 10;
            node = node.next;
        }
        return dummy.next;
    }

}
