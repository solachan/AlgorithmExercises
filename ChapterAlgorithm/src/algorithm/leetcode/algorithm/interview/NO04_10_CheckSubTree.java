package algorithm.leetcode.algorithm.interview;
import algorithm.leetcode.algorithm.TreeNode;

import java.util.ArrayList;

//检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
//
// 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
//
// 注意：此题相对书上原题略有改动。
//
// 示例1:
// 输入：t1 = [1, 2, 3], t2 = [2]
// 输出：true
//
// 示例2:
// 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
// 输出：false
//
// 提示：
// 树的节点数目范围为[0, 20000]。
//
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 49 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class NO04_10_CheckSubTree {
    public static void main(String[] args) {
        NO04_10_CheckSubTree instance = new NO04_10_CheckSubTree();
        TreeNode t1 = TreeNode.getTree(new Integer[]{358, 361, 359, 373, 367, 360, 364, null, 380, 368, 383, 362, 379, null, 366, 381, null, 385, 374, null, 406, 363, null, 391, null, 372, 369, null, null, 405, 404, 393, 397, null, null, 375, 365, null, 392, 403, 377, 376, 371, null, 408, null, null, null, 410, null, null, null, null, 370, 401, null, null, null, null, 388, null, null, 395, 384, 382, null, null, null, 411, 409, 378, null, null, null, null, null, 402, 389, null, 396, null, null, null, null, null, null, 386, 413, null, null, null, null, null, 394, 387, null, null, 412, 399, 400, 390, null, null, null, null, null, null, null, 398, null, 407});
        TreeNode t2 = TreeNode.getTree(new Integer[]{363, 375, 365, null, null, 370, 401, 409, 378, null, null, null, null, null, 386, 394, 387, 412, 399, 400, 390, null, null, null, null, null, null, null, 398, null, 407});
    }
    //1、递归法
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val == t2.val){
            return checkSubTree(t1.left,t2.left) && checkSubTree(t1.right,t2.right);
        }else {
            return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
        }
    }

    //2、KMP
    //KMP算法解：1.先拿到两个树的先序序列化2.接下来就是看看t1产生的str数组是否能匹配t2产生的match数组
    public static void preSerial(TreeNode head,ArrayList<String> preList){
        if(head==null){
            preList.add("null");
            return;
        }
        preList.add(head.val+"");
        preSerial(head.left,preList);
        preSerial(head.right,preList);
    }
    public static boolean checkSubTree2(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        ArrayList<String> str = new ArrayList<>();
        preSerial(t1,str);
        ArrayList<String> match = new ArrayList<>();
        preSerial(t2,match);
        return getIndexOf(str,match)!=-1;
    }

    private static int getIndexOf(ArrayList<String> str, ArrayList<String> match) {
        if(match.size()>str.size()) return  -1;
        int x = 0,y = 0;
        int[] nexts = getNextArray(match);
        while (x<str.size()&&y<match.size()){
            if(str.get(x).equals(match.get(y))){
                x++;y++;
            }else if(nexts[y]==-1){
                x++;
            }else{
                y = nexts[y];
            }
        }
        return y==match.size()?x-y:-1;
    }

    private static int[] getNextArray(ArrayList<String> match) {
        if(match.size()==1) return new int[]{-1};
        int[] next = new int[match.size()];
        next[0] = -1;
        next[1] = 0;
        int preNext = 0;
        int cur = 2;
        while (cur<match.size()){
            if(match.get(preNext).equals(match.get(cur))){
                next[cur++] = ++preNext;
            }else if(preNext>0){
                preNext = next[preNext];
            }else{
                next[cur++] = 0;
            }
        }
        return next;
    }


    //leetcode submit region end(Prohibit modification and deletion)

}
