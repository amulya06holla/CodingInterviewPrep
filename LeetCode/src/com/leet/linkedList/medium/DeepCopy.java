package com.leet.linkedList.medium;


import com.leet.linkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node temp = head;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node res = new Node(-1);
        Node sentinal = new Node(-1);
        sentinal.next= res;

        while(temp!=null){
            res.next = new Node(temp.val);
            map.put(temp,res.next);
            res = res.next;
            temp = temp.next;
        }
        Node result = sentinal.next.next;
        temp = head;
        while(temp!=null){
            if(temp.random!=null) {
                result.random=map.get(temp.random);
                System.out.println(result.random.val);
            }
            else
                result.random =null;
            System.out.println(result.random.val);
            result = result.next;
            temp=temp.next;
        }
        return sentinal.next.next;
    }

}
