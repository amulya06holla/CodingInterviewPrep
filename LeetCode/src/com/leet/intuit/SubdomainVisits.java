package com.leet.intuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/subdomain-visit-count
public class SubdomainVisits {
    public List <String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList <>();
        Map <String, Integer> map = new HashMap <>();
        for(int i=0; i<cpdomains.length;i++) {
            String temp ="";
            String[] splits = cpdomains[i].split(" ");
            if(splits.length==2) {
                int count = Integer.parseInt(splits[0]);
                String domain = splits[1];
                String[] domainSplits = domain.split("\\.");
                for(int j=domainSplits.length-1;j>=0; j-- ) {
                    if (temp.isEmpty()) temp=temp+domainSplits[j];
                    else temp=domainSplits[j]+"."+temp;
                    map.put(temp, map.getOrDefault(temp, 0)+count);
                }
            }
        }
        for(Map.Entry entry: map.entrySet()){
            String s = entry.getValue()+" "+entry.getKey();
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        SubdomainVisits sv = new SubdomainVisits();
        String[] input = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = sv.subdomainVisits(input);
        for(int i=0; i<list.size();i++)
            System.out.println(list.get(i));
    }
}
