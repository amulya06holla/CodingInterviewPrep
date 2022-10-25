package com.leet.July;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//https://leetcode.com/problems/shuffle-an-array/
//Fisher-Yates algorithm
public class ShuffleAnArray {
    private int[] array;
    private int[] original;
    private Random rand = new Random();

    public ShuffleAnArray(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
    }
    public static void main(String[] args) {

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> auxList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            auxList.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(auxList.size());
            array[i] = auxList.get(removeIdx);
            auxList.remove(removeIdx);
        }
        return array;

    }
}
