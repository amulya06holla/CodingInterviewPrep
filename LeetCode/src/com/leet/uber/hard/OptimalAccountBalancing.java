package com.leet.uber.hard;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        // Key: person's ID   Value: person's balance after calculation
        // {1 : -5} means person 1 should get $5
        // {2 : 10} means person 2 should pay $10
        Map <Integer, Integer> map = new HashMap <>();
        for (int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) - trans[2]); // the person whoes id is at trans[0] has GIVEN the money - trans[2] to trans[1]. hence we are subracting
            map.put(trans[1], map.getOrDefault(trans[1], 0) + trans[2]);// the person whoes id is at trans[0] has TAKEN the money - trans[2] to trans[1]. hence we are adding.
        }

        // Since after we get those amount of balance, person's ID does not affect the final result
        int n = map.size(), i = 0;
        int[] balance = new int[n];
        for (int k : map.keySet()) {
            balance[i++] = map.get(k); // we are putting all the debts of each person(money which should be given or taken in total ) into an array.
        }

        return dfs(0, balance);
    }

    private int dfs(int personId, int[] balance) {
        if (personId == balance.length) return 0;                  // all person's balance are cleared ==> requires 0 operation
        if (balance[personId] == 0) return dfs(personId + 1, balance);  // curr person has balance 0 ==> skip curr person

        int res = Integer.MAX_VALUE;

        int currDebt = balance[personId];

        for (int i = personId+1; i < balance.length; i++) {
            /* Key step 1 :
                if either 1. balance[personId] & balance[i] are both positive or negative
                          2. balance[personId] | balance[i] has 0 balance
                then any transaction between them is meaningless
            */
            if (balance[i] * currDebt >= 0) continue;

            /* Key Step 2 :
                transfer all balance from balance[personId] to balance[i], i.e.,
                after the transaction, balance[personId] = 0

            */
            balance[i] = balance[i]+currDebt;
            res = Math.min(res, 1 + dfs(personId + 1, balance));
            balance[i] = balance[i] -currDebt; // BACKTRACKING
        }
        return res;
    }
}
