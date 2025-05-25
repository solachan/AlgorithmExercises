package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;

/**
 * @author xiepuxin
 * @description:
 * @date 2022/1/20 18:43
 */
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
// Related Topics 哈希表 字符串 排序 👍 57 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NO01_02_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        int[] arr = new int[256];
        Arrays.fill(arr,0);
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i = 0 ; i < s1.length() ; i++){
            char c = s1.charAt(i);
            arr[(int)c - 0]++;
        }
        for(int i = 0 ; i < s2.length() ; i++){
            char c = s2.charAt(i);
            arr[(int)c - 0]--;
            if(arr[(int)c - 0] < 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
