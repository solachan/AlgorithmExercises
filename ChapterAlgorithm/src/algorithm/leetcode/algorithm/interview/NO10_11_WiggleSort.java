package algorithm.leetcode.algorithm.interview;

import java.util.*;
import java.util.stream.Collectors;

//在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8
//, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
//
// 示例:
//
// 输入: [5, 3, 1, 2, 3]
//输出:[5, 1, 3, 2, 3]
//
//
// 提示：
//
//
// nums.length <= 10000
//
// Related Topics 贪心 数组 排序 👍 40 👎 0
public class NO10_11_WiggleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 1, 2, 3};
        NO10_11_WiggleSort ins = new NO10_11_WiggleSort();
        ins.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }



    //leetcode submit region begin(Prohibit modification and deletion)
    public void wiggleSort(int[] nums) {
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(i%2 == 0 && nums[i] < nums[i+1] || i%2 == 1 && nums[i] > nums[i+1]){
                swap(nums,i,i+1);
            }
        }
    }
    private void swap(int[]nums,int a,int b){
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
