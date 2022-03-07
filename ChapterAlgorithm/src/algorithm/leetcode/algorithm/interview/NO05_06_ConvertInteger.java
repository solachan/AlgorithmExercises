package algorithm.leetcode.algorithm.interview;

//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
//
// 示例1:
//
//
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
//
//
// 示例2:
//
//
// 输入：A = 1，B = 2
// 输出：2
//
//
// 提示:
//
//
// A，B范围在[-2147483648, 2147483647]之间
//
// Related Topics 位运算 👍 36 👎 0
public class NO05_06_ConvertInteger {
    public static void main(String[] args) {
        System.out.println(convertInteger(826966453,-729934991));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public static int convertInteger(int A, int B) {
        System.out.println(Integer.toBinaryString(A));
        System.out.println(Integer.toBinaryString(B));
        int x = A ^ B;
        System.out.println(Integer.toBinaryString(x));
        String s = Integer.toBinaryString(x);
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if((s.charAt(i) == '1')){
                count++;
            }
        }
        return count;
    }

    public int convertInteger2(int A, int B) {
        //A与B进行异或运算，得到的结果1就是不相同，0就是相同
        //0011^1100 = 1111 结果有几个1，那么就有几个位要改变
        int temp = A^B,count = 0;
        while (temp != 0){
            //temp&(temp -1) 可以把temp最右边的1置0，其余位不变
            //这样，这个操作执行了几次，就是有几位要转换
            temp = temp&(temp - 1);
            count++;
        }
        return count;
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
