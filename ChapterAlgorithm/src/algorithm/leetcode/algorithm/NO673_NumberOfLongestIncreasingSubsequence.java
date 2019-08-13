package algorithm.leetcode.algorithm;

/**
 * 673. Number of Longest Increasing Subsequence
 * Medium
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class NO673_NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
    public static int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int[] count = new int[nums.length];
        int[] length = new int[nums.length];
        count[0] = 1;
        length[0]= 1;
        int maxCount = 0;
        int maxLength = 1;
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]){
                    if(length[i] < length[j] + 1){
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }else if(length[i] == length[j] + 1){
                        count[i] += count[j];
                    }
                }
            }
            if(count[i] == 0)count[i] = 1;
            if(length[i] == 0)length[i] = 1;
            maxLength = maxLength > length[i] ? maxLength : length[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(length[i] == maxLength)maxCount+=count[i];
        }
        return maxCount;
    }
}
