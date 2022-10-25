package com.leet.LinkedIn.Hard;
//https://leetcode.com/problems/valid-number/
public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber t = new ValidNumber();
        System.out.println(t.isNumber("005047e+6"));
    }
    public boolean isNumber(String s) {
        boolean seenExponent=false, seenDecimal=false, seenSign=false, seenDigits=false;
        for(int i=0; i<s.length();i++){
            if(i==0 && !Character.isDigit(s.charAt(i)) &&s.charAt(i)!='+'&&s.charAt(i)!='-' &&s.charAt(i)!='.'){
                return false;
            }
            else if(!Character.isDigit(s.charAt(i))){
                if(s.charAt(i)=='e'||s.charAt(i)=='E') {
                    if (seenExponent||!seenDigits) return false;
                    seenExponent=true;
                    seenDigits = false;
                }
                else if(s.charAt(i)=='.'){
                    if(seenDecimal ||seenExponent) return false;
                    seenDecimal=true;
                }
                else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                    if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
                    seenSign=true;
                }
                else{
                    return false;
                }
            }
            else if(Character.isDigit(s.charAt(i))){
                seenDigits=true;
            }
        }
        if(!seenDigits) return false;
        return true;
    }
}
