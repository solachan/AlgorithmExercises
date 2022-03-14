package algorithm.leetcode.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class NO10_10_StreamRank {
    //假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
    //
    // 实现 track(int x) 方法，每读入一个数字都会调用该方法；
    //
    // 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
    //
    // 注意：本题相对原题稍作改动
    //
    // 示例:
    //
    // 输入:
    //["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
    //[[], [1], [0], [0]]
    //输出:
    //[null,0,null,1]
    //
    //
    // 提示：
    //
    //
    // x <= 50000
    // track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
    //
    // Related Topics 设计 树状数组 二分查找 数据流 👍 26 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class StreamRank {

        List<Integer> nums;

        public StreamRank() {
            nums = new ArrayList<>();
        }

        public void track(int x) {
            int index = getRankOfNumber(x);
            nums.add(index,x);
        }

        public int getRankOfNumber(int x) {
            int left = 0,right = nums.size() - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums.get(mid) <= x){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    /**
     * Your StreamRank object will be instantiated and called as such:
     * StreamRank obj = new StreamRank();
     * obj.track(x);
     * int param_2 = obj.getRankOfNumber(x);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
