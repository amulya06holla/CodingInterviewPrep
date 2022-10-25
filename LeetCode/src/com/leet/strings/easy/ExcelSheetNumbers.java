package com.leet.strings.easy;
//https://leetcode.com/problems/excel-sheet-column-number/
public class ExcelSheetNumbers {
    public static void main(String[] args) {
        ExcelSheetNumbers en = new ExcelSheetNumbers();
        System.out.println(en.titleToNumber("FXSHRXW"));
        System.out.println(en.convertToTitle(2147483647));
    }
    public int titleToNumber(String columnTitle) {
        int res =0;
        int len =columnTitle.length();
        for(int i=0; i<columnTitle.length();i++){
            int v  = (columnTitle.charAt(i) - 'A')+1;
            if(len==1) res =res+v;
            else
            {
                int temp =(int) Math.pow(26,len-1);
                res = res+temp*v;
                len--;
            }

        }
        return res;
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int letter;
        while(columnNumber>0){
            letter = (columnNumber-1) % 26;
            sb.append((char)(letter+'A'));
            columnNumber = (columnNumber-1) / 26;
            System.out.println("cn= "+columnNumber);
        }
        return sb.reverse().toString();
    }

}
