package com.leet.dds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//https://leetcode.com/problems/most-profit-assigning-work
public class MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // convert the inputs into list of list.
        // outer list holds list of inner list. each list of inner list holds values from difficulty and profit.
        List<List <Integer>> workAssignements = new ArrayList<>();
        for(int i=0; i<difficulty.length;i++){
            List <Integer> work = new ArrayList <>();
            work.add(difficulty[i]);
            work.add(profit[i]);
            workAssignements.add(work);
        }
        workAssignements.sort(Comparator.comparingInt(a-> a.get(0)));

        /**
         * the above code can also be written as
         *         List<int[]> workAssignements1 = new ArrayList<>();
         *          for(int i=0; i<difficulty.length;i++){
         *          int[] arr = new int[3];
         *          arr[0]=difficulty[i];
         *          arr[1]=profit[i];
         *          workAssignements1.add(arr);
         *          }
         *          workAssignements1.sort(Comparator.comparingInt(a-> a[0]));
         */
        Arrays.sort(worker); // we need to sort the worker array because lets say worker[0] has difficulty 2,
        // then if array is sorted worker[1] > worker[0] hence difficulty of worker[1] will be greter than 2.
        // implies, we can use whatever is the profit of worker[0] as the min profit which worker[1] can also earn.
        // basically no need to calculate again.

        int maxProfit=0, ans=0, j=0;
        for(int i=0; i<worker.length;i++){
            while(j<worker.length && worker[i]>=workAssignements.get(j).get(0)){
                maxProfit= Math.max(maxProfit, workAssignements.get(j).get(1));
                j++;
            }
            ans = ans+maxProfit;
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxProfitAssignment m = new MaxProfitAssignment();
        int[] difficulty = new int[]{2,4,6,8,10};
        int[] profit = new int[]{10,20,30,40,50};
        int[] worker = new int[]{4,5,6,7};
        System.out.println(m.maxProfitAssignment(difficulty, profit, worker));
    }
}
