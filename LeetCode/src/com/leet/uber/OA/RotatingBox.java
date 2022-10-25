package com.leet.uber.OA;
//https://leetcode.com/problems/rotating-the-box/
//https://leetcode.com/problems/rotating-the-box/discuss/1210113/simplest-explanation-with-java-solution
public class RotatingBox {
    public char[][] rotateTheBox(char[][] box) {
        int r = box.length, c = box[0].length;
        char[][] result = new char[c][r];

        for(int i = 0; i<r; ++i){ // NOTE:::::::::ALWAYS MOVE FROM FIRST TO LAST COLUMN
            int empty = c-1; // initally let the empty position be pointing to the end of column.
            for(int j = c-1; j>=0; --j){ //NOTE:::::::: ALWAYS MOVE FROM LAST TO FRONT COLUMN
                if(box[i][j] == '*'){ // move the empty pointer to j-1 as soon as u see an obstacle at j
                    empty = j-1;
                }
                if(box[i][j] == '#'){ // if you see a stone, move the stone to empty location and then empty the current position
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    --empty; // everytime wu encounter a stone, decrement the pointer of the empty place.
                }
            }
        }

        for(int i = 0; i<r; ++i){
            for(int j = c-1; j>=0; --j)
                result[j][r-i-1] = box[i][j];
        }

        return result;
    }
}
