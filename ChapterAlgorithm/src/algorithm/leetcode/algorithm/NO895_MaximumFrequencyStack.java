package algorithm.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Hard
 * 895. Maximum Frequency Stack
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 * Implement the FreqStack class:
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 *
 * Example 1:
 * Input
 * ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
 * [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
 * Output
 * [null, null, null, null, null, null, null, 5, 7, 5, 4]
 *
 * Explanation
 * FreqStack freqStack = new FreqStack();
 * freqStack.push(5); // The stack is [5]
 * freqStack.push(7); // The stack is [5,7]
 * freqStack.push(5); // The stack is [5,7,5]
 * freqStack.push(7); // The stack is [5,7,5,7]
 * freqStack.push(4); // The stack is [5,7,5,7,4]
 * freqStack.push(5); // The stack is [5,7,5,7,4,5]
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 * freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
 * freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 *
 * Constraints:
 * 0 <= val <= 109
 * At most 2 * 104 calls will be made to push and pop.
 * It is guaranteed that there will be at least one element in the stack before calling pop.
 */
public class NO895_MaximumFrequencyStack {
    //记录每个val对应的频率
    Map<Integer,Integer> valToFreq;
    //记录最大频率
    private int maxFreq;
    // freq 到 val 列表的映射，我们后文称为 FV 表
    HashMap<Integer, Stack<Integer>> freqToVals;
    class FreqStack {

        public FreqStack() {
            freqToVals = new HashMap<>();
            valToFreq = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            // 修改 VF 表：val 对应的 freq 加一
            int freq = valToFreq.getOrDefault(val, 0) + 1;
            valToFreq.put(val, freq);
            // 修改 FV 表：在 freq 对应的列表加上 val
            freqToVals.putIfAbsent(freq, new Stack<>());
            freqToVals.get(freq).push(val);
            // 更新 maxFreq
            maxFreq = Math.max(maxFreq, freq);
        }

        public int pop() {
            // 修改 FV 表：pop 出一个 maxFreq 对应的元素 v
            Stack<Integer> vals = freqToVals.get(maxFreq);
            int val = vals.pop();
            // 修改 VF 表：v 对应的 freq 减一
            valToFreq.put(val,valToFreq.get(val)-1);
            // 更新 maxFreq
            if(vals.isEmpty()){
                // 如果 maxFreq 对应的元素空了
                maxFreq--;
            }
            return val;
        }
    }
}
