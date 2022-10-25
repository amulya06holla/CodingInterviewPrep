package com.leet.LinkedIn;
//https://leetcode.com/problems/rotate-string/

//CHECK SOLUTION IN LEET!!!!!!!!!!!!!!!!!
public class RotateString {
    public static void main(String[] args) {
        RotateString t = new RotateString();
        System.out.println(t.rotateString("abcd", "cdaf"));
    }
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        if(s.length()!=goal.length()) return false;
        return (s+s).contains(goal);
    }
}
