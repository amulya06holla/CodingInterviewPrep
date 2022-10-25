package com.leet.uber.medium;
//https://leetcode.com/problems/minesweeper/
//Time and Space Complexity will be O(m*n) where m is the number of rows in the board & n is the number of columns in the board
public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        //error check
        if(board==null || board.length==0) return board;

        int x = click[0];
        int y = click[1];

        //if a mine is revealed
        if( board[x][y]=='M') {
            board[x][y] = 'X';
            return board; //game over
        }

        return dfs(board, x, y);

    }

    private char[][] dfs(char[][] board, int x, int y){
        //check boundaries
        if(x>=board.length|| x<0 || y>=board[0].length || y<0 || board[x][y]!='E') return board;

        //if the neighbors have mines mark the cell with the number and return else continue exploring
        int mines = numAjacentMines(board, x, y);
        if(mines>0){
            board[x][y] = (char) (mines + '0');
            return board;
        }
        else{
            board[x][y] = 'B';

            //dfs neighbors
            dfs(board, x+1, y);
            dfs(board, x+1, y+1);
            dfs(board, x+1, y-1);
            dfs(board, x, y+1);
            dfs(board, x, y-1);
            dfs(board, x-1, y);
            dfs(board, x-1, y+1);
            dfs(board, x-1, y-1);
        }

        return board;
    }

    //helper function that counts the mines in adjacent directions
    private int numAjacentMines(char[][] board, int x, int y){
        int count = 0;
        int rowLen = board.length;
        int colLen = board[0].length;

        if(isValid(rowLen,colLen, x+1,y) && board[x+1][y]=='M') count++;
        if(isValid(rowLen,colLen, x+1,y+1) && board[x+1][y+1]=='M') count++;
        if(isValid(rowLen,colLen, x+1,y-1) && board[x+1][y-1]=='M') count++;
        if(isValid(rowLen,colLen, x,y+1) && board[x][y+1]=='M') count++;
        if(isValid(rowLen,colLen, x,y-1) && board[x][y-1]=='M') count++;
        if(isValid(rowLen,colLen, x-1,y) && board[x-1][y]=='M') count++;
        if(isValid(rowLen,colLen, x-1,y+1) && board[x-1][y+1]=='M') count++;
        if(isValid(rowLen,colLen, x-1,y-1) && board[x-1][y-1]=='M') count++;

        return count;

    }

    //checks if the dirs are within bounds
    private boolean isValid(int rowLen, int colLen, int x, int y){
        if(x>=rowLen|| x<0 || y>=colLen || y<0) return false;
        else return true;
    }
}
