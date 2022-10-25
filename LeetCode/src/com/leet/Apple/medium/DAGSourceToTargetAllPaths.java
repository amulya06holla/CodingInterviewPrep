package com.leet.Apple.medium;

import java.util.*;

//https://leetcode.com/problems/all-paths-from-source-to-target/
public class DAGSourceToTargetAllPaths {
    public List<List <Integer>> allPathsSourceTarget(int[][] graph) {
        List<List <Integer>> res = new ArrayList <>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfsSearch(graph, 0, res, path);
        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1); // backtracking
        }
    }


// https://www.youtube.com/watch?v=CYnvDzMprdc - BFS approach
    class Solution {
    protected List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int startPosition = 0;
        int goal = graph.length - 1;
        Queue <List<Integer>> queue = new LinkedList <>();
        queue.add(Arrays.asList(startPosition)); // need to add 0 as a list as it is the start position.

        while (!queue.isEmpty()) {
            List<Integer> integerList = queue.poll();

            int graphIndex = integerList.get(integerList.size() - 1);
            if (graphIndex == goal) { // whatever is the last element in the list which we polled from queue, that should match with our end goal
                result.add(integerList);
            }

            // if it is not the goal node, then we have to do bfs for its connected nodes.
            int[] graphArray = graph[graphIndex];
            for (int j : graphArray) {
                List<Integer> innerList = new ArrayList<>(integerList);
                innerList.add(j);
                queue.add(innerList);
            }

        }

        return result;
    }
}
    }

