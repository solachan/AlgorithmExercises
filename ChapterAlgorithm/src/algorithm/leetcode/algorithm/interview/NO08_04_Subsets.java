package algorithm.leetcode.algorithm.interview;

import java.util.LinkedList;
import java.util.List;

//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
// [1],
// [2],
// [1,2,3],
// [1,3],
// [2,3],
// [1,2],
// []
//]
// 
// Related Topics 位运算 数组 回溯 👍 85 👎 0
public class NO08_04_Subsets {
    public static void main(String[] args) {
        NO08_04_Subsets subsets = new NO08_04_Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        helper(nums,path,result,0);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> result, int i) {
        if(i == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }
        helper(nums,path,result,i+1);
        path.add(nums[i]);
        helper(nums,path,result,i+1);
        path.remove(path.size()-1);
    }

}
