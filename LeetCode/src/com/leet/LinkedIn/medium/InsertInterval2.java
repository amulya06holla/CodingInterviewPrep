package com.leet.LinkedIn.medium;

import java.util.TreeMap;

public class InsertInterval2 {
        //Treemap :  Treemap is sorted according to the natural ordering of its keys ,
        // or by a Comparator provided at map creation time, depending on which constructor is used
        TreeMap <Integer, Integer> intervals = new TreeMap<>();

        /**
         * Adds the new interval to the list of intervals and merges the new list if possible
         */
        public void addRange(int left, int right) {
            Integer start = intervals.floorKey(left); //The floorKey() method is used to return the greatest key less than or equal to given key from the parameter.
            Integer end = intervals.floorKey(right);
            if(start != null && intervals.get(start) >= left){
                left = start;
            }
            if(end != null && intervals.get(end) > right){
                right = intervals.get(end);
            }
            intervals.put(left, right);
            intervals.subMap(left, false, right, true).clear(); //submap() method in Java is used to return the part or portion of the map defined by the specified range of keys in the parameter.

            System.out.println(intervals);
        }

        /**
         * Computes the sum of the difference between the each disjoint interval in the lnterval list
         */
        int getTotalIntervalCoverage(){
            int size = 0;
            for(int key : intervals.keySet()){
                size+= intervals.get(key) - key;
            }

            return size;
        }

        public static void main(String[] args) {
            InsertInterval2 task = new InsertInterval2();

            task.addRange(3,6);
            System.out.println(task.getTotalIntervalCoverage()); //3

            task.addRange(8,9);
            System.out.println(task.getTotalIntervalCoverage()); //4


            task.addRange(1,5);
            System.out.println(task.getTotalIntervalCoverage()); //6

        }

}
