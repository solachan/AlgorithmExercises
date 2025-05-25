package algorithm.leetcode.algorithm.interview;

/**
 * @author xiepuxin
 * @description:
 * @date 2022/1/20 18:38
 */
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
// 输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
// 输入: s = "abc"
//输出: true
//
//
// 限制：
//
// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 位运算 哈希表 字符串 排序 👍 182 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NO01_01_IsUniqueString {
    public boolean isUnique(String astr) {
        boolean[] isvisited = new boolean[256];
        for(char a : astr.toCharArray()){
            if(isvisited[a]){
                return false;
            }
            isvisited[a] = true;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
