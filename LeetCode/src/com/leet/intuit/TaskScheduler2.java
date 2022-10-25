package com.leet.intuit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TaskScheduler2 {
    public long taskSchedulerII(int[] tasks, int space) {
        long res=0;
        Map<Integer, Long> loc = new HashMap <>();
        int i=0;
        while(i<tasks.length){
            if(loc.containsKey(tasks[i]) && loc.get(tasks[i])>res)
                res = loc.get(tasks[i]);
            res++;
            loc.put(tasks[i], (res+space));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        TaskScheduler2 ts = new TaskScheduler2();
        int[] tasks = new int[]{1,2,1,2,3,1};
        int space=3;
        System.out.println(ts.taskSchedulerII(tasks, space));
    }
}
