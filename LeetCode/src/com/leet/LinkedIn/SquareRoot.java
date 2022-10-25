package com.leet.LinkedIn;
//https://leetcode.com/problems/sqrtx/solution/
public class SquareRoot {
    public int mySqrt(int x) {
        if(x<2) return x;
        int left=2, right=x/2, mid=0;
        long ans =0;
        while(left<=right){
            mid = left + (right - left) / 2;
            ans = (long)mid*mid;  //NOTE: MAKING IT LONG IS VERY MUCH REQUIRED. OTHERWISE IT FAILS FOR BORDER CASES. EG: IF X= 2147395599
            if(ans==x) return mid;
            else if (ans > x) right = mid - 1;
            else if (ans < x) left = mid + 1;
        }
        return right;
    }
}
