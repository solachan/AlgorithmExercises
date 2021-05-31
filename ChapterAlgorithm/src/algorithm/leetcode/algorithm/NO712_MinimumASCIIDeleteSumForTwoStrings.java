package algorithm.leetcode.algorithm;

/**
 * Medium
 * 712. Minimum ASCII Delete Sum for Two Strings
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 * Example 1:
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 *
 * Example 2:
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 *
 * Note:
 * 0 < s1.length, s2.length <= 1000.
 * All elements of each string will have an ASCII value in [97, 122].
 */
public class NO712_MinimumASCIIDeleteSumForTwoStrings {
	public static void main(String[] args) {
		String s1 = "delete";
		String s2 = "leet";
		System.out.println(minimumDeleteSum(s1,s2));
		System.out.println(minimumDeleteSum2(s1,s2));
	}
	//方法1：动态规划，时间复杂度O(n^2)，空间复杂度（n^2）,dp记录公共子串的ASCII值之和
    public static int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
		int len2 = s2.length();
		// 公共子串的ASCII值之和
		int[][] dp = new int[len1+1][len2+1];
		for(int i = 1 ; i <= len1 ; i++){
			for(int j = 1 ; j <= len2 ; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = s1.charAt(i-1) + dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		int sum = 0;
		for(int i = 0 ; i < s1.length() ; i++){
			sum+=s1.charAt(i);
		}
		for(int j = 0 ; j < s2.length() ; j++){
			sum+=s2.charAt(j);
		}
		return sum-2*dp[s1.length()][s2.length()];
    }
	//方法2：动态规划，时间复杂度O(n^2)，空间复杂度（n^2）,dp记录需要删除字符的ASCII值之和
	public static int minimumDeleteSum2(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		// 需要删除的字符串的ASCII值
		int[][] dp = new int[len1+1][len2+1];
		for(int i = 0 ; i <= len1 ; i++){
			for(int j = 0 ; j <= len2 ; j++){
				if(i == 0 && j > 0){
					dp[i][j] = dp[i][j-1] + s2.charAt(j-1);
				}
				if(j == 0 && i > 0){
					dp[i][j] = dp[i-1][j] + s1.charAt(i-1);
				}
				if(i > 0 && j > 0) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
					}
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
