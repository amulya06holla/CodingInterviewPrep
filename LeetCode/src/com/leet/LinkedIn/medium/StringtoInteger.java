package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/string-to-integer-atoi/
public class StringtoInteger {
    public int myAtoi(String s) {
        long res = 0;
        boolean isNegative = false;
        int sign = 0; // need to have this so that we disregard "+-+-09". this type of example.
        // and this sign cant be boolean. because we cant understand it when we have -ve.
        // //we would not know if the sign is already assigned and it is negative or the sign hasnt been updated atall.

        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i) == ' ' && sign == 0) {
                continue;
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                res = res*10 + (s.charAt(i) - '0');
                sign = 1;

                if(res > Integer.MAX_VALUE)
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            else if(s.charAt(i) == '+' && sign == 0) {
                isNegative = false;
                sign = 1;
            }
            else if(s.charAt(i) == '-' && sign == 0) {
                isNegative = true;
                sign = 1;
            }
            else
                break;
        }

        return isNegative ? -(int)res : (int)res;
    }
}
