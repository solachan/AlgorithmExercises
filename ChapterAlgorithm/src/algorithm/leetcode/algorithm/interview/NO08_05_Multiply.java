package algorithm.leetcode.algorithm.interview;

//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
//
// 示例1:
//
//
// 输入：A = 1, B = 10
// 输出：10
//
//
// 示例2:
//
//
// 输入：A = 3, B = 4
// 输出：12
//
//
// 提示:
//
//
// 保证乘法范围不会溢出
//
// Related Topics 位运算 递归 数学 👍 58 👎 0
public class NO08_05_Multiply {
    public static void main(String[] args) {
        NO08_05_Multiply ins = new NO08_05_Multiply();
        System.out.println(ins.multiply(2,10));
    }

    //1、递归
    public int multiply(int A, int B) {
        if(A == 0 || B == 0){
            return 0;
        }
        return ((B & 1) == 1 ? A : 0) + multiply(A << 1,B >> 1);
    }

    //2、迭代
    //leetcode submit region begin(Prohibit modification and deletion)
    public int multiply2(int A, int B) {
        int result = 0;
        while(B != 0){
            result+= (B&1) == 1 ? A : 0;
            B >>= 1;
            A <<= 1;
        }
        return result;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
