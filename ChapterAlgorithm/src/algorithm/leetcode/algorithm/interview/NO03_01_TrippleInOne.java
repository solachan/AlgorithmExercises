package algorithm.leetcode.algorithm.interview;

import java.util.*;

//三合一。描述如何只用一个数组来实现三个栈。
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
//stackNum表示栈下标，value表示压入的值。
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。
//
// 示例1:
//
//
// 输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
//
//
// 示例2:
//
//
// 输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
//
//
//
//
// 提示：
//
//
// 0 <= stackNum <= 2
//
// Related Topics 栈 设计 数组 👍 45 👎 0
public class NO03_01_TrippleInOne {
    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0,1);;
        tripleInOne.push(0,2);;
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.isEmpty(0));
    }
    public static class TripleInOne {
        int[] top = new int[3];
        int stackSize = 0;
        int[] stack = null;
        public TripleInOne(int stackSize) {
            stack = new int[stackSize * 3];
            Arrays.fill(top,-1);
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            if(top[stackNum] == stackSize - 1){
                return;
            }
            stack[stackNum * stackSize + ++top[stackNum]] = value;
        }

        public int pop(int stackNum) {
            return top[stackNum] < 0 ? -1 : stack[stackNum * stackSize + top[stackNum]--];
        }

        public int peek(int stackNum) {
            return top[stackNum] < 0 ? -1 : stack[stackNum * stackSize + top[stackNum]];
        }

        public boolean isEmpty(int stackNum) {
            return top[stackNum] < 0;
        }
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
