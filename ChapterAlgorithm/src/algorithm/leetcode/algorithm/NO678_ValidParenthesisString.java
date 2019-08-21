package algorithm.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 678. Valid Parenthesis String
 * Medium
 * Related: Special Binary String
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid.
 * We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class NO678_ValidParenthesisString {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("((*)"));
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        System.out.println(checkValidString("(()(()))(()()()))))((((()*()*(())())(()))((*()(*((*(*()))()(())*()()))*)*()))()()(())()(()))())))"));
    }
    //方法1：
    //利用左右括号统计个数是否平衡的方法
    public static boolean checkValidString(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(stack.empty() || s.charAt(i) == '(' || s.charAt(i) == '*'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                return false;
            }
        }
        int max = 0;
        int min = 0;
        Stack<Character> stack2 = new Stack<>();
        while(!stack.empty()){
            if(stack.peek() == '*'){
                max++;
                min--;
            }else if(stack.peek() == '('){
                max--;
                min--;
            }else if(stack.peek() == ')'){
                max++;
                min++;
            }
            if(max < 0)return false;
            stack2.push(stack.pop());
        }
        if(min > 0)return false;
        max = 0;
        min = 0;
        while(!stack2.empty()){
            if(stack2.peek() == '*'){
                max++;
                min--;
            }else if(stack2.peek() == ')'){
                max--;
                min--;
            }else if(stack2.peek() == '('){
                max++;
                min++;
            }
            if(max < 0)return false;
            stack2.pop();
        }
        if(min > 0)return false;
//        for(int i = 0 ; i < s.length() ; i++){
//            if(s.charAt(i) == '*'){
//                max++;
//                min--;
//            }else if(s.charAt(i) == ')'){
//                max--;
//                min--;
//            }else if(s.charAt(i) == '('){
//                max++;
//                min++;
//            }
//            if(max < 0)return false;
//        }
//        if(min > 0)return false;
        return true;
    }
    //方法2：贪婪算法
    public boolean checkValidString2(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
    //方法3：转换为背包问题
    public boolean checkValidString3(String s) {
        int n = s.length();
        if (n == 0) return true;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') dp[i][i] = true;
            if (i < n-1 &&
                    (s.charAt(i) == '(' || s.charAt(i) == '*') &&
                    (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
                dp[i][i+1] = true;
            }
        }

        for (int size = 2; size < n; size++) {
            for (int i = 0; i + size < n; i++) {
                if (s.charAt(i) == '*' && dp[i+1][i+size] == true) {
                    dp[i][i+size] = true;
                } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                    for (int k = i+1; k <= i+size; k++) {
                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
                                (k == i+1 || dp[i+1][k-1]) &&
                                (k == i+size || dp[k+1][i+size])) {
                            dp[i][i+size] = true;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
