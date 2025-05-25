package algorithm.leetcode.algorithm.interview;

//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
//
// 示例1:
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
//
//
// 示例2:
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
//s = "ball"
// 输出：4
//
//
// 提示:
//
//
// words的长度在[1, 1000000]之间
//
// Related Topics 数组 字符串 二分查找 👍 65 👎 0
public class NO10_05_FindString {
    public static void main(String[] args) {
        String[] words = new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        String s = "dad";
        NO10_05_FindString ins = new NO10_05_FindString();
        System.out.println(ins.findString(words,s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public int findString(String[] words, String s) {
        int l = 0, r = words.length-1,mid = -1;
        while(l<=r){
            mid = l + (r - l)/2;
            if(words[mid].equals("")){
                int mid1= mid, mid2=mid;
                while(mid1>=0&&words[mid1].equals(""))
                    mid1--;
                while(mid2<words.length&&words[mid2].equals(""))
                    mid2++;
                // System.out.println(mid1+" "+mid2);
                if(mid1!=-1&&words[mid1].equals(s)){
                    return mid1;
                }
                if(mid2!=words.length&&words[mid2].equals(s)){
                    return mid2;
                }
                if(mid2!=words.length&&isBigger(s,words[mid2]))
                    l = mid +1;
                else if(mid1!=-1&&isBigger(words[mid1],s))
                    r = mid -1;
                else
                    return -1;
            }else{
                if(words[mid].equals(s))
                    return mid;
                if(isBigger(words[mid],s)){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    private boolean isBigger(String a, String b){
        for(int i=0;i<a.length();i++){
            if(i==b.length())
                return true;
            if(a.charAt(i)==b.charAt(i))
                continue;
            if(a.charAt(i)>b.charAt(i))
                return true;
            else
                return false;
        }
        return false;
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
