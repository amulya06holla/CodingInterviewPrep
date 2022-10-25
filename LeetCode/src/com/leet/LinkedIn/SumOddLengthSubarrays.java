package com.leet.LinkedIn;
//https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        SumOddLengthSubarrays sob= new SumOddLengthSubarrays();
        int[] arr = new int[]{1,2};
        sob.sumOddLengthSubarrays(arr);
    }
    public int sumOddLengthSubarrays(int[] arr) {
        int res =0;
        for(int i=0;i<arr.length;i++){
            res = res+arr[i];
            if(i>0)
                arr[i]=arr[i]+arr[i-1];
        }
       // System.out.println(res);
        for(int len =3; len<=arr.length;len=len+2){
            int temp = len-1;
            for(int i=temp; i<arr.length; i=i+1){
                if(i-len<0){
                    res = res+arr[i];
                }else{
                    res = res+arr[i]-arr[i-len];
                }
            }
            //System.out.println("res="+res);
        }
        return res;
    }
}
