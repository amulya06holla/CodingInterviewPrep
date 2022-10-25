package com.leet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = new int[]{2,3,5,1,3};
        int extraCandies=3;
        System.out.println(Arrays.toString(kidsWithCandies(candies, extraCandies).toArray()));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<Boolean>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<candies.length;i++){
            if(candies[i]>max){
                max=candies[i];
            }
        }
        for(int i=0; i<candies.length;i++){
            if((candies[i]+extraCandies) >=max){
                res.add(true);
            }else
                res.add(false);
        }
            return res;
    }
}
