package com.leet.linkedList;

public class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{1,2,3,4,5};
        ListNode list1 = l.createListFromArray(arr1);
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtTail(3);
        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(1,5);
//        myLinkedList.deleteAtIndex(5);
        System.out.println(myLinkedList.get(1));
        myLinkedList.printVals();
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int count =-1;
        ListNode node =head;
        while((count+1)!=index){
            node =node.next;
            count++;
        }
        return node.val;
    }

    public void printVals() {
        ListNode node =head;
        while(node.next!=null){
            node =node.next;
            System.out.print(node.val+"->");
        }
        System.out.println();
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode n = new ListNode(val);
        ListNode temp = head.next;
        head.next=n;
        n.next=temp;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode temp = head; int count =-1;
        while(temp.next!=null && count!=(index-1)){
            temp = temp.next;
            count++;
        }
        ListNode n = new ListNode(val);
        ListNode inter = temp.next;
        temp.next = n;
        n.next=inter;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode temp = head; int count =-1;
        while(temp.next!=null && count!=(index-1)){
            temp = temp.next;
            count++;
        }
        ListNode inter = null;
        if(temp.next!=null) {
            inter = temp.next.next;
            temp.next = inter;
        }

    }
}
