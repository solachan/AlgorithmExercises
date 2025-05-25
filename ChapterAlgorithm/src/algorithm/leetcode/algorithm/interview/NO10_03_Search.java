package algorithm.leetcode.algorithm.interview;

//搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若
//有多个相同元素，返回索引值最小的一个。
//
// 示例1:
//
//  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
// 输出: 8（元素5在该数组中的索引）
//
//
// 示例2:
//
//  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
// 输出：-1 （没有找到）
//
//
// 提示:
//
//
// arr 长度范围在[1, 1000000]之间
//
// Related Topics 数组 二分查找 👍 81 👎 0
public class NO10_03_Search {
    public static void main(String[] args) {
        int[] arr = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 5;
        System.out.println(search(arr,target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

//    /**
//     * 共四种情况（请综合我下面给的例子来看后三种情况）：
//     * 1.左 == target： 直接返回 左
//     * 2.左 == 中： 此时target可能在[左，mid]中，也可能在[mid + 1, r]中，左 = 左 + 1
//     * 3.左 < 中： 此时需要分情况讨论：
//     *
//     * （1）target比左小或者target比中大时（比小的都小或者比大的都大）：此时target只可能在[mid, r]中，所以l = mid;
//     * （2）其他，即target比左大并且target比中小时（大小在左和中之间）：此时target只可能在[左 + 1, mid]中，所以 l = l + 1; r = mid;
//     * 4.左 > 中： 此时需要分情况讨论：
//     *
//     * （1）target比左小并且target比中大时（大小在左和中之间）：此时target只可能在[mid, r]中，所以l = mid;
//     * （2）其他，即target比左大或者比中小时（比大的都大或者比小的都小）：此时target只可能在[左 + 1, mid]中，所以 l = l + 1; r = mid;
//     * 后三种情况即2.3.4情况例子：
//     * 2. [3，1，3，3，3] 或 [3，3，3，3，1]，3 == 3(nums[0] == nums[2]，左 == 中)，目标target 1 在[左，mid]中 或 在[mid + 1, r]中
//     * 3. [1，2，3，4，5] 或 [1，2，3，4，0]，1 < 3(nums[0] < nums[2]，左 < 中)
//     *
//     * （1）[1，2，3，4，0]中目标target 0 或者 [1，2，3，4，5]中目标target 5 都在[mid, r]中
//     * （2）[1，2，3，4，0]中目标target 2 只在[左 + 1, mid]中
//     * 4. [5，6，2，3，4] 或 [5，1，2，3，4]，5 > 2(nums[0] > nums[2]，左 > 中)
//     *
//     * （1）[5，6，2，3，4]中目标target 3 只在[mid, r]中
//     * （2）[5，6，2，3，4]中目标target 6 或者 [5，1，2，3，4]中目标target 1 都只在[左 + 1, mid]中
//     */
    public static int search(int[] arr, int target) {
        int left = 0,right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[left] == target){
                return left;
            }else if(arr[left] == arr[mid]){
                left++;
            }else if(arr[left] < arr[mid]){
                if(arr[left] > target || arr[mid] < target){
                    left = mid;
                }else {
                    left = left+1;
                    right = mid;
                }
            }else {
                if(arr[left] > target && arr[mid] < target){
                    left = mid;
                }else {
                    left = left+1;
                    right = mid;
                }
            }
        }
        return -1;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
