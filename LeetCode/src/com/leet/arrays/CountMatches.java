package com.leet.arrays;

import java.util.*;

public class CountMatches {
    public static void main(String[] args) {
        String ruleKey="color";
        String ruleValue="silver";
        List<String> list = new ArrayList<String>();
        String[][] arr = new String[][]{{"phone","blue","pixel"},{"computer","silver","lenovo"},{"phone","gold","iphone"}};
        List<List<String>> items = twoDArrayToList(arr);
        System.out.println(countMatches(items,ruleKey,ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res=0;
        Map<String, Integer> mapType = new HashMap<String, Integer>();
        Map<String, Integer> mapColor = new HashMap<String, Integer>();
        Map<String, Integer> mapName = new HashMap<String, Integer>();
        List<Map<String,Integer>> listMap = new ArrayList<Map<String,Integer>>();
        listMap.add(mapType);
        listMap.add(mapColor);
        listMap.add(mapName);
        for(List<String> item: items){
          for(int i=0; i<item.size();i++){
                  if (listMap.get(i).containsKey(item.get(i))) {
                      listMap.get(i).put(item.get(i), listMap.get(i).get(item.get(i)) + 1);
                  } else {
                      listMap.get(i).put(item.get(i), 1);
                  }
          }

        }
        for(int i=0; i<listMap.size();i++){
            if(listMap.get(i).containsKey(ruleKey)){
                if(listMap.get(i).get(ruleKey).equals(ruleValue)){
                    res++;
                }
            }
        }
        return res;
    }

    public static <String> List<List<String>> twoDArrayToList(String[][] twoDArray) {

        List<List<String>> listRes = new ArrayList<List<String>>();
        for (String[] array : twoDArray) {
            List<String> list = new ArrayList<String>();
            list.addAll(Arrays.asList(array));
            listRes.add(list);
        }
        return listRes;
    }


}
