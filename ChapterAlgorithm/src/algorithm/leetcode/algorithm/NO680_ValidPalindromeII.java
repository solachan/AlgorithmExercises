package algorithm.leetcode.algorithm;

/**
 * 680. Valid Palindrome II
 * Easy
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class NO680_ValidPalindromeII {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s + " : " + validPalindrome(s));
    }
    public static boolean validPalindrome(String s) {
        if(s == null || s.length() <= 2)return true;
        int start = 0,end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return isPalindrome(s,start,end-1) || isPalindrome(s,start+1,end);
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}
