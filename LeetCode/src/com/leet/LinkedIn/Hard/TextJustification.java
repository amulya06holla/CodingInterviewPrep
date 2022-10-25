package com.leet.LinkedIn.Hard;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification/
//TC: O(lines*maxWidth)
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List <String> res = new ArrayList <>();
        int i=0, n = words.length;
        while(i<n){
            int j=i+1; // always have the pointer pointing to the one next to i.
            int currlineLen = words[i].length();

            // while loop to detect how many more words can be fit into this line
            while(j<n && (currlineLen+words[j].length()+ j-i-1)<maxWidth){
                // eg: in the sentence "what must be" number of words is j-i = 3 and number of spaces is j-i-1 =2;
                currlineLen = currlineLen+words[j].length(); // adding more words to the same line if it hasnt reached the maxLen;
                j++;
            }
            // we come out of the above loop when we have got the words that are supposed to be on single line.
            //which is nothing but j-i number of words.
            // now we have to see if it is the last line or if there is only one word in the line. if yes, leftalign else middle align.
            if(j>=n || j-i==1){
                // leftAlign
                res.add(leftAlign(words, maxWidth, i,j, currlineLen));
            }else{
                res.add(middleAlign(words, maxWidth, i, j, currlineLen));
            }

            i=j; // now move i till j and start the process all over again till i<n.
        }
        return res;
    }

    private String middleAlign(String[] words, int maxWidth, int i, int j, int currlineLen) {
        StringBuilder res = new StringBuilder();
        int diff = maxWidth - currlineLen;
        int actualSpaceNeeded = j-i-1;
        int newActualSpaces = diff / actualSpaceNeeded;
        int remainingSpaces = diff % actualSpaceNeeded;

        res.append(words[i]);
        for(int k=i+1; k<j;k++){
            int temp = newActualSpaces;
            if(remainingSpaces!=0){
                temp = temp+1;
                remainingSpaces--;
            }

            res.append(" ".repeat(temp)).append(words[k]);
        }
        return res.toString();
    }

    private String leftAlign(String[] words, int maxWidth, int i, int j, int currlineLen) {
        StringBuilder res = new StringBuilder();
        int diff = maxWidth - currlineLen;
        int actualSpaceNeeded = j-i-1;
        int remainingSpaces = diff-actualSpaceNeeded;
        res.append(words[i]);
        // now run a loop to append all other words till j.
        for(int k=i+1; k<j;k++){
            res.append(" ").append(words[k]);
        }
        if(remainingSpaces>0){
            res.append(" ".repeat(remainingSpaces));
        }
        return res.toString();
    }
}
