package com.ds.lists;

import java.util.Hashtable;
import java.util.Stack;


class ListNode {
    int data;
    ListNode next;

    public ListNode(int obj){
        data = obj;
        next = null;
    }

}

public class MyLinkedLists {
    ListNode first =null;
    ListNode pointer2 = null;
    ListNode pointer1 = null;
    static MyLinkedLists listWithoutDups;
    static MyLinkedLists addedlist = new MyLinkedLists();

    public boolean isEmpty()
    {
        if(first ==null){
            return true;
        }
        return false;
    }

    // insert new nodes at first, end and at a particular node
    public void insertFirst(MyLinkedLists list, int obj)
    {
        if(isEmpty()){
            //System.out.println("adding first node");
            list.first = new ListNode(obj);

            list.first.next=null;
        }
        else{
            ListNode n = new ListNode(obj);
            n.next = list.first;

            list.first =n;
        }

    }

    public void inserEnd(int obj){
        if(isEmpty()){
            //System.out.println("adding first node");
            first = new ListNode(obj);
            first.next=null;
        }
        else{
            ListNode p= first;
            ListNode n = new ListNode(obj);
            while(p.next!=null){
                p=p.next;
            }
            p.next = n;
            n.next = null;
        }
    }

    public void insertAtNode(int ref, int obj){
        ListNode p= first;
        ListNode n = new ListNode(obj);
        while(p.data != ref){
            p=p.next;
        }
        p.next = n;
        n= p;

    }

    public int findCountRecursive(ListNode p){
        if(p==null) return 0;
        return 1+findCountRecursive( p.next);
    }

    public boolean searchElementRecursive( int data, ListNode p){
        if(p==null) return false;
        if(p.data==data) return true;
        return searchElementRecursive(p.data, p.next);

    }

    public int deleteFirstNode(){
        int deleted =0;
        if( first!=null){
            deleted = (int) first.data;
            first= first.next;
            return deleted;
        }
        return deleted;
    }

    // given a node which needs to be delted, delete the node without traversing the entire list
    public void deleteNodeSpecific(int data){
        ListNode p = first;
        if(p==null){
            System.out.println("Linkedlist is empty");
            return;
        }
        System.out.println("data ="+data);
        while(p.next==null&& p.next.data!=data){
            System.out.println("p.dATA=" +p.data);
            p=p.next;
        }
        if(p.next.data==data){
            if(p == first){
                p.next = p.next.next;
                first = p;
            }
            p.next = p.next.next;
        }
        else{
            System.out.println("no such data found");
        }

    }

    public void deleteList(ListNode n){
        while(n!=null){
            deleteList(n.next);
            System.out.println("deleting node "+n.data);
            n = null;
        }
    }

    public void traverseList(MyLinkedLists list, ListNode n)
    {
        ListNode p;
		/*		if (n==null)
			p = list.first;
		else */
        p= n;
        //System.out.println("first data= "+list.first.data);
        while(p!=null){
            System.out.print(p.data +"->");
            p=p.next;
        }
        System.out.println("null");
    }

    public void searchElementIterative(int data){
        if(first==null)
            System.out.println("element not found");
        ListNode p = first;
        while(p.next!=null && p.next.data!=data){
            p = p.next;
        }
        if(p.next.data==data){
            System.out.println("data found");
        }else{
            System.out.println("data not found");
        }
    }

    public void searchElementRecurssive(ListNode n, int data){
        if(n==null){
            System.out.println("not found");
            return;
        }
        if(n.data==data){
            System.out.println("found");
            return;
        }
        searchElementRecurssive(n.next, data);
    }
    public void printReverse(ListNode listNode){
        //System.out.println("node.data= "+node.data);
        if(listNode ==null)
            return;
        if(listNode.next!=null)
            printReverse(listNode.next);
        System.out.print(listNode.data+ "->");
    }

    public int getSizeLinkedList(MyLinkedLists list){
        ListNode p = list.first;
        int count =0;
        while(p!=null){
            //System.out.print(p.data +"->");
            p=p.next;
            count++;
        }
        //System.out.println("count=" +count);
        return count;
    }

    public void reverseListIterative(ListNode current, MyLinkedLists reversedList){
        reversedList.insertFirst(reversedList,current.data);
        if(current.next!=null)
            reverseListIterative(current.next, reversedList);

    }

