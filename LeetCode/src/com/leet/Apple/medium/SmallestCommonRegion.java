package com.leet.Apple.medium;

import java.util.*;

//https://leetcode.com/problems/smallest-common-region/
public class SmallestCommonRegion {
    // solved using LCA 3 type. when you have parent node and child node.. that type.
    public String findSmallestRegion(List<List <String>> regions, String region1, String region2) {
        Map <String, String> parents = new HashMap <>();
        Set <String> ancestryHistory = new HashSet <>();

        for (List<String> region : regions)
            for (int i = 1; i < region.size(); ++i)
                parents.put(region.get(i), region.get(0));

        while (region1 != null) {
            ancestryHistory.add(region1);
            region1 = parents.get(region1);
        }

        while (!ancestryHistory.contains(region2))
            region2 = parents.get(region2);
        return region2;
    }
}
