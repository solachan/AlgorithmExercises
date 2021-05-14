package algorithm.leetcode.algorithm;

/**
 * @author xiepuxin
 * @description:
 * @date 2021/5/14 11:32
 */
public class UnionFind {
    //记录连同分量个数
    private int count;
    //指向父节点存储若干棵树
    private int[] parent;
    //记录树的重量
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    //连通p和q
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        //小数接到大树下面，较平衡
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    //找出根节点
    private int find(int x){
        while(parent[x] != x){
            //压缩路径
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private int count(){
        return count;
    }
}
