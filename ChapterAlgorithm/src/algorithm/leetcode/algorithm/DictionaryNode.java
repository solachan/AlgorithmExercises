package algorithm.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class DictionaryNode {
    private Map<String,Object> attributes = new HashMap<>();
    private boolean isEnd = false;
    private Map<String,DictionaryNode> nextNodes = new HashMap<>();

    public void setNextNode(String key, DictionaryNode nextNode){
        if(nextNodes == null)nextNodes = new HashMap<>();
        nextNodes.put(key,nextNode);
    }

    public DictionaryNode getNextNode(String key){
        if(nextNodes == null)return null;
        return nextNodes.get(key);
    }
    public Object getAttribute(String key){
        if(attributes == null)return null;
        return attributes.get(key);
    }
    public void setAttribute(String key,Object attribute){
        if(attributes == null)attributes = new HashMap<>();
        attributes.put(key,attribute);
    }

    public int clearAttributes(){
        if(attributes == null){
            attributes = new HashMap<>();
            return 0;
        }
        int result = attributes.size();
        attributes.clear();
        return result;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Map<String, DictionaryNode> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(Map<String, DictionaryNode> nextNodes) {
        this.nextNodes = nextNodes;
    }
}
