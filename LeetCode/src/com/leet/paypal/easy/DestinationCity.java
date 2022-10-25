package com.leet.paypal.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    public String destCity(List<List <String>> paths) {
        String res = "";
        Map <String, List<String>> map = new HashMap <>();
        for(List<String> list: paths){
            List<String> l = map.getOrDefault(list.get(0), new LinkedList <>());
            l.add(list.get(1));
            map.put(list.get(0), l);
            map.put(list.get(1), map.getOrDefault(list.get(1), new LinkedList <>()));
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            if(entry.getValue().isEmpty()){
                res = entry.getKey();
            }
        }
        return res;
    }
}
