package com.leet.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestElements {
    public static void main(String[] args) {
            int[] arr = new int[]{0,0,1,2,3,3,4,7,7,8};
            findClosestElements(arr, 3, 5);
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int[] arrres = new int[arr.length];
        int temp =k;
        for(int i=0; i<arr.length; i++) {
            int size = 0;
            if (k != 0) {
                res.add(arr[i]);
                if(arr[i]>x) arrres[i]=arr[i]-x;
                else
                    arrres[i] = x-arr[i];
                k--;
            }
            else{
                if(arr[i]>x)
                    arrres[i]=arr[i]-x;
                else
                    arrres[i] = x-arr[i];
                if(arrres[i]<arrres[i-temp]){
                    res.remove(0);
                    res.add(arr[i]);
                }
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(Arrays.toString(arrres));
        return res;
    }
}
