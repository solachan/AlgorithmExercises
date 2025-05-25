package algorithm.leetcode.algorithm.interview;

//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。
//
// 示例1:
//
//
// 输入：0.625
// 输出："0.101"
//
//
// 示例2:
//
//
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
//
//
// 提示：
//
//
// 32位包括输出中的"0."这两位。
//
// Related Topics 位运算 数学 字符串 👍 31 👎 0
public class NO05_02_PrintBin {
    public static void main(String[] args) {
        System.out.println(printBin(0.72));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public static String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while(sb.length() <= 32 && num != 0D){
            num *= 2;
            if(num >= 1){
                num -= 1;
                sb.append(1);
            }else {
                sb.append(0);
            }
        }
        return sb.length() > 32 ? "ERROR" : sb.toString();
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
