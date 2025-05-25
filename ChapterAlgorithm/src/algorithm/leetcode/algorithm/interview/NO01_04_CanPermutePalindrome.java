package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;

/**
 * @author xiepuxin
 * @description:
 * @date 2022/2/8 15:42
 */
//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
// 回文串不一定是字典当中的单词。
//
//
//
// 示例1：
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
//
//
//
// Related Topics 位运算 哈希表 字符串 👍 66 👎 0

public class NO01_04_CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        Arrays.fill(count,0);
        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) - 0] = (count[s.charAt(i) - 0] + 1) % 2;
        }
        int amount = 0;
        for(int i = 0 ; i< 256 ; i++){
            amount += count[i];
            if(amount > 1){
                return false;
            }
        }
        return true;
    }
}
