package com.leet.linkedList;

import java.util.*;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(int val){
        this.val = val;
    }
}
public class LinkedListPractise {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{1,-2,3,-3,2};
        ListNode list1 = l.createListFromArray(arr1);
        int arr2[] = new int[]{5,6,4};
        ListNode list2 = l.createListFromArray(arr2);
        l.printNodes(list1);
        System.out.println("===========================================");
      ListNode t= removeZeroSumSublists(list1);
        l.printNodes(t);
    }

    private static ListNode insertAtBegin(ListNode head, int val){
        ListNode temp = new ListNode();
        ListNode n = new ListNode(val);
        n.next=head;
        temp.next=n;
        return temp.next;
    }

    private static ListNode insertAtEnd(ListNode head, int val){
        ListNode temp = head;
        if(temp==null){
            return new ListNode(val);
        }
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        return head;
    }

    private static ListNode insertAfterNode(ListNode head, int val, ListNode node){
        ListNode temp = head;

        while(temp!=null && temp!=node){
            temp = temp.next;
        }
        ListNode newNode = new ListNode(val);
        ListNode t = temp.next.next;
        temp.next = newNode;
        newNode.next=t;
        return head;
    }

    public boolean isEmpty(ListNode node)
    {
        if(node ==null)
            return true;
        return false;
    }

    public int findCountRecursive(ListNode p){
        if(p==null) return 0;
        return 1+findCountRecursive( p.next);
    }

    public boolean searchElementRecursive( int data, ListNode p){
        if(p==null) return false;
        if(p.val==data) return true;
        return searchElementRecursive(p.val, p.next);
    }

    public int deleteFirstNode(ListNode node){
        int deleted =0;
        if( node!=null){
            deleted = (int) node.val;
            node= node.next;
            return deleted;
        }
        return deleted;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinal = new ListNode();
        ListNode temp = new ListNode();
        temp.next=head;
        sentinal.next=temp;
        while(temp!=null && temp.next!=null){
            while(temp.next!=null && temp.next.val==val){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return sentinal.next.next;
    }

    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode sentinal = new ListNode();
        ListNode toAdd = head;
        ListNode toDelete = head;
        sentinal.next=head;
        int add=m, delete=n;
        while(toDelete!=null) {
            while (toDelete!=null&&add!=0) {
                //System.out.println("before" + toAdd.val);
                toAdd=toDelete;
                //System.out.println(toAdd.val);
                toDelete=toDelete.next;
                add=add-1;
            }
            add=m;
            while (toDelete!=null&&delete!=0) {
                toDelete=toDelete.next;
                delete--;
            }
            delete=n;
            toAdd.next=toDelete;
        }

        return sentinal.next;
    }

    public boolean searchElementIterative(int data, ListNode node){
        if(node==null)
            return false;
        ListNode p = node;
        while(p.next!=null && p.next.val!=data){
            p = p.next;
        }
        if(p.next.val==data){ // this is important becasue even after the while loop is completed, we might not have found the val.
            // the loop might have broken due to p==null
           return true;
        }
        return false;
    }

    public void searchElementRecurssive(ListNode n, int data){
        if(n==null){
            System.out.println("not found");
            return;
        }
        if(n.val==data){
            System.out.println("found");
            return;
        }
        searchElementRecurssive(n.next, data);
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public void printReverse(ListNode node){
        if(node==null)
            return;
        if(node.next!=null)
            printReverse(node.next);
        System.out.print(node.val+ "->");
    }

    public boolean isCyclePresent(ListNode node){
        ListNode fast = node;
        ListNode slow = node;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }

    public ListNode cycleStartPoint(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        boolean isCyclePresent=false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                isCyclePresent=true;
                break;
            }
        }
        if(!isCyclePresent) return null; // this check is for knowing if there was a cycle or not. if cycle not present, returning null
        fast = node;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && n!=0){
            fast = fast.next;
            n--;
        }
        if(fast==null){
            slow = slow.next;
            return slow;
        }
        while(fast!=null && fast.next!=null && slow!=null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow!=null && slow.next!=null)
            slow.next= slow.next.next;
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode p1, p2= null;
        while(head!=null){
            p1=head;
            head=p1.next;
            p1.next=p2;
            p2=p1;
        }
        return p2;
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null) return null;

        ListNode odd=head;
        ListNode even = head.next;
        ListNode newEven=even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = newEven;

        return head;
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode fast =head;
        ListNode slow = head;
        Stack<ListNode> s = new Stack<>();
        while(fast!=null){
            s.push(slow);
            if(fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
            }else{
                fast = fast.next;
            }

        }
        while(slow!=null){
            if(!s.isEmpty()&& s.pop().val!=slow.val){
                return false;
            }
            slow = slow.next;
        }
        if(!s.isEmpty()) // checking if stack is empty is important as there were many conditions in the  above to break. so it need not be true.
            return false;
        return true;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinal = new ListNode();
        ListNode res = new ListNode();
        sentinal.next = res;
        int sum =0; int carry=0;
        while(l1!=null || l2!=null){
            int l1val=0; int l2val=0;
            if(l1!=null){
                l1val=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                l2val = l2.val;
                l2=l2.next;
            }
            sum = l1val+l2val +carry;
            carry=0;
            carry=sum/10;
            sum = sum%10;
            res.next = new ListNode(sum);
            res=res.next;
        }
        if(carry!=0) {
            res.next= new ListNode(carry);
            res=res.next;
        }
        return sentinal.next.next;
    }
    //https://leetcode.com/problems/add-two-numbers-ii/
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        l1= reverseList(l1);
        l2= reverseList(l2);
        return reverseList(addTwoNumbers(l1, l2));
    }

    //https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/
    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode sentinal = new ListNode();
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        ListNode temp = head;

        while(temp!=null){
            if(duplicates.containsKey(temp.val)){
               int c = duplicates.get(temp.val);
               duplicates.put(temp.val, c+1);
            }else{
                duplicates.put(temp.val, 1);
            }
            temp = temp.next;
        }
        temp = new ListNode();
        temp.next =head;
        sentinal.next=temp;
        while(temp.next!=null){
            if(duplicates.get(temp.next.val)>1){
                temp.next= temp.next.next;
            }else {
                temp = temp.next;
            }
        }

        return sentinal.next.next;
    }
