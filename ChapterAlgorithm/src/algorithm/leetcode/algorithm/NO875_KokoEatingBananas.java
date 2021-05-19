package algorithm.leetcode.algorithm;

/**
 * Medium
 * 875. Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 *
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 * Constraints:
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 1^09
 */
public class NO875_KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = new int[]{30,11,23,4,20};
        int h = 5;
        int result = new NO875_KokoEatingBananas().minEatingSpeed(piles,h);
        System.out.println(result);
    }
    //二分法查找
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPiles(piles);
        while(left < right){
            int mid = left + (right - left)/2;
            if(canFinish(piles,h,mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int count = 0;
        for(int i = 0 ; i < piles.length ; i++){
            count += piles[i] / k + (piles[i] % k > 0 ? 1 : 0);
            if(count > h){
                return false;
            }
        }
        return true;
    }

    private int getMaxPiles(int[] piles) {
        int max = 0;
        for(int i = 0 ; i < piles.length ; i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }
}
