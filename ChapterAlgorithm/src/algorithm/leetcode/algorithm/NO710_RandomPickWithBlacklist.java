package algorithm.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Hard
 * 710. Random Pick with Blacklist
 * Given a blacklist blacklist containing unique integers from [0, n), write a function to return a uniform random integer from [0, n) which is NOT in blacklist.
 * Optimize it such that it minimizes the call to system’s Math.random().
 *
 * Note:
 * 1 <= n <= 1000000000
 * 0 <= blacklist.length < min(100000, n)
 * [0, n) does NOT include n. See interval notation.
 *
 * Example 1:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * Output: [null,0,0,0]
 *
 * Example 2:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * Output: [null,1,1,1]
 *
 * Example 3:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 *
 * Example 4:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * Output: [null,1,3,1]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has two arguments, n and the blacklist blacklist.
 * pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class NO710_RandomPickWithBlacklist {
    class Solution {
        //方法1：将blacklist里[0,n-blacklist.length)的元素映射到[n-blacklist.length,n)中，而原来就已经在[n-blacklist.length,n)的blacklist元素则不处理
        private Map<Integer,Integer> blackbox;
        private int range;
        Random rand;
        public Solution(int n, int[] blacklist) {
            rand = new Random();
            blackbox = new HashMap<>();
            range = n - blacklist.length;
            int last = n - 1;
            blackbox = new HashMap<>();
            if(blacklist != null){
                for(int black : blacklist){
                    blackbox.put(black,-1);
                }
                for(int black : blacklist){
                    if(black < range){
                        while(blackbox.containsKey(last)){
                            last--;
                        }
                        blackbox.put(black,last--);
                    }
                }
            }
        }

        public int pick() {
            int index = rand.nextInt(range);
            return blackbox.getOrDefault(index, index);
        }
    }

}
