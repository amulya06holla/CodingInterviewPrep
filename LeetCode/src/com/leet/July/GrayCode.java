package com.leet.July;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {

    }

    public List<Integer> grayCode(int n) {
        if (n <= 0)
            return null;

        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        arr.add("0");
        arr.add("1");


        int i, j;
        for (i = 2; i < (1 << n); i = i << 1) {
            for (j = i - 1; j >= 0; j--)
                arr.add(arr.get(j));

            for (j = 0; j < i; j++)
                arr.set(j, "0" + arr.get(j));

            for (j = i; j < 2 * i; j++)
                arr.set(j, "1" + arr.get(j));
        }

        // print contents of arr[]
        for (i = 0; i < arr.size(); i++)
            res.add(Integer.parseInt(arr.get(i), 2));

        return res;
    }
}
