package com.leet.LinkedIn.Hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=0PSB9y8ehbk
//https://leetcode.com/problems/lfu-cache/

public class LFUCache {
    private final int CAPACITY;
    private int minFreq;
    private Map<Integer, ListNode> nodeMap;  // <Key, ListNode>
    private Map<Integer, DoublyLinkedList> freqMap;  // <Frequency, DoublyLinkedList>

    public LFUCache(int capacity) {
        CAPACITY = capacity;
        minFreq = 0;
        nodeMap = new HashMap<>(capacity << 1);
        freqMap = new HashMap<>(capacity << 1);
    }

    public int get(int key) {
        ListNode node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (CAPACITY == 0) return;
        ListNode node = nodeMap.get(key);
        if (node != null) {
            node.val = value;
            update(node);
        } else {
            node = new ListNode(key, value);
            // If nodeMap.size() == CAPACITY, remove the last node in the min frequency list
            if (nodeMap.size() == CAPACITY) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                ListNode removedNode = minFreqList.removeLast();
                nodeMap.remove(removedNode.key);
            }
            // Update the minFreq to 1, since we add a new node.
            minFreq = 1;  // new added node.freq = 1
            DoublyLinkedList list = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
            if (list.isEmpty()) {
                freqMap.put(node.freq, list);  // node.freq = 1
            }
            list.addFirst(node);
            nodeMap.put(key, node);
        }
    }

    // Update the node:
    // 1. remove the node from the list before updated its freq
    // 2. add the node to the head of the new list after updated its freq.
    private void update(ListNode node) {
        DoublyLinkedList oldList = freqMap.get(node.freq);
        oldList.remove(node);
        if (node.freq == minFreq && oldList.isEmpty()) {
            freqMap.remove(node.freq);
            minFreq++;
        }
        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        if (newList.isEmpty()) {
            freqMap.put(node.freq, newList);
        }
        newList.addFirst(node);
    }

    class DoublyLinkedList {
        ListNode head, tail;
        DoublyLinkedList() {
            head = new ListNode(-1, -1);
            tail = new ListNode(-2, -2);
            head.next = tail;
            tail.prev = head;
        }

        boolean isEmpty() {
            return head.next == tail;
        }

        void addFirst(ListNode node) {
            ListNode next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }

        ListNode removeLast() {
            return remove(tail.prev);
        }

        ListNode remove(ListNode node) {
            if (isEmpty()) throw new RuntimeException("Error: the list is empty");
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
            return node;
        }
    }

    class ListNode {
        int key, val, freq;
        ListNode next, prev;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
}
