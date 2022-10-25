package com.leet.graphs.DijkstrasProblems;

public class DijkstrasAlgorithmImpl {
    /**
     * we need a priorityQueue and pop the elements from it based on the smallest weight.
     * this is because lets say this is the graph given
     *              A---(1)----B
     *              |          |
     *              (3)        (1)
     *              |          |
     *              D----------
     *              |
     *              (1)
     *              |
     *              E
     *  Here lets say we explored all the children of A. A->D is 3, A->B is 2
     *  Now if I do not use priorityQueue, then lets say I explored all children of D.
     *  while I do that, i would add 3+1 and say distance from A->E is 4. although there was other node which was much shorter
     *  A->B->D->E would have given us 1+1+1 = 3.
     *
     *  Basically if we explore any random distance first, we may miss out on shorter distances.
     *
     *  so always explore the nodes which has least weights first.
     *
     */
}
