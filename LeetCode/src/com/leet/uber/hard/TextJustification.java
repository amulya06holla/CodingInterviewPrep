package com.leet.uber.hard;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification/
public class TextJustification {
    public static void main(String[] args) {

    }
    public List <String> fullJustify(String[] words, int maxWidth) {
        List <String> res = new ArrayList <>();
        int currWordsLen=0, i=0,j=0, n=words.length;
        while(i<n){
            currWordsLen =words[i].length();
            j=i+1;
            while(j<n && (currWordsLen+words[j].length()+(j-i-1))<maxWidth){
                currWordsLen = currWordsLen+words[j].length();
                j++;
            }

            // left align if it is the only word in the currLine or if it is the last word in the array.
            if(j>=n || (j-i)==1){
                res.add(leftAlign(words, currWordsLen, i, j, maxWidth));
            }else{
                // else middle allign
                res.add(middleAlign(words, currWordsLen, i, j, maxWidth));
            }
            i=j; // move i till j
        }

        return res;
    }

    private String middleAlign(String[] words, int currWordsLen, int i, int j, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int actualSpacesNeeded = j-i-1;
        int availSpaces = maxWidth - (currWordsLen);
        int extraSpaces = availSpaces % actualSpacesNeeded;
        int newActualSpaces = availSpaces/actualSpacesNeeded;
        sb.append(words[i]);
        for(int k=i+1; k<j;k++) {
            int temp=newActualSpaces;
            if (extraSpaces!=0) {
                extraSpaces--;
                temp=temp+1;
            }
            sb.append(" ".repeat(temp)).append(words[k]);
        }
        return sb.toString();
    }

    private String leftAlign(String[] words, int currWordsLen, int i, int j, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int actualSpacesNeeded = j-i-1;
        int extraSpaces = maxWidth - (currWordsLen+actualSpacesNeeded);
        sb.append(words[i]);
        for(int k=i+1;k<j;k++){
            sb.append(" ").append(words[k]);
        }
        if(extraSpaces>0)
            sb.append(" ".repeat(extraSpaces));
        return sb.toString();
    }
    
}
