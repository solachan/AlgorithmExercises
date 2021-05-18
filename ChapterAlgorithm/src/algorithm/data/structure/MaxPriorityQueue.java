package algorithm.data.structure;

/**
 *
 */
public class MaxPriorityQueue <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    public MaxPriorityQueue(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    public Key max(){
        return pq[1];
    }

    public void insert(Key key){
        N++;
        pq[N] = key;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exchange(1,N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    public void swim(int k){
        while(k > 1 && less(parent(k),k)){
            exchange(parent(k),k);
            k = parent(k);
        }
    }

    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (left(k) <= N) {
            // 先假设左边节点较大
            int older = left(k);
            // 如果右边节点存在，比一下大小
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            // 结点 k 比俩孩子都大，就不必下沉了
            if (less(older, k)) {
                break;
            }
            // 否则，不符合最大堆的结构，下沉 k 结点
            exchange(k, older);
            k = older;
        }
    }


    public void exchange(int i,int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int parent(int k){
        if(k / 2 >= 1){
            return k/2;
        }else {
            return 0;
        }
    }

    private int left(int k){
        if(k * 2 <= N){
            return k * 2;
        }else {
            return 0;
        }
    }

    private int right(int k){
        if(k * 2 + 1 <= N){
            return k * 2 + 1;
        }else {
            return 0;
        }
    }
}
