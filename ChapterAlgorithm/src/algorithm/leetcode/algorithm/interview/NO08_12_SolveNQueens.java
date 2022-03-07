package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
//[".Q..", // 解法 1
// "...Q",
// "Q...",
// "..Q."],
//
//["..Q.", // 解法 2
// "Q...",
// "...Q",
// ".Q.."]
//]
// 
// Related Topics 数组 回溯 👍 123 👎 0
public class NO08_12_SolveNQueens {
    public static void main(String[] args) {
        NO08_12_SolveNQueens ins = new NO08_12_SolveNQueens();
        System.out.println(ins.solveNQueens(4));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> ll = new LinkedList<>();
        solveNQueens(0,board,ll);
        return ll;
    }

    private void solveNQueens(int n, char[][] board, List<List<String>> ll) {
        if(n >= board.length){
            List<String> list = new LinkedList<>();
            for(int i = 0 ; i < board.length ; i++){
                list.add(String.valueOf(board[i]));
            }
            ll.add(list);
            return;
        }
        for(int i = 0 ; i < board.length ; i++){
            board[n][i] = 'Q';
            if(validate(n,i,board)){
                solveNQueens(n+1,board,ll);
            }
            board[n][i] = '.';
        }
    }

    private boolean validate(int x, int y, char[][] board) {
        for(int i = 0 ; i < board.length ; i++){
            if(i != y && board[x][i] == 'Q'){
                return false;
            }
            if(i != x && board[i][y] == 'Q'){
                return false;
            }
            if(i != 0 && x + i < board.length && y + i < board.length && board[x+i][y+i] == 'Q'){
                return false;
            }
            if(i != 0 && x - i >= 0 && y + i < board.length && board[x-i][y+i] == 'Q'){
                return false;
            }
            if(i != 0 && x + i < board.length && y - i >= 0 && board[x+i][y-i] == 'Q'){
                return false;
            }
            if(i != 0 && x - i >= 0 && y - i >= 0 && board[x-i][y-i] == 'Q'){
                return false;
            }
        }
        return true;
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
