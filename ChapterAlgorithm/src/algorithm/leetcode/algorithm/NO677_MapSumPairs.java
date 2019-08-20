package algorithm.leetcode.algorithm;

/**
 * 677. Map Sum Pairs
 * Medium
 * Implement a MapSum class with insert, and sum methods.
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value.
 * If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts
 * with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class NO677_MapSumPairs {
    public static class MapSum {
        DictionaryNode head;
        /** Initialize your data structure here. */
        public MapSum() {
            head = new DictionaryNode();
        }

        public void insert(String key, int val) {
            if(key == null || key.length() == 0)return;
            DictionaryNode tmpNode = head;
            for(int i = 0 ; i < key.length() ; i++){
                if(tmpNode.getNextNode(key.substring(i,i+1)) == null){
                    tmpNode.setNextNode(key.substring(i,i+1),new DictionaryNode());
                }
                tmpNode = tmpNode.getNextNode(key.substring(i,i+1));
                Integer sum = (Integer)tmpNode.getAttribute("sum");
                if(sum == null)sum = 0;
                sum+=val;
                tmpNode.setAttribute("sum",sum);
            }
            if(tmpNode.isEnd()) {
                Integer value = (Integer)tmpNode.getAttribute("value");
                if(value != null) {
                    delete(key, value);
                }
            }
            tmpNode.setEnd(true);
            tmpNode.setAttribute("value",val);
        }

        private void delete(String key, int val) {
            if(key == null || key.length() == 0)return;
            DictionaryNode tmpNode = head;
            for(int i = 0 ; i < key.length() ; i++){
                if(tmpNode.getNextNode(key.substring(i,i+1)) == null){
                    return;
                }
                tmpNode = tmpNode.getNextNode(key.substring(i,i+1));
                Integer sum = (Integer)tmpNode.getAttribute("sum");
                if(sum == null)sum = 0;
                sum-=val;
                tmpNode.setAttribute("sum",sum);
            }
        }

        public int sum(String prefix) {
            if(prefix == null || prefix.length() == 0)return 0;
            DictionaryNode tmpNode = head;
            for(int i = 0 ; i < prefix.length() ; i++){
                if(tmpNode.getNextNode(prefix.substring(i,i+1)) == null){
                    return 0;
                }
                tmpNode = tmpNode.getNextNode(prefix.substring(i,i+1));
            }
            return (Integer)tmpNode.getAttribute("sum");
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("ap", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("ap", 2);
        System.out.println(mapSum.sum("a"));
        System.out.println(mapSum.sum("ap"));
    }
}
