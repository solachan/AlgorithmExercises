package algorithm.leetcode.algorithm.interview;

//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：
//push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
//
// 示例1:
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
//
//
// 示例2:
//
//  输入：
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
//
//
// 说明:
//
//
// 栈中的元素数目在[0, 5000]范围内。
//
// Related Topics 栈 设计 单调栈 👍 56 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class NO03_05_SortedStack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class SortedStack {
        //保持bigStack栈顶为该栈最小值排序，smallStack栈顶为该栈最大值排序
        Deque<Integer> bigStack, smallStack;

        public SortedStack() {
            bigStack = new LinkedList<>();
            smallStack = new LinkedList<>();
        }

        public void push(int val) {
            int minBig = bigStack.isEmpty() ? Integer.MAX_VALUE : bigStack.peek();
            int maxSmall = smallStack.isEmpty() ? Integer.MIN_VALUE : smallStack.peek();
            while(true){
                if(val > minBig){
                    smallStack.push(bigStack.pop());
                    minBig = bigStack.isEmpty() ? Integer.MAX_VALUE : bigStack.peek();
                }else if(val < maxSmall){
                    bigStack.push(smallStack.pop());
                    maxSmall = smallStack.isEmpty() ? Integer.MIN_VALUE : smallStack.peek();
                }else {
                    bigStack.push(val);
                    break;
                }
            }
        }

        public void pop() {
            while(!smallStack.isEmpty()){
                bigStack.push(smallStack.pop());
            }
            if(!bigStack.isEmpty()){
                bigStack.pop();
            }
        }

        public int peek() {
            while(!smallStack.isEmpty()){
                bigStack.push(smallStack.pop());
            }
            return bigStack.isEmpty() ? -1 : bigStack.peek();
        }

        public boolean isEmpty() {
            return bigStack.isEmpty() && smallStack.isEmpty();
        }
    }

    /**
     * Your SortedStack object will be instantiated and called as such:
     * SortedStack obj = new SortedStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.isEmpty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
