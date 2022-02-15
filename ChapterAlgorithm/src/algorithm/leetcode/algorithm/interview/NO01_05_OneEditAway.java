package algorithm.leetcode.algorithm.interview;

/**
 * @author xiepuxin
 * @description:
 * @date 2022/2/8 15:51
 */
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
//
//
// 示例 1:
//
// 输入:
//first = "pale"
//second = "ple"
//输出: True
//
//
//
// 示例 2:
//
// 输入:
//first = "pales"
//second = "pal"
//输出: False
//
// Related Topics 双指针 字符串 👍 105 👎 0
public class NO01_05_OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int op = 0;
        int fIndex = 0,sIndex = 0;
        if(first.length() == second.length()){
            while(fIndex < first.length()){
                if(first.charAt(fIndex) != second.charAt(sIndex)){
                    if(op > 0){
                        return false;
                    }
                    op++;
                }
                fIndex++;
                sIndex++;
            }
        }else if(first.length() == second.length() + 1 || first.length() + 1 == second.length()){
            if(first.length() < second.length()) {
                String third = first;
                first = second;
                second = third;
            }
            while(fIndex < first.length() && sIndex < second.length()){
                if(first.charAt(fIndex) != second.charAt(sIndex)){
                    if(op > 0){
                        return false;
                    }
                    op++;
                    fIndex++;
                }else {
                    fIndex++;
                    sIndex++;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
