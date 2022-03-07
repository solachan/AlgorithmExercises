package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;

//下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
//
// 示例1:
//
//
// 输入：num = 2（或者0b10）
// 输出：[4, 1] 或者（[0b100, 0b1]）
//
//
// 示例2:
//
//
// 输入：num = 1
// 输出：[2, -1]
//
//
// 提示:
//
//
// num的范围在[1, 2147483647]之间；
// 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
//
// Related Topics 位运算 👍 43 👎 0
public class NO05_04_FindCloseNumbers {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(67));
        System.out.println(Integer.toBinaryString(69));
        System.out.println(Integer.toBinaryString(56));
//        System.out.println(Arrays.toString(findClosedNumbers(67)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //TODO
    public static int[] findClosedNumbers(int num) {
        int[] result = new int[2];
        int[] bit = new int[32];
        for(int i = 0 ; i < 32 ; i++){
            bit[i] = ((1 << i) & num) > 0 ? 1 : 0;
        }
        //最小1的位置
        int minOneIndex = 0;
        while(minOneIndex < 32 && bit[minOneIndex] != 1){
            minOneIndex++;
        }
        //最小0位置
        int minZeroIndex = 0;
        while(minZeroIndex < 32 && bit[minZeroIndex] != 0){
            minZeroIndex++;
        }
        //最大1位置
        int maxOneIndex = 31;
        while(maxOneIndex >= 0 && bit[maxOneIndex] != 1){
            maxOneIndex--;
        }
        //略大值
        if(minOneIndex == 32){  //没有0
            result[0] = -1;
        }else {
            if(minZeroIndex > minOneIndex){ //最小的0大于最小的1，那么可以将最小的1和最小的0交换位置
                result[0] = num & (~(1 << minOneIndex)) | (1 << minZeroIndex);
            }else { //最小的0小于最小的1，那么可以将最小的1后面最近的0与最小的1交换
                int tmpOneIndex = minOneIndex;
                while(tmpOneIndex < 32 && bit[tmpOneIndex] != 0)tmpOneIndex++;
                if(tmpOneIndex == 32){
                    result[0] = -1;
                }else {
                    result[0] = num & (~(1 << minOneIndex)) | (1 << tmpOneIndex);
                }
            }
        }
        //略小值
        if(maxOneIndex == 0){  //没有1
            result[1] = -1;
        }else {
            if(minZeroIndex < minOneIndex){ //最小的0小于最小的1，那么可以将最小的1和最小的0交换位置
                result[1] = num & (~(1 << minOneIndex)) | (1 << minZeroIndex);
            }else { //最小的0大于最小的1，那么可以将最小的0后面的最近的1与最小的0交换
                int tmpOneIndex = minZeroIndex;
                while(tmpOneIndex < 32 && bit[tmpOneIndex] != 1)tmpOneIndex++;
                if(tmpOneIndex == 32){
                    result[1] = -1;
                }else {
                    result[1] = num & (~(1 << tmpOneIndex)) | (1 << minZeroIndex);
                }
            }
        }
        return result;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
