package com.interview.solutions;

import java.util.ArrayList;
import java.util.List;

public class DDSSolution {
    public static void main(String[] args) {
        String startTime ="mon 10:55 am";
        String endTime ="mon 11:15 am";
        List <String> output = new ArrayList <>();
        String[] inputStartTime = startTime.split(" ");
        String[] inputEndTime = endTime.split(" ");
        if(inputStartTime.length !=3 || inputEndTime.length!=3) return;
        output = computeValues(inputStartTime, inputEndTime);
    }


    private static List<String> computeValues(String[] inputStartTime, String[] inputEndTime) {
        List<String> output = new ArrayList <>();
            int firstLetterStart = validateDay(inputStartTime[0]);
            int firstLetterEnd = validateDay(inputEndTime[0]);
            if(firstLetterStart==-1 || firstLetterEnd==-1) return null;
            else if(firstLetterStart<firstLetterEnd) return null;

            int startClockTime = validateClockTime(inputStartTime[2]);
            int endClockTime = validateClockTime(inputEndTime[2]);
            if(startClockTime==-1 || endClockTime==-1) return null;

            String[] startTime = validateTime(inputStartTime[1], startClockTime);
            String[] endTime = validateTime(inputEndTime[1], endClockTime);
            if(startTime==null || endTime==null ) return null;

            String c= firstLetterStart+""+startTime[0]+""+startTime[1];
            String e= firstLetterEnd+""+endTime[0]+""+endTime[1];
            while(!c.equals(e)) {
                for(Integer i=Integer.parseInt(startTime[1]); ;i=i+5) {
                    if (i>=60) {
                        int sTime=Integer.parseInt(startTime[0])+1;
                        if (sTime>24) {
                            firstLetterStart=firstLetterStart++;
                        }
                        startTime[0]=Integer.toString(sTime);
                        int d=i-60;
                        i=d;
                    }

                    c=firstLetterStart+""+startTime[0]+""+i;
                    output.add(c);
                    System.out.println(c);
                }
            }
        return output;
    }

    private static String[] validateTime(String s, int clock) {
        String[] t = s.split(":");
        if(t.length!=2) return null;
        int hr = Integer.parseInt(t[0]);
        int sec = Integer.parseInt(t[1]);
        if(hr>12 || hr<0) return null;
        else if(clock==2) hr = hr+12;
        if(sec<0 || sec>59) return null;
        return new String[]{Integer.toString(hr), t[1]};
    }

    private static int validateDay(String s) {
        String[] days = new String[]{"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
        for(int i=0; i<days.length;i++){
            if(days[i].equals(s)){
                return i+1;
            }
        }
        return -1;
    }

    private static int validateClockTime(String s) {
        String[] clocktime = new String[]{"am", "pm"};
        for(int i=0; i<clocktime.length;i++){
            if(clocktime[i].equals(s)){
                return i+1;
            }
        }
        return -1;
    }

}
