package algorithm.leetcode.algorithm.interview;

//配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
//
// 示例1:
//
//
// 输入：num = 2（或者0b10）
// 输出 1 (或者 0b01)
//
//
// 示例2:
//
//
// 输入：num = 3
// 输出：3
//
//
// 提示:
//
//
// num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
//
// Related Topics 位运算 👍 62 👎 0
public class NO05_07_ExchangeBits {


    //leetcode submit region begin(Prohibit modification and deletion)
    //1、分别取出奇数位和偶数位，移动后做或运算。
    //题目规定 num 是int范围的数
    //0x55555555 = 0b0101_0101_0101_0101_0101_0101_0101_0101
    //0xaaaaaaaa = 0b1010_1010_1010_1010_1010_1010_1010_1010
    //
    //用这两个数做与运算，就可以把奇数位和偶数位取出来，
    //然后位左移奇数位，右移偶数位，
    //再把 奇数位和偶数位做或运算。
    public int exchangeBits(int num) {
        //奇数
        int odd = num & 0x55555555;
        //偶数
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1;
        return odd | even;
    }

    public int exchangeBits2(int num) {
        int i = 0 , j = 1;
        while(i <= 30){
            int odd = num >> i & 1;
            int even = num >> j & 1;
            if(odd != even){
                //和0做异或运算值不变
                //和1做异或运算值改变
                //1 ^ 0 = 1
                //0 ^ 0 = 0
                //1 ^ 1 = 0
                //0 ^ 1 = 1
                num ^= 1 << i;
                num ^= 1 << j;
            }
            i+=2;
            j+=2;
        }
        return num;
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