    //take two pointers. one fast and one slow. the point when it ends is the mid point.
    // this gives the middle of a linkedlist in single traversal
    public void findMiddlePos() {
        ListNode pointerOne = first;
        ListNode pointerTwo = first;
        if(pointerOne.next==null)
            System.out.println("is null");
        if(pointerOne.next.next==null)
            System.out.println("next next is null");


        while(pointerOne.next!=null && pointerOne.next.next!= null ) {
            System.out.println("inside while "+ pointerOne.next.next.data);
            pointerOne = pointerOne.next.next;
            pointerTwo = pointerTwo.next;

        }
        System.out.println("The middle element is : "+pointerTwo.data);

    }


    // floyd's cycle loop detection method
    public boolean hasLoop() {
        ListNode slow, fast; // create two references.
        if(first == null) // list does not exist..so no loop either.
            return false;
        slow = fast = first; // make both refer to the start of the list.
        while(true) {
            slow = slow.next;          // 1 hop.
            if(fast.next != null)
                fast = fast.next.next; // 2 hops.
            else
                return false;          // next node null => no loop.
            if(slow == null || fast == null) // if either hits null..no loop.
                return false;
            if(slow == fast) // if the two ever meet...we must have a loop.
                return true;
        }
    }


    /*
     * this method uses a stack and 2 pointers. This method has time complexity of o(n) and space comp also of o(n)
     */
    public boolean checkPalindrome(){
        System.out.println("check palindrome");
        Stack<Integer> s = new Stack<Integer>();
        //int pos = 0;
        ListNode pointerOne = first;
        ListNode pointerTwo = first;
        System.out.println("first valu push="+pointerOne.data);
        s.push(pointerOne.data);
        while(pointerOne.next.next != null) {
            pointerOne = pointerOne.next.next;
            pointerTwo = pointerTwo.next;
            System.out.println("push data=" +pointerTwo.data);
            s.push(pointerTwo.data);

        }
        while(pointerTwo.next!=null){
            pointerTwo = pointerTwo.next;
            System.out.println(pointerTwo.data);
            if(s.peek() == pointerTwo.data){
                System.out.println(s.pop());

            }
        }

        if(s.empty()){
            return true;
        }
        return false;
    }


	/*
	 * Other way of finding if the given list is palindrome or not is using reversing of list.
	 * this takes only o(n) time comp and o(1) space compl.
	 * 1) Get the middle of the linked list.
	 * if fast.next!=null ==> odd number of elements. At this point, take out the mid element and make the elements even.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Construct the original linked list by reversing the second half again and attaching it back to the first half

Also for even case, we need to get the mid value also as a part of second half.
while in case of odd number of elements, mid value shouldnt be part of second half

http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
	 */

    public void checkpal(){

    }

    public void deleteDups (){
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        ListNode n = first;
        ListNode previous = null;
        int count =0;
        while(n!=null){
            if(table.contains(n.data)){
                previous.next = n.next;
            } else {
                table.put(count,n.data);
                count++;
                previous = n;
            }
            n = n.next;
        }
        listWithoutDups = new MyLinkedLists();
        for(int i =0; i<table.size(); i++){
            listWithoutDups.inserEnd((int) table.get(i));
        }
    }

    public static void deleteDupsUnsortedList (ListNode n)
    {
        Hashtable table = new Hashtable();
        ListNode previous = null;
        while(n!=null){
            if(table.containsKey(n.data)){
                System.out.println("if case");
                previous.next = n.next;
                if(previous.next!=null)
                    System.out.println("prev next data =" +previous.next.data);
            } else {
                System.out.println("else case");
                table.put(n.data, true);
                previous = n;
                System.out.println("prev data =" +previous.data);
            }
            n = n.next;
            if(n!=null)
                System.out.println("n data ="+n.data);
        }
    }

    // get the nth node from the beginning of a linkedlist
    public ListNode getNthNode(int count){
        int c=0;
        if(first==null){
            return null;
        }
        ListNode p = first;
        while(p.next!=null && c!=count){
            p = p.next;
            c++;
        }
        //System.out.println(p.data);
        return p;
    }

    public int getNumberofNodes(){
        int c=0;
        if(first==null){
            return 0;
        }
        ListNode p = first;
        while(p!=null){
            p = p.next;
            ++c;
        }
        //System.out.println(p.data);
        return c;
    }

