package algorithm.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 679. 24 Game
 * Hard
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 *
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 * Input: [1, 2, 1, 2]
 * Output: False
 * Note:
 * The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input,
 * the expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */
public class NO679_24Game {
    public static void main(String[] args) {
        int[] nums = {7,4,1,8};
        System.out.println(Arrays.toString(nums) + " , " + judgePoint24(nums));
    }
    public static boolean judgePoint24(int[] nums) {
        if(nums == null)return false;
        List<Double> list = new ArrayList<>();
        for(int num : nums){
            list.add((double)num);
        }
        return helper(list,24.0);
    }

    public static boolean helper(List<Double> list,double target){
        if(list == null || list.size() == 0)return false;
        if(list.size() == 1 && Math.abs(list.get(0) - target) < 0.00001){
            return true;
        }
        //每次取两个数处理
        for(int i = 0 ; i < list.size() ; i++){
            for(int j = i+1 ; j < list.size() ; j++){
                List<Double> cal = new ArrayList<>();
                //考虑各个情况
                cal.add(list.get(i)+list.get(j));
                cal.add(list.get(i)-list.get(j));
                cal.add(list.get(j)-list.get(i));
                cal.add(list.get(i)*list.get(j));
                if(list.get(i) != 0)cal.add(list.get(j)/list.get(i));
                if(list.get(j) != 0)cal.add(list.get(i)/list.get(j));
                Double num1 = list.get(i);
                Double num2 = list.get(j);
                list.remove(j);
                list.remove(i);
                for(Double calNum : cal){
                    list.add(calNum);
                    if(helper(list,target))return true;
                    list.remove(list.size()-1);
                }
                list.add(i,num1);
                list.add(j,num2);
            }
        }
        return false;
    }
}
