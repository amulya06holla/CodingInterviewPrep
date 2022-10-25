package com.leet.Oracle.medium;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        String res = ""; int maxLength=0, start=0;
        if(s.length()==1) return s;

        for(int i=1; i<s.length(); i++){
            //for even lengths
            int low = i-1;
            int high =i+1;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }
            ++low; --high;
            if(s.charAt(low) == s.charAt(high) && high - low + 1 > maxLength) {
                start = low;
                maxLength = high - low + 1;
            }

            low = i-1;
            high =i;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }

            ++low; --high;
            if(s.charAt(low) == s.charAt(high) && high - low + 1 > maxLength) {
                start = low;
                maxLength = high - low + 1;
            }
        }
        res= s.substring(start, start + maxLength);
        return res;
    }
}
