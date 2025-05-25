package algorithm.leetcode.algorithm;
/*
 * easy
 * 189. Rotate Array
 * Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Related problem: Reverse Words in a String II
 */
public class NO189_RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k%length;
        reverse(nums,length-k,length-1);
        reverse(nums,0,length-k-1);
        reverse(nums,0,length-1);
    }
    public void reverse(int[] nums ,int start,int end){
        int tmp;
        while(start < end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 法二：环状替换
     * 方法一中使用额外数组的原因在于如果我们直接将每个数字放至它最后的位置，这样被放置位置的元素会被覆盖从而丢失。因此，从另一个角度，我们可以将被替换的元素保存在变量 temp 中，从而避免了额外数组的开销。
     *
     * 我们从位置 0 开始，最初令 temp=nums[0]。根据规则，位置 0 的元素会放至 (0+k)modn 的位置，令 x=(0+k)modn，此时交换 temp 和 nums[x]，完成位置 x 的更新。然后，我们考察位置 x，并交换 temp 和 nums[(x+k)modn]，从而完成下一个位置的更新。不断进行上述过程，直至回到初始位置 0。
     *
     * 容易发现，当回到初始位置 0 时，有些数字可能还没有遍历到，此时我们应该从下一个数字开始重复的过程，可是这个时候怎么才算遍历结束呢？我们不妨先考虑这样一个问题：从 0 开始不断遍历，最终回到起点 0 的过程中，我们遍历了多少个元素？
     *
     * 由于最终回到了起点，故该过程恰好走了整数数量的圈，不妨设为 a 圈；再设该过程总共遍历了 b 个元素。因此，我们有 an=bk，即 an 一定为 n,k 的公倍数。又因为我们在第一次回到起点时就结束，因此 a 要尽可能小，故 an 就是 n,k 的最小公倍数 lcm(n,k)，因此 b 就为 lcm(n,k)/k。
     *
     * 这说明单次遍历会访问到 lcm(n,k)/k 个元素。为了访问到所有的元素，我们需要进行遍历的次数为
     *
     * n/ lcm(n,k)/k  =  nk/lcm(n,k) = gcd(n,k)
     * 其中 gcd 指的是最大公约数。
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
