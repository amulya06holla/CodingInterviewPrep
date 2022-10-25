package com.leet.LinkedIn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

 class Pair<U, V> {
        public U key;
        public V value;

        public Pair(U key, V value) {
            this.key= key;
            this.value=value;
        }
    }

    class Bucket {
        private List <Pair<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new LinkedList <Pair<Integer, Integer>>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.key.equals(key))
                    return pair.value;
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.key.equals(key)) {
                    pair.value= value;
                    found = true;
                }
            }
            if (!found)
                this.bucket.add(new Pair<Integer, Integer>(key, value));
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.key.equals(key)) {
                    this.bucket.remove(pair);
                    break;
                }
            }
        }
    }

    public class MyHashMap {
        private int hash;
        private List<Bucket> hashMap; // each element of this list is an object called bucket.
        // each bucket is nothing but a wrapper for linkedlist with object called Pair<U,V>

        /** Initialize your data structure here. */
        public MyHashMap() {
            this.hash= 2069;
            this.hashMap= new ArrayList <Bucket>();
            for (int i=0; i < this.hash; ++i) {
                this.hashMap.add(new Bucket());
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash_key = key % this.hash; // find the hash of the key using key_space contanst.
            this.hashMap.get(hash_key).update(key, value);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
         * for the key
         */
        public int get(int key) {
            int hash_key = key % this.hash;
            return this.hashMap.get(hash_key).get(key);
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash_key = key % this.hash;
            this.hashMap.get(hash_key).remove(key);
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
