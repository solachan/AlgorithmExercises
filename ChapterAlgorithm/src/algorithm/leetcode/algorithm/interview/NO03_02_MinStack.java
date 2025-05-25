package algorithm.leetcode.algorithm.interview;

import java.util.Stack;

//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
// 执行push、pop和min操作的时间复杂度必须为O(1)。
// 示例：
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop(); minStack.
// top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.
//
// Related Topics 栈 设计 👍 66 👎
//0
public class NO03_02_MinStack {
    //leetcode submit region begin(Prohibit modification and deletion)
    public static class MinStack {
        Stack<Integer> stack,minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if(stack.isEmpty()){
                stack.push(x);
                minStack.push(x);
            }else {
                if(x < minStack.peek()){
                    minStack.push(x);
                }else {
                    minStack.push(minStack.peek());
                }
                stack.push(x);
            }

        }

        public void pop() {
            if(!stack.isEmpty()){
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}
