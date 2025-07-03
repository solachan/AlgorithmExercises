package algorithm.leetcode.algorithm;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * Related Topics
 * 数组
 * 双指针
 * 排序
 */
public class NO977_SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int right = 0;
        while(right < n && nums[right] < 0){
            right++;
        }
        int[] res = new int[n];
        int index = 0;
        int left = right - 1;
        while(left >= 0 || right < n){
            if(left < 0){
                res[index++] = nums[right] * nums[right];
                right++;
            }else if(right == n){
                res[index++] = nums[left] * nums[left];
                left++;
            }else if(nums[right] * nums[right] < nums[left] * nums[left]){
                res[index++] = nums[right] * nums[right];
                right++;
            }else if(nums[right] * nums[right] >= nums[left] * nums[left]){
                res[index++] = nums[left] * nums[left];
                left--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
