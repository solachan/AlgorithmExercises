package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
//
// 注意：本题相对原题稍作修改
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串 排序 👍 93 👎 0
public class NO10_02_GroupAnagrams {
    public static void main(String[] args) {
        NO10_02_GroupAnagrams ins = new NO10_02_GroupAnagrams();
//        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = new String[]{"ron","huh","gay","tow","moe","tie","who","ion","rep","bob","gte","lee","jay","may","wyo","bay","woe","lip","tit","apt","doe","hot","dis","fop","low","bop","apt","dun","ben","paw","ere","bad","ill","fla","mop","tut","sol","peg","pop","les"};
        System.out.println(ins.groupAnagrams(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String tmp = helper(str);
            if(!map.containsKey(tmp)){
                map.put(tmp,new LinkedList<>());
            }
            map.get(tmp).add(str);
        }
        List<List<String>> result = new LinkedList<>();
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    private String helper(String str) {
        int[] count = new int[26];
        Arrays.fill(count,0);
        for(char c : str.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < count.length ; i++){
            if(count[i] > 0){
                sb.append((char)('a' + i) + "" + count[i]);
            }
        }
        return sb.toString();
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
