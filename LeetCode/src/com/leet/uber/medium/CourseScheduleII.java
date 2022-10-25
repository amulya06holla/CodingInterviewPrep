package com.leet.uber.medium;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDepth = new int[numCourses];
        HashMap <Integer, List <Integer>> map= new HashMap <Integer, List <Integer>>();
        for(int i=0; i<prerequisites.length;i++){
            int dest = prerequisites[i][0];
            int source = prerequisites[i][1];
            List <Integer> list = map.getOrDefault(source, new ArrayList <>());
            list.add(dest);
            map.put(source,list);
            inDepth[dest]= inDepth[dest]+1;
        }
        int count=0;
        Queue<Integer> q = new LinkedList <>();
        for(int i=0; i<numCourses;i++){
            if(inDepth[i]==0)
                q.offer(i);
        }
        int[] topologicalSort = new int[numCourses];
        int k=0;
        while(!q.isEmpty()) {
            int t=q.poll();
            topologicalSort[k++]=t;
            if (map.containsKey(t)) {
                for (Integer neighbor : map.get(t)) {
                    inDepth[neighbor]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (inDepth[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        return k==numCourses? topologicalSort: new int[0];
    }
}
