package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只
//能放在更大的盘子上面)。移动圆盘时受到以下限制:
//(1) 每次只能移动一个盘子;
//(2) 盘子只能从柱子顶端滑出移到下一根柱子;
//(3) 盘子只能叠在比它大的盘子上。
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
//
// 你需要原地修改栈。
//
// 示例1:
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
//
//
// 示例2:
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
//
//
// 提示:
//
//
// A中盘子的数目不大于14个。
//
// Related Topics 递归 数组 👍 139 👎 0
public class NO08_06_Hanota {
    public static void main(String[] args) {
        NO08_06_Hanota ins = new NO08_06_Hanota();
        List<Integer> A = new LinkedList<>(Arrays.asList(1,2,3));
        List<Integer> B = new LinkedList<>();
        List<Integer> C = new LinkedList<>();
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        ins.hanota(A,B,C);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(),A,B,C);
    }
    public void hanota(int size,List<Integer> source, List<Integer> helper, List<Integer> target) {
        //只需移动一个
        if(size == 1){
            target.add(source.remove(source.size()-1));
            return;
        }
        //需移动一个以上
        //先将size-1个移动到helper
        hanota(size-1,source,target,helper);
        //再将最后1个移动到target
        hanota(1,source,helper,target);
        //最后将helper上size-1个移动到target
        hanota(size-1,helper,source,target);
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
