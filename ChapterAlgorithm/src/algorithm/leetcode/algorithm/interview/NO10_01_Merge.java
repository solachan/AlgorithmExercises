package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;

//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。
//
// 示例:
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出:[1,2,2,3,5,6]
//
// 说明:
//
// A.length == n + m
//
// Related Topics 数组 双指针 排序 👍 132 👎 0
public class NO10_01_Merge {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] B = new int[]{2,5,6};
        int n = 3;
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        merge(A,m,B,n);
        System.out.println(Arrays.toString(A));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public static void merge(int[] A, int m, int[] B, int n) {
        int a = m-1,b = n-1,index = m+n-1;
        while(a >= 0 || b >= 0){
            if(b < 0)break;
            if(a < 0 || A[a] < B[b]){
                A[index--] = B[b--];
            }else {
                A[index--] = A[a--];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