    // get the nth node from the end of the linkedlist
    // this can be done by finding the len of the linkedlist and then get the (len -n+1)th element
    // but with the above time complexity will be more. Hence
    // take a ref pointer and another pointer. move the first pointer till n, now move both the pointers till the frst pointer reaches the end
    // now at this point, whatever second pointer is pointing, thats the nth node from end

    public void getNthNodefromEnd(int posEnd){
        int pos = 1;
        //int posStart = 1;
        ListNode pointerOne = first;
        ListNode pointerTwo = first;
        while(pointerOne.next!= null && pos!=posEnd) {
            pointerOne = pointerOne.next; // increment only first pointer till it reaches that nth position
            pos++;
        }
        while(pointerOne.next!=null){ // after reaching nth pos, increment both the pointers till first one becomes null
            pointerOne = pointerOne.next;
            pointerTwo=pointerTwo.next;
            //posStart++;
        }
        System.out.println("The nth element from end is : "+pointerTwo.data);
    }


    // find union and intersection: do merge sorts on two lists and do intersect or union.
    // the above method will have o(mlogm + nlogn) time complexity.

    // below is the method to find the INTERSECTION POINT of two linkedlists
    //using difference in length of two linkedlists

    /*
     * 1) Get count of the nodes in first list, let count be c1.
2) Get count of the nodes in second list, let count be c2.
3) Get the difference of counts d = abs(c1 – c2)
4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
5) Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
     */
    public void findIntersectingNode(MyLinkedLists listBig, MyLinkedLists listsmall){
        int diffInSize = listBig.getSizeLinkedList(listBig) - listsmall.getSizeLinkedList(listsmall);
        int count = 0;


    }

    /*
     * reverse the linked list using iteration . for any clarrification, refer fig
     * F:\study\reversealinkedlist.jpg
     *
     */

    public void reverse()
    {
        ListNode head = first;
        ListNode pointer1 = null;
        ListNode pointer2 = head.next;

        while(head.next!=null){
            head.next = pointer1;
            pointer1 = head;
            head = pointer2;
            System.out.println("head data ="+head.data);
            pointer2=pointer2.next;

        }
        head.next = pointer1;
        first = head;

    }


    public void reverse1(){
        ListNode head = first;
        ListNode pointer1 = null;
        ListNode pointer2 = null;

        while(head.next!=null){
            pointer2 = head.next;
            head.next=pointer1;
            pointer1 = head;
            head = pointer2;
        }
        first=head;
        head.next = pointer1;
    }

    public ListNode reverseKgroup(ListNode ref, int k, int iterator_while){
        //System.out.println("inside reverseKgroup");
        ListNode head = ref;
        //System.out.println("current="+head.data);
        ListNode pointer2 = null;
        ListNode pointer1 = null;
        int count =0;
        int  iterator_inside =0;
        iterator_while++;
        while(count<k && head!=null){
            //System.out.println("inside count data="+head.data);
            pointer2 = head.next;
            head.next = pointer1;
            pointer1 = head;
            head = pointer2;
            iterator_inside++;

            if(iterator_inside==k && iterator_while==1)
                first = pointer1;
            count++;
        }
        //first = head;
        //head.next = pointer1;
        if(pointer2!=null){
            //System.out.println("next.data=" +pointer2.data);
            //System.out.println("first next data = "+first.next.data);
            ref.next = reverseKgroup(pointer2, k , iterator_while);
            //System.out.println("first next data = "+ref.next.data);
        }
        else{
            //System.out.println("its not in if case");
        }

        return pointer1;
    }


	/*public Node reverseKGroups(Node n, int k){
		System.out.println("reverseGroups");
		Node head =n;
		//System.out.println("head ="+head.data);
		Node pointer1 = null;
		Node pointer2 = head.next;
		//System.out.println("pointer2 data="+pointer2.data);
		int count=0;
		while(head.next!=null && count<k){
			//System.out.println("count="+count);
			head.next = pointer1;
			pointer1= head;
			head = pointer2;
			//System.out.println("new head ="+head.data);
			pointer2= pointer2.next;
			count++;
			//if(pointer2!=null)
			//System.out.println("pointer2.next ="+pointer2.data);
		}
		head.next = pointer1;
		first = head;
		//if(head!=null)
		//System.out.println("!!head ="+head.data);

		if(pointer2!=null)
			System.out.println("!!pointer2.next ="+pointer2.data);
		if(pointer2!=null && head.next!=null){
			System.out.println("inside if");
		n.next= reverseKGroups(pointer2, k);
		}
		//while(head.next!=null){
			//reverseKGroups(pointer2, k);
		//}
		//head.next = pointer1;
		//first = head;

		//head.next = pointer1;
		//first = head;
		return pointer1;
	}*/


