package algorithm.leetcode.algorithm;

import java.util.*;

/**
 * 676. Implement Magic Dictionary
 * Medium
 * Related: Implement Trie (Prefix Tree) ; Longest Word in Dictionary
 * Implement a magic directory with buildDict, and search methods.
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word,
 * the modified word is in the dictionary you just built.
 *
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 *
 * Note:
 * You may assume that all the inputs are consist of lowercase letters a-z.
 * For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
 * Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class NO676_ImplementMagicDictionary {
    /**
     * 解决方法1：
     * 建立树存储每一个单词及其变形的统计个数
     * 搜索：如果存在某个变形的个数在2个及以上，或者存在变形个数为1且原形个数为0时，表示成功，否则失败。
     */
    public static class MagicDictionary {
        private DictionaryNode head = new DictionaryNode();
        /** Initialize your data structure here. */
        public MagicDictionary() {
            head = new DictionaryNode();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            if(dict == null || dict.length == 0)return;
            for(String word : dict){
                if(word == null || word.length() == 0)continue;
                List<String> magicWords = getAllMagicStrings(word);
                magicWords.add(word);
                DictionaryNode tmpNode = head;
                for(int j = 0 ; j < magicWords.size() ; j++) {
                    String magicWord = magicWords.get(j);
                    tmpNode = head;
                    for (int i = 0; i < word.length(); i++) {
                        if (tmpNode.getNextNode(magicWord.substring(i, i + 1)) == null) {
                            DictionaryNode nextNode = new DictionaryNode();
                            tmpNode.setNextNode(magicWord.substring(i, i + 1), new DictionaryNode());
                        }
                        tmpNode = tmpNode.getNextNode(magicWord.substring(i, i + 1));
                        if (i == magicWord.length() - 1) {
                            Integer count = (Integer)tmpNode.getAttribute("count");
                            if(count == null){
                                count = 0;
                            }
                            count++;
                            tmpNode.setAttribute("count",count);
                            tmpNode.setEnd(true);
                        }
                    }
                }
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            DictionaryNode tmpNode = head;
            int matchMagicCount = 0;
            boolean isDictonaryWord = false;
            List<String> magicWords = getAllMagicStrings(word);
            for(int j = 0 ; j < magicWords.size() ; j++) {
                String magicWord = magicWords.get(j);
                int matchCount = getMatchCount(magicWord);
                if(matchCount >= 2)return true;
                if(matchCount > matchMagicCount)matchMagicCount = matchCount;
            }
            return matchMagicCount == 1 && getMatchCount(word) == 0;
        }

        public int getMatchCount(String word){
            int count = 0;
            if(word == null)return count;
            DictionaryNode tmpNode = head;
            for (int i = 0; i < word.length(); i++) {
                if (tmpNode.getNextNode(word.substring(i, i + 1)) == null) {
                    DictionaryNode nextNode = new DictionaryNode();
                    tmpNode.setNextNode(word.substring(i, i + 1), new DictionaryNode());
                }
                tmpNode = tmpNode.getNextNode(word.substring(i, i + 1));
            }
            if(tmpNode.isEnd()){
                Integer tmpCount = (Integer)tmpNode.getAttribute("count");
                if(tmpCount == null)tmpCount = 0;
                count = tmpCount;
            }
            return count;
        }

        public List<String> getAllMagicStrings(String word){
            List<String> result = new ArrayList<>();
            if(word == null){
                return result;
            }
            for(int i = 0 ; i < word.length() ; i++){
                result.add(word.substring(0,i) + "*" + word.substring(i+1,word.length()));
            }
            return result;
        }
    }
    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }

    /**
     * 解决方法2：
     * 有Map来存储
     */
    public class MagicDictionary2 {
        Set<String> words;
        Map<String, Integer> count;

        public MagicDictionary2() {
            words = new HashSet();
            count = new HashMap();
        }

        private ArrayList<String> generalizedNeighbors(String word) {
            ArrayList<String> ans = new ArrayList();
            char[] ca = word.toCharArray();
            for (int i = 0; i < word.length(); ++i) {
                char letter = ca[i];
                ca[i] = '*';
                String magic = new String(ca);
                ans.add(magic);
                ca[i] = letter;
            }
            return ans;
        }

        public void buildDict(String[] words) {
            for (String word: words) {
                this.words.add(word);
                for (String nei: generalizedNeighbors(word)) {
                    count.put(nei, count.getOrDefault(nei, 0) + 1);
                }
            }
        }

        public boolean search(String word) {
            for (String nei: generalizedNeighbors(word)) {
                int c = count.getOrDefault(nei, 0);
                if (c > 1 || c == 1 && !words.contains(word)) return true;
            }
            return false;
        }
    }
}
