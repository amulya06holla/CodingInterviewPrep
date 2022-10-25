package com.leet.dynamicProgramming;

public class FindMaxForm {
        public static void main(String[] args) {
            String[] strs = new String[]{"10","0001","111001","1","0"};
            System.out.println(findMaxForm(strs, 5,3));
        }
        public static int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0) {
                return 0;
            }

            int[][] dp = new int[m + 1][n + 1];

            for (String s: strs) {
                int num0 = 0;
                int num1 = 0;
                int[] count = count(s);
                num0 = count[0];
                num1 = count[1];
                for (int i = m; i >= 0; i--) {
                    for (int j = n; j >= 0; j--) {
                        int noPick = dp[i][j];
                        int pick = 0;
                        if (i - num0 >= 0 && j - num1 >= 0) {
                            pick = dp[i - num0][j - num1] + 1;
                        }
                        dp[i][j] = Math.max(pick, noPick);

                    }
                }
            }

            return dp[m][n];
        }

        private static int[] count(String s){
            int[] mns = new int[2];
            for(int i=0; i<s.length();i++){
                if(s.charAt(i)=='0')
                    mns[0]++;
                else
                    mns[1]++;
            }
            return mns;
        }
}
