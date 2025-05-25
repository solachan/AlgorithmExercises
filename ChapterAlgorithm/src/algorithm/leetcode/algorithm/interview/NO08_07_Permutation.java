package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
//
// 示例1:
//
//
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
//
//
// 示例2:
//
//
// 输入：S = "ab"
// 输出：["ab", "ba"]
//
//
// 提示:
//
//
// 字符都是英文字母。
// 字符串长度在[1, 9]之间。
//
// Related Topics 字符串 回溯 👍 60 👎 0
public class NO08_07_Permutation {
    public static void main(String[] args) {
        NO08_07_Permutation ins = new NO08_07_Permutation();
        System.out.println(Arrays.toString(ins.permutation("ab")));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public String[] permutation(String S) {
        List<String> list = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        permutation(S,path,list);
        return list.toArray(new String[list.size()]);
    }

    private void permutation(String s, StringBuilder path, List<String> list) {
        if(s.length() == 0){
            list.add(path.toString());
        }
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            String next = s.substring(0,i) + s.substring(i+1,s.length());
            path.append(c);
            permutation(next,path,list);
            path.deleteCharAt(path.length()-1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
