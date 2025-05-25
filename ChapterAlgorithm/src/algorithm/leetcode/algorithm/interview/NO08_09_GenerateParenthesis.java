package algorithm.leetcode.algorithm.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
//
// 说明：解集不能包含重复的子集。
//
// 例如，给出 n = 3，生成结果为：
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 动态规划 回溯 👍 102 👎 0
public class NO08_09_GenerateParenthesis {
    public static void main(String[] args) {
        NO08_09_GenerateParenthesis ins = new NO08_09_GenerateParenthesis();
        System.out.println(ins.generateParenthesis(3));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generateParenthesis(0,0,n,"",result);
        return result;
    }

    private void generateParenthesis(int left, int right, int max, String path, List<String> result) {
        if(path.length() == 2 * max){
            result.add(path);
            return;
        }
        if(left < max){
            generateParenthesis(left + 1, right,max,path + "(",result);
        }
        if(right < left){
            generateParenthesis(left,right+1,max,path + ")",result);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
