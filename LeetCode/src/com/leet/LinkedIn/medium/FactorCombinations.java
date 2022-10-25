package com.leet.LinkedIn.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/factor-combinations/
public class FactorCombinations {
    public List<List <Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList <>();
        if(n<=3) return res;

        List<Integer> curComb = new ArrayList<>();
        dfs(res, n, 2, curComb);
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int start, List<Integer> curComb){
        if(n==1 && !curComb.isEmpty()){
                res.add(new ArrayList<>(curComb)); // doing a deep copy. If not, the values will be missed during recurssion
                return;
        }
        for(int i=start; i*i<=n; i++){//be careful! i*i<=n, otherwise 8=2*2*2 will be avoided
            if(n % i == 0){                         //eg: 8/2 = 4 8%2=0
                curComb.add(i);                     //then add 2
                curComb.add(n/i);                   //and add 4 as well
                dfs(res, 1, i, curComb);            //set n as 1->add 2,4 into result list
                curComb.remove(curComb.size()-1); // backtracking
                dfs(res, n/i, i, curComb);          //continue calculate on remaining: 4
                curComb.remove(curComb.size()-1);
            }
        }
    }
}
