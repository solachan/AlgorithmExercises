package algorithm.leetcode.algorithm.interview;
import java.util.LinkedList;
import java.util.List;

//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
//
// 示例1:
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
//
//
// 示例2:
//
//  输入：S = "ab"
// 输出：["ab", "ba"]
//
//
// 提示:
//
//
// 字符都是英文字母。
// 字符串长度在[1, 9]之间。
//
// Related Topics 字符串 回溯 👍 57 👎 0
public class NO08_08_Permutation {

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
