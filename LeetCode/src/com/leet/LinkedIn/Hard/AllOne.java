package com.leet.LinkedIn.Hard;

import java.util.*;

//https://leetcode.com/problems/all-oone-data-structure/
//https://leetcode.com/problems/all-oone-data-structure/discuss/1229078/Java-one-Map-double-linked-list-CLEAN-CODE
//MAP BE USE DEQUEUE??
public class AllOne {
    SortedMap <Integer, Set <String>> sortedMap;
    HashMap <String, Integer> map;
    /** Initialize your data structure here. */
    public AllOne() {
        this.sortedMap = new TreeMap <>();
        this.map = new HashMap <>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int val = map.getOrDefault(key,0)+1;
        this.map.put(key, val);
        Set <String> stringSet = sortedMap.getOrDefault(val,new HashSet <>());
        stringSet.add(key);

        Set <String> set=sortedMap.get(val-1);
        if(set!=null && !set.isEmpty() && set.size()>1) {
            set.remove(key);
            if(!set.isEmpty())
            sortedMap.put(val-1, set);
        }
        this.sortedMap.put(val,stringSet);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int val = map.getOrDefault(key,0)-1;
        if(val<=0) {
            Set <String> set=sortedMap.get(val+1);
            set.remove(key);
            if(set.isEmpty()){
                sortedMap.remove(val+1);
            }
            else{
                sortedMap.put(val+1, set);
            }
            map.remove(key);
        }else {
            Set <String> set=sortedMap.get(val+1);
            set.remove(key);
            if(set.isEmpty()){
                sortedMap.remove(val+1);
            }
            else{
                sortedMap.put(val+1, set);
            }
            set=sortedMap.getOrDefault(val, new HashSet <>());
            set.add(key);
            sortedMap.put(val, set);
            this.map.put(key, val);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(sortedMap.isEmpty()) return "";
        HashSet<String> set = (HashSet)sortedMap.get(sortedMap.lastKey());
        if(set.iterator().hasNext()){
            return set.iterator().next();
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(sortedMap.isEmpty()) return "";
        HashSet <String> set=(HashSet) sortedMap.get(sortedMap.firstKey());
        if(set.iterator().hasNext()){
            return set.iterator().next();
        }
        return "";
    }

//        HashMap<String, Integer> mapString;
//    SortedMap<Integer, HashSet<String>> mapCount;
//        public AllOne() {
//            mapString = new HashMap <>();
//            mapCount = new TreeMap();
//        }
//
//        public void inc(String key) {
//            int count = mapString.getOrDefault(key, 0);
//            mapString.put(key, count+1);
//            HashSet<String> set = mapCount.getOrDefault(count+1,new HashSet <>());
//            set.add(key);
//            mapCount.put(count+1, set);
//        }
//
//        public void dec(String key) {
//            int count = mapString.get(key);
//            mapString.put(key, count-1);
//            HashSet<String> set1 = mapCount.get(count);
//            set1.remove(key);
//            if(!set1.isEmpty())
//                mapCount.put(count,set1);
//            else
//                mapCount.remove(count);
//            HashSet<String> set = mapCount.getOrDefault(count-1,new HashSet <>());
//            set.add(key);
//            mapCount.put(count-1, set);
//        }
//
//        public String getMaxKey() {
//            int key = mapCount.lastKey();
//            HashSet<String> set = mapCount.get(key);
//            return set
//        }
//
//        public String getMinKey() {
//
//        }


    public static void main(String[] args) {
        AllOne ao = new AllOne();
        ao.inc("a");
        ao.inc("b");
        ao.inc("c");
        ao.inc("d");
        ao.inc("a");
        ao.inc("b");
        ao.inc("c");
        ao.inc("d");
        ao.inc("c");
        ao.inc("d");
        ao.inc("d");
        ao.inc("a");
        System.out.println(ao.getMaxKey());
        System.out.println(ao.getMinKey());

//        System.out.println(ao.getMaxKey());
//        System.out.println(ao.getMinKey());
    }
}
