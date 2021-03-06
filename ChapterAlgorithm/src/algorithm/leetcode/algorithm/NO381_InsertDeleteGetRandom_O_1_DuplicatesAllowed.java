package algorithm.leetcode.algorithm;
/*
 * hard
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed 
 * Design a data structure that supports all following operations in average O(1) time.
Note: Duplicate elements are allowed.

    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements. 
    The probability of each element being returned is linearly related to the number of same value the collection contains.

Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();

 */
import java.util.*;
public class NO381_InsertDeleteGetRandom_O_1_DuplicatesAllowed {
	//方法1：
	//利用ArrayList存储所有元素，HashMap<Integer,LinkedHashSet>>存储每一个元素及其出现的位置集
	//增加某个元素，直接在ArrayList中加入该元素，并在map中对应位置集添加该位置
	//删除某个元素时，将数组最后一个元素与被删除元素的其中某一个位置置换，删除最后一个元素，以及更新相应位置集
	class RandomizedCollection {
	    ArrayList<Integer> result;
	    HashMap<Integer, LinkedHashSet<Integer>> map;
	    
	    public RandomizedCollection() {
	        result = new ArrayList<Integer>();
	        map = new HashMap<Integer, LinkedHashSet<Integer>>();
	    }
	    
	    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	    public boolean insert(int val) {
	        // Add item to map if it doesn't already exist.
	        boolean alreadyExists = map.containsKey(val);
	        if(!alreadyExists) {
	            map.put(val, new LinkedHashSet<Integer>());
	        }
	        map.get(val).add(result.size());
	        result.add(val);
	        return !alreadyExists;
	    }
	    
	    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	    public boolean remove(int val) {
	        if(!map.containsKey(val)) {
	            return false;
	        }
	        // Get arbitary index of the ArrayList that contains val
	        LinkedHashSet<Integer> valSet = map.get(val);
	        int indexToReplace = valSet.iterator().next();
	        
	        // Obtain the set of the number in the last place of the ArrayList
	        int numAtLastPlace = result.get(result.size() - 1);
	        LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace);
	        
	        // Replace val at arbitary index with very last number
	        result.set(indexToReplace, numAtLastPlace);
	        
	        // Remove appropriate index
	        valSet.remove(indexToReplace);
	        
	        // Don't change set if we were replacing the removed item with the same number
	        if(indexToReplace != result.size() - 1) {
	            replaceWith.remove(result.size() - 1);
	            replaceWith.add(indexToReplace);
	        }
	        result.remove(result.size() - 1);
	        
	        // Remove map entry if set is now empty, then return
	        if(valSet.isEmpty()) {
	            map.remove(val);
	        }
	        return true;
	    }
	    
	    /** Get a random element from the collection. */
	    public int getRandom() {
	        // Get linearly random item
	        return result.get((int)(Math.random() * result.size()));
	    }
	}
}
