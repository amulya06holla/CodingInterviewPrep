package com.leet.amazon;

public class RemoveVowels {
    public static void main(String[] args) {
        System.out.println(removeVowels("asseiou"));
    }

    public static String removeVowels(String s) {
        String res ="";
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)!='a'&&s.charAt(i)!='e'&& s.charAt(i)!='i'&& s.charAt(i)!='o'&& s.charAt(i)!='u' ){
                res= res+s.charAt(i);
            }
        }
        return res;
    }
}
