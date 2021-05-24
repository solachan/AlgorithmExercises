package algorithm.leetcode.algorithm;

import java.util.Stack;

/**
 * Medium
 * 1081. Smallest Subsequence of Distinct Characters
 * Return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 * Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Example 1:
 * Input: s = "bcabc"
 * Output: "abc"
 *
 * Example 2:
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class NO1081_SmallestSubsequenceOfDistinctCharacters {
    public static String smallestSubsequence(String s) {
        if(s == null || s.length() == 0)return null;
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            count[c-'a']++;
            visited[c-'a'] = false;
        }
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            count[c-'a']--;
            if(visited[c-'a'])continue;
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0){
                visited[stack.pop()-'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "bcabc";
        String s = "cbacdcbc";
        String result = smallestSubsequence(s);
        System.out.println(result);
    }
}
