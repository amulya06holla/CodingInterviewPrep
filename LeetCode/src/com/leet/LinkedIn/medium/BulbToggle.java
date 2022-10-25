package com.leet.LinkedIn.medium;

/**
 * Each bulb is initially switched OFF.
 * After the first round, "every first bulb" (i.e. each bulb) is toggled and thus switched ON.
 * After the second round, every second bulb is toggled.
 * .
 * .
 * .
 * After the ith round, every ith bulb is toggled.
 *
 * So, for example, the 20th bulb is toggled in the following rounds : 1,2,4,5,10,20.
 * The 25th bulb is toggled every 1st,5th and in the 25th round.
 *
 * Notice that the number of times each bulb is toggled is equal to the number of its factors.
 * Also notice that if we toggle a bulb even number of times, it goes back to its original OFF state.
 *
 * Since every number,except perfect squares, has an even number of factors, the number of bulbs in the ON state after n toggles will be equal to the number of perfect squares <= n.
 * https://www.youtube.com/watch?v=7IbWTFOUP1U
 */
public class BulbToggle {
    public int bulbSwitch(int n) {
        //find all perfect squares less than or equal to n
        int count =0;
        for(long i=1;i*i<=n;i++){
            count++;
        }
        return count;
    }
}
