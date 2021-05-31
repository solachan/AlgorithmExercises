package algorithm.leetcode.algorithm;
/*
 * hard
 * 354. Russian Doll Envelopes 
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope is
 *  greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], 
the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]). 
 */
import java.util.*;
public class NO354_RussianDollEnvelopes {
	public static void main(String[] args) {
		int[][] envelopes = new int[][]{{1,1},{1,2},{1,3}};
	}
	//方法1：
	//O(n^2)time,容易超时
	//先对宽进行排序，然后再对高进行动态规划
	public static int maxEnvelopes(int[][] envelopes) {
        if (   envelopes           == null
            || envelopes.length    == 0
            || envelopes[0]        == null
            || envelopes[0].length == 0){
            return 0;    
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return Integer.compare(e1[0], e2[0]);
            }
        });
        
        int   n  = envelopes.length;
        int[] dp = new int[n];
        
        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            
            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                    && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);    
                }
            }
            
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
	//方法2：
	//先对宽进行排序，宽度小的排在前面，宽度相同的，高度高的排在前面，然后对高找最长子序列
	public int maxEnvelopes2(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] e1,int[] e2){
                if(e1[0] == e2[0]){
                    return e2[1]-e1[1];
                }else{
                    return e1[0]-e2[0];
                }
            }
        });
        int n = envelopes.length,len = 0;
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++){
            //寻找插入点
            int index = Arrays.binarySearch(dp,0,len,envelopes[i][1]);
            if(index < 0){  //如果找不到就返回 (-(插入点) - 1)
                index = -(index + 1);
            }
            dp[index] = envelopes[i][1];
            if(index == len){
                len++;
            }
        }
        return len;
    }

    public int maxEnvelopes3(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        //对于宽度 w 相同的数对，要对其高度 h 进行降序排序。因为两个宽度相同的信封不能相互包含的，逆序排序保证在 w 相同的数对中最多只选取一个。
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int length = 0;
        for(int i = 0 ; i < envelopes.length ; i++){
            int left = 0, right = length;
            while(left < right){
                int mid = (left + right)/2;
                if(envelopes[i][1] <= dp[mid]){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            if(left == length)length++;
            dp[left] = envelopes[i][1];
        }
        return length;
    }
}
