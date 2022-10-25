package com.leet.Apple.easy;

import java.sql.SQLOutput;
import java.util.Arrays;

public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        SumOddLengthSubarrays t = new SumOddLengthSubarrays();
        int[] arr = new int[]{1,4,2,5,3};
        System.out.println(t.sumOddLengthSubarrays(arr));
    }
    public int sumOddLengthSubarrays(int[] arr) {
        int length = arr.length;
        int sum = 0;

        //Storing the prefix sum of array
        int prefixSum[] = new int[length];
        prefixSum[0] = arr[0];
        for(int i=1;i<length;i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
       // System.out.println(Arrays.toString(prefixSum));
        sum = prefixSum[length-1];
       // System.out.println(sum);
        if(length<3) return sum;
        int window=3;
        while(window<=length){
            int windowSum =0;
            for(int i=window-1; i<length; i++){
                if(i-(window)>=0){
                    windowSum = windowSum+(prefixSum[i]-prefixSum[i-window]);
                }else{
                    windowSum = windowSum+prefixSum[i];
                }
                //System.out.println("windowSum= "+windowSum);
            }

            sum = windowSum +sum;
            window=window+2;
        }

        return sum;
    }
}
