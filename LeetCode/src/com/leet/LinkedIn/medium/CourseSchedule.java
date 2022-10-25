package com.leet.LinkedIn.medium;

import java.util.*;

//https://leetcode.com/problems/course-schedule/solution/
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{ {0,1},
                {1,0}
        };
        int numCourses=2;
        CourseSchedule t = new CourseSchedule();
        System.out.println(t.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap <Integer, ArrayList <Integer>>();
        for(int i=0; i<prerequisites.length;i++){
            map.put(prerequisites[i][1], new ArrayList <>());
            map.put(prerequisites[i][0], new ArrayList <>());
        }
        for(int i=0; i<prerequisites.length;i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];
        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
            if(!topSortUtil(e.getKey(),visited,map))return false;
        }
        return true;
    }

    private boolean topSortUtil(int curr, int[] visited, HashMap<Integer, ArrayList<Integer>> map) {
        if(visited[curr]==2) return true; //all neighbors of src are already visited
        if(visited[curr]==1) return false; //cycle found

        visited[curr]=1; // initially set src as 1
        for(Integer val : map.get(curr)){
            if(!topSortUtil(val,visited,map)) return false;
        }
        visited[curr] = 2; //set 2 when all neighbors of src are visited
        return true;
    }
}