//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode sentinal = null;
        ListNode temp = head;
        Stack<Integer> s = new Stack<>();
        while(temp!=null){
            if(!s.isEmpty() && Math.abs(s.peek())==Math.abs(temp.val)){
                s.pop();
               // temp = temp.next;
            }else{
                s.push(temp.val);
            }
            temp = temp.next;
        }
        while(!s.isEmpty()){
            ListNode t = sentinal;
            sentinal = new ListNode(s.pop());
            sentinal.next=t;
        }
        return sentinal;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinal = new ListNode();
        ListNode l = new ListNode();
        sentinal.next=l;
        while(l1!=null && l2!=null){
            if( l1.val<=l2.val){
                l.next = l1;
                l1= l1.next;
            }else if( l2.val<=l1.val){
                l.next = l2;
                l2= l2.next;
            }
            l=l.next;
        }
        l.next = l1==null? l2:l1;
        return sentinal.next.next;
    }
//https://leetcode.com/problems/merge-k-sorted-lists
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? 1 : -1;  // we are trying to give the output in ascending order. had it been return o1 < o2 ? 1 : -1; then it is in descending order.
            }
        };

        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp); // do not forget to pass cmp into priority queue. otherwise it will return the data in regular first in first out.
        for(ListNode l : lists){
            if(l!=null){
                q.add(l); // add ALL the elements of ALL the list into the priority queue.
            }
        }
        ListNode sentinal = new ListNode(0);
        ListNode point = sentinal;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return sentinal.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res =new ListNode();
        res.next=head;
        while(head!=null){
            while(head.next!=null && head.val==head.next.val){
                head.next=head.next.next;
            }
            head = head.next;
        }
        return res.next;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(k==0) return head;

        ListNode sentinal = new ListNode(-1);
        ListNode temp = head;
        sentinal.next = head;

        ListNode actualHead = head;
        ListNode newHead = sentinal.next;
        ListNode actualTailEnd = temp;
        ListNode newTailEnd = temp;
        int count =0;
        while(temp!=null){
            actualTailEnd = temp;
            temp=temp.next;
            count++;
        }
        if(count==k || count==1){
            return head;
        }
        while(k>count){
            k=k-count;
        }
        count=count-k;
        if(count==0) return head;
        temp=head;

        while(temp!=null && count!=0){
            count--;
            newTailEnd = temp;
            temp =temp.next;
        }
        newHead=temp;
        newTailEnd.next=null;
        actualTailEnd.next=actualHead;
        sentinal.next= newHead;
        return sentinal.next;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode sentinal = new ListNode();
        sentinal.next = head;
        ListNode prevNode = sentinal;
        while(head!=null && head.next!=null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            ListNode temp = secondNode.next;
            prevNode.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;

            prevNode =firstNode;
            head = firstNode.next;

        }
        return sentinal.next;
    }

    public ListNode partition(ListNode head, int x) {

        ListNode beforeXstart = new ListNode(0);
        ListNode beforeX=beforeXstart;

        ListNode afterXstart =new ListNode(0);
        ListNode afterX=afterXstart;

        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                beforeX.next= temp;
                beforeX = beforeX.next;
            }else{
                afterX.next= temp;
                afterX = afterX.next;
            }
            temp = temp.next;
        }
        afterX.next=null;  // REMEMBER TO DO THIS. OTHERWISE IT CREATES A CYCLE
        if(beforeXstart.next==null) return afterXstart.next;
        beforeX.next = afterXstart.next;
        return beforeXstart.next;
    }

    //https://leetcode.com/problems/sort-list/
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return merge(left, right);
        }

        ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                    tail = tail.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                    tail = tail.next;
                }
            }
            tail.next = (list1 != null) ? list1 : list2;
            return dummyHead.next;
        }

        ListNode getMid(ListNode head) {
            ListNode midPrev = head;
            while (head != null && head.next != null) {
                midPrev = midPrev.next;
                head = head.next.next;
            }
            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;
        }

        //https://leetcode.com/problems/reorder-list/submissions/
    public void reorderList(ListNode head) {
        ListNode middle = getMid(head);
        ListNode mid = reverseList(middle);
        ListNode temp = head;
        while(temp!=null && temp.next!=null&& mid!=null){
            ListNode t = temp.next;
            temp.next=mid;
            mid=mid.next;
            temp = temp.next;
            temp.next = t;
            temp = temp.next;
        }
    }



}