    public ListNode Merge2SortdLists(ListNode a, ListNode b){
        ListNode result =null;
        if(a==null){
            return b;
        }
        if(b== null){
            return a;
        }
        if(a.data<=b.data){
            result =a;
            result.next = Merge2SortdLists(a.next, b);
        }else{
            result = b;
            result.next = Merge2SortdLists(a, b.next);
        }
        System.out.println(result.data);
        return result;
    }

    public ListNode MergeSort(ListNode first)
    {
        // the below step is to divide the list into two seperate list.
        // this is giving the middle value of the list each time
        System.out.println("calling mergesort");
        if (first == null || first.next == null)
            return first;

        ListNode a = first;
        System.out.println("a= "+a.data);
        ListNode b = first.next;
        while ((b != null) && (b.next != null))
        {
            first = first.next;
            b = (b.next).next;
        }
        b = first.next; // assigning the middle value to b everytime.
        System.out.println("b ="+b.data);
        first.next = null;
        return Merge2SortdLists(MergeSort(a), MergeSort(b));
    }

    /**
     * method to detect loop, find the starting point of the loop and delete the loop
     */
    public void detectLoopDelete(){
        ListNode slow, fast, start;
        fast = slow = first;

        //PART I - Detect if a loop exists
        while (true)
        {
            // fast will always fall off the end of the list if it is linear
            if (fast == null || fast.next == null)
            {
                // no loop
                return;
            }
            else if (fast == slow || fast.next == slow)
            {
                // detected a loop
                break;
            }
            else
            {
                fast = fast.next.next; // move 2 nodes at at time
                slow = slow.next; // move 1 node at a time

                System.out.println("fast data =" +fast.data +"slow data ="+slow.data);
            }
        }

        //PART II - Identify the node that is the start of the loop
        fast = first; //reset one of the references to head of list

        //until both the references are one short of the common element which is the start of the loop
        while(fast.next != slow.next)
        {
            fast = fast.next;
            slow = slow.next;
        }

        start = fast.next;
        System.out.println("start = "+start.data);

        //PART III - Eliminate the loop by setting the 'next' pointer
        //of the last element to null
        fast = start;
        while(fast.next != start)
        {
            fast = fast.next;
        }

        fast.next = null; //break the loop
    }

    public void rotateList(int k){
        if(first ==null)
            return;
        ListNode p = first; // keep two pointers for ref.
        ListNode ref = first;
        int count=0;
        while(p.next!=null && count<k){
            p = p.next;
            count++; // till count is k, traverse and make p move to next
        }
        ListNode temp =p; // now at this point mark temp pointer as p.
        while(p.next!=null){
            p = p.next;
        } // then move p till end of the list
        first =temp.next; // make temp next value as start of list
        System.out.println("first value= "+first.data);
        p.next = ref; // mKE THE pointer of end to point to the first
        temp.next = null; // and make next of tempp as null
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

    private void addSameSizeList(ListNode first1, ListNode first2) {
        // TODO Auto-generated method stub
        if(first1==null && first2==null)
            return;

        int carry=0;
        addSameSizeList(first1.next, first2.next);
        int sum = carry + first1.data+ first2.data;
        carry = sum/10;
        if(sum<10)
            System.out.println(sum);
        else{
            sum = sum%10;
            System.out.println(sum);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyLinkedLists ll = new MyLinkedLists();
        MyLinkedLists l2 = new MyLinkedLists();
        MyLinkedLists l3 = new MyLinkedLists();
        MyLinkedLists lreverse = new MyLinkedLists();
        MyLinkedLists listsmall = new MyLinkedLists();
        ll.inserEnd(2);
        ll.inserEnd(4);
        ll.inserEnd(3);
        ll.inserEnd(1);
        ll.inserEnd(15);
        ll.inserEnd(16);

        l2.inserEnd(10);
        l2.inserEnd(9);
        l2.inserEnd(12);
        l3.inserEnd(ll.Merge2SortdLists(ll.first, l2.first).data);
        l3.traverseList(l3, l3.first);
/*		ll.traverseList(ll, ll.first);
		System.out.println(ll.getNumberofNodes());
		System.out.println(ll.findCountRecursive( ll.first));*/
    }

}
