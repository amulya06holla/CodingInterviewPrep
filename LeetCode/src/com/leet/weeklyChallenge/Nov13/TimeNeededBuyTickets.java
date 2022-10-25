package com.leet.weeklyChallenge.Nov13;

import java.util.Arrays;
import java.util.LinkedList;

public class TimeNeededBuyTickets {
    public static void main(String[] args) {
        TimeNeededBuyTickets t = new TimeNeededBuyTickets();
        int[] tickets = new int[]{1,2,3,4,5};
        System.out.println(t.timeRequiredToBuy2(tickets, 3));
    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res =0;
        while(tickets[k]!=0) {
            for(int i=0; i<tickets.length; i++) {
                if (tickets[i]>0) {
                    tickets[i]=tickets[i]-1;
                    res++;
                }
                if (i==k&&tickets[i]==0) {
                    return res;
                }
            }
        }
        return res;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        int res =0;
        for(int i=0; i<tickets.length;i++){
            res = res+ Math.min(tickets[k], tickets[i]);
        }
        return res;
    }
}
