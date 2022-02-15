package algorithm.leetcode.algorithm.interview;

/**
 * @author xiepuxin
 * @description:
 * @date 2022/2/8 15:33
 */
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。）
//
//
//
// 示例 1：
//
//
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
//
//
// 示例 2：
//
//
//输入："               ", 5
//输出："%20%20%20%20%20"
//
//
//
//
// 提示：
//
//
// 字符串长度在 [0, 500000] 范围内。
//
// Related Topics 字符串 👍 61 👎 0
public class NO01_03_ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        int spaceCount = 0;
        for(int i = 0 ; i < length ; i++){
            if(S.charAt(i) == ' '){
                spaceCount++;
            }
        }
        int resultLength = length + 2 * spaceCount;
        char[] result = new char[resultLength];
        int index = 0;
        for(int i = 0 ; i < length ; i++){
            if(S.charAt(i) == ' '){
                result[index++] = '%';
                result[index++] = '2';
                result[index++] = '0';
            }else {
                result[index++] = S.charAt(i);
            }
        }
        return String.valueOf(result);
    }
}
