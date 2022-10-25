package com.leet.linkedList.medium;
/**
 * To have O(N) algorithm performance, one would need a structure, which provides four operations in O(1) time :
 *      1. Insert the key
 *      2. Get the key and check if the key exists
 *      3. Delete the key
 *      4. Return the first or last added key/ value
 *
 * The first three operations in O(1) time are provided by the standard hashmap, and the forth one - by linked list.
 */

/**
 * There is a structure called ordered dictionary, it combines behind both hashmap and linked list.
 * In Python this structure is called OrderedDict and in Java LinkedHashMap.
 */
//https://leetcode.com/problems/lru-cache/
import java.util.*;

public class LRUCache
{
//    int capacity;
//    Queue <Integer> q=new ArrayDeque <>();//faster than LinkedList//to store the key according to  LRU principal
//    Map <Integer,Integer> map=new HashMap <>();//To store key and value pair
//
//    public LRUCache(int capacity)
//    {
//        this.capacity = capacity;//cache size
//    }
//
//    public int get(int key)
//    {
//        if (map.containsKey(key))
//        {//cache updating
//            q.remove(key);//O(n)
//            q.offer(key);//O(1)
//            return map.get(key);//O(1)
//        }
//        else
//            return -1;//key is npt found
//    }
//
//    public void put(int key, int value)
//    {
//        if(map.containsKey(key)) //if key is present in the map, key has to be searched and deleted
//            // then enqueue the key into the queue, according to LRU principal
//        {
//            q.remove(key);//O(n)//remove the key from the queue
//            q.offer(key);//O(1)//apend at the end of the queue(enqueue)
//            map.put(key,value);//O(1)//overwriting the key value (key is always unique)
//        }
//        else
//        {
//            if(q.size() < capacity)
//                q.offer(key);//inserting the new key into the queue
//            else
//            {//q.size() == capacity
//                map.remove(q.poll());//removing the least recently used key NOTE: FOR THIS TO WORK, WE NEED TO USE LINKEDHASHMAP
//                q.offer(key);//appending the new key to the queue
//            }
//            map.put(key,value);//putting the key value pair
//        }
//    }
int capacity;
    Map <Integer,Integer> map=new LinkedHashMap <>();//To store key and value pair
    public LRUCache(int capacity)
    {
        this.capacity = capacity;//cache size
    }
    public int get(int key)
    {
        if (map.containsKey(key))
        {//cache updating
            int val = map.get(key);
            map.remove(key);//O(1)
            map.put(key,val); //o(1)
            return val;//O(1)
        }
        else
            return -1;//key is npt found
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key)) //if key is present in the map, key has to be searched and deleted
        // then enqueue the key into the queue, according to LRU principal
        {
            map.remove(key);
            map.put(key,value);//O(1)//overwriting the key value (key is always unique)
        }
        else
        {
            map.put(key,value);//putting the key value pair
            if(map.size() > capacity)
                map.remove(map.entrySet().iterator().next().getKey());//removing the least recently used key. The first element will be the least recently used.
            // NOTE: FOR THIS TO WORK, WE NEED TO USE LINKEDHASHMAP
            }

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */