package com.leet.LinkedIn.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/solution/
//with duplicates
public class RandomizedCollection {
    ArrayList <Integer> list;
    HashMap<Integer, Set <Integer>> indexMap; // map holds value and the corresponding index of those values in arraylist
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */

    public RandomizedCollection() {
        list= new ArrayList<Integer>();
        indexMap= new HashMap <Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!indexMap.containsKey(val))
            indexMap.put(val, new LinkedHashSet <Integer>()); // linkedhashset is used because the

        indexMap.get(val).add(list.size());
        list.add(val);
        return indexMap.get(val).size() == 1; // if the size of the set corresponding to this val is 1, then this was the first insertion.
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val) || indexMap.get(val).size() == 0) return false;
        int remove_idx = indexMap.get(val).iterator().next(); // since it is hashset, the value retreval from set is o(1)
        indexMap.get(val).remove(remove_idx);

        // now move last element to the removed element location in arraylist
        int last = list.get(list.size() - 1);
        list.set(remove_idx, last); // NOTE: SINCE LINKEDHASHSET IS USED, IT MAINTAINS THE ORDER OF INSERTION
        // remove the last index from the hashmap's set values.
        indexMap.get(last).add(remove_idx);
        indexMap.get(last).remove(list.size() - 1);

        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
