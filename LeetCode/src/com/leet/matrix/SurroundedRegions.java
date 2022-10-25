package com.leet.matrix;
//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    static int[][] visited = null;
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        solve(grid);
    }
    public static void solve(char[][] board) {
        visited = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if((i-1==0 && board[i-1][j]=='O')){
                    //System.out.println("case1");
                    visited[i-1][j]=1;
                }
                if(i+1==board.length-1 && board[i+1][j]=='O'){
                    //System.out.println("case2");
                    visited[i+1][j]=1;
                }
                if((j-1==0 && board[i][j-1]=='O')){
                   // System.out.println("case3");
                    visited[i][j-1]=1;
                }
                if(j+1==board[i].length-1 && board[i][j+1]=='O'){
                   // System.out.println("case4");
                    visited[i][j+1]=1;
                }
            }

            for(int k=0; k<board.length; k++) {
                for (int l = 0; l < board[k].length; l++) {
                    System.out.print(visited[k][l]+ " ");
                }
                System.out.println();
            }
            System.out.println("*******************");
        }
        System.out.println("------------");
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(visited[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("-----------------");

        for(int i=1; i<board.length-1; i++) {
            for (int j = 1; j < board[i].length-1; j++) {
                if((visited[i-1][j]==1 || visited[i+1][j]==1 || visited[i][j-1]==1 || visited[i][j+1]==1)&& board[i][j]=='O'){
                    System.out.println("i="+i+" j="+j);
                    visited[i][j]=1;
                }
                if(visited[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(visited[i][j]+ " ");
            }
            System.out.println();
        }
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
