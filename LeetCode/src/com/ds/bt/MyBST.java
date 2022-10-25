package com.ds.bt;


import java.util.*;


class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int newData) {
        left = null;
        right = null;
        data = newData;
    }
}

class Bst
{
    static TreeNode root;
    ArrayList arr=new ArrayList();
    ArrayList path= new ArrayList();
    Stack stk=new Stack();
    int lh=0,rh=0;
    int max=0;
    public static TreeMap<Integer, Integer> ht = new TreeMap<>();;
    public static TreeMap<Integer, ArrayList> treeMap = new TreeMap<>();;

    public static HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer,  LinkedList<Integer>>();
    public static int  level;
    public ArrayList<Integer> al;

    public Bst()
    {
        root=null;
    }

    /**
     *  Tree constructions
     * @param treeNode
     * @param value
     */
    // construct tree from the values
    public void insert(TreeNode treeNode, int value)
    {
        if (value < treeNode.data)
        {
            if (treeNode.left != null) { // insert to left if the value is lesser than root
                insert(treeNode.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of "
                        + treeNode.data);
                treeNode.left = new TreeNode(value);
            }
        }
        else if (value > treeNode.data)
        {
            if (treeNode.right != null) {
                insert(treeNode.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + treeNode.data);
                treeNode.right = new TreeNode(value);
            }
        }

    }

    public void insertVal(TreeNode treeNode, int value)
    {
        if(treeNode==null)
            treeNode = new TreeNode(value);
        else if(treeNode.data>value){
            insertVal(treeNode.left,value);
        }else{
            insertVal(treeNode.right, value);
        }
    }


    /* Delete the specified node in a tree
     * for expl:
     * http://javabypatel.blogspot.in/2015/08/delete-a-node-from-binary-search-tree-in-java.html
     * for code:
     * http://quiz.geeksforgeeks.org/binary-search-tree-set-2-delete/
     */
    public TreeNode deleteNodeTree(TreeNode treeNode, int value)
    {
        //if the given tree is empty or if we donot get the specified node
        if(treeNode ==null){
            return null;
        }

        System.out.println("node data="+ treeNode.data);
        if(value< treeNode.data){
            treeNode.left = deleteNodeTree(treeNode.left, value); // assigining node.left with whatever node is obtained after deleting the specified node.
        }
        else if(value> treeNode.data){
            treeNode.right = deleteNodeTree(treeNode.right, value);
        }
        else
        {
            if(treeNode.left==null){
                return treeNode.right; // if the node doesnt have any left child then after deleting this node, it must be replaced with right child.

            }else if(treeNode.right==null){
                return treeNode.left;// if the node doesnt have any right child then after deleting this node it must be replaced with left child.
            }
            else{ // this case represents the tree where both right and left child are present.
                System.out.println("finding minvalue");
                treeNode.data = minvalue(treeNode.right); // find the minimum value on the right subtree
                System.out.println("calling delete"+ treeNode.data);
                treeNode.right = deleteNodeTree(treeNode.right, treeNode.data); // keep replacing the value till the end of node is reached.
            }
        }
        return treeNode;
    }

    private int minvalue(TreeNode treeNode){
        while(treeNode.left!=null){
            treeNode = treeNode.left;
        }
        return treeNode.data;
    }

    // checks if the given tree is BST or not
    //http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    public boolean isBST(TreeNode n, int min, int max){

        if (n==null)
            return true;

        if(n.data< min || n.data > max){
            return false;
        }
        return isBST(n.left, min, n.data-1) && isBST(n.right, n.data+1, max);
    }


    // construct a tree from a given sorted array elements
    public void sortedArrayToBST(int[] num) {
        TreeNode n = buildTree(num, 0, num.length-1);
        levelOrder(n);
    }

    public TreeNode buildTree(int[] num, int start, int end) {
        //System.out.println("build tree");
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        System.out.println("root data=" +root.data);
        root.left = buildTree(num, start, mid-1);
        root.right = buildTree(num, mid+1, end);

        return root;
    }


    /**
     * traversals of tree: inorder, preorder, postorder, level order,
     * spiral level order, reverser level order
     */
    //inorder
    public ArrayList printInOrder(TreeNode treeNode)
    {
        if (treeNode != null) {
            printInOrder(treeNode.left);
            System.out.print( treeNode.data);
            System.out.print(" ");
            //Store in an array
            arr.add(treeNode.data);
            printInOrder(treeNode.right);
        }
        return arr;
    }

    public void printPreorder(TreeNode treeNode){
        if (treeNode != null) {

            //System.out.println("  Traversed " + node.data);
            //Store in an array
            System.out.print(treeNode.data);
            System.out.print(" ");
            printPreorder(treeNode.left);
            printPreorder(treeNode.right);
        }
    }

    public void preOrderWithoutRecursion(TreeNode treeNode)
    {
        while(true)
        {
            while(treeNode !=null)
            {
                System.out.print(treeNode.data+" ");
                stk.push(treeNode);
                treeNode = treeNode.left;
            }

            if(stk.empty())
                break;

            treeNode =((TreeNode)stk.peek()).right;
            stk.pop();
        }
        System.out.println();
    }


    //postorder
    public void printPostOrder(TreeNode treeNode){
        if (treeNode != null) {
            printPostOrder(treeNode.left);
            printPostOrder(treeNode.right);
            System.out.print(treeNode.data);
            System.out.print(" ");
        }
    }

    public static List<Integer> postOrderTraversalStack(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;

        res.add(root.data);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.data); // this solution is same as
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }


    //levelorder
    public void levelOrder(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            System.out.print(treeNode.data);
            System.out.print(" ");
            if (treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null){
                queue.offer(treeNode.right);

            }
        }
    }

    public void levelOrderLevelByLevel(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        while (true) {
            if(queue.isEmpty()) break; // break the loop if the queue is empty
            int count = queue.size();

            while(count >0){		// another while loop. breaking condition is count must become 0.
                treeNode = queue.poll();
                System.out.print(treeNode.data);
                System.out.print(" ");

                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);

                count--; // dont forget to decrease the count.
            }
            System.out.println(); // this will add a next line after every level.
        }
    }

    // reverese levelorder
    public void reverseLevelOrder(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            System.out.print(treeNode.data);
            System.out.print(" ");
            if (treeNode.right != null){
                queue.offer(treeNode.right);
            }
            if (treeNode.left != null){
                queue.offer(treeNode.left);

            }
        }
    }

    public void connectNodeAtSameLevel(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        queue.offer(null);
        while (true) {
            treeNode = queue.poll();
            if(treeNode !=null){
                System.out.print(treeNode.data);
                System.out.print(" ");
            }
            else{
                System.out.print("null");
                System.out.println(" ");
            }
            if(treeNode !=null){
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);

                }
            }
            else if(!queue.isEmpty()){
                queue.offer(null);
            }
            else{
                break;
            }
        }
    }


    public void minLevelLeafNode(TreeNode n){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> list = new LinkedList<Integer>();
        queue.offer(n);
        int currentLevel=1;
        list.add(currentLevel);
        int count =0;

        while (!queue.isEmpty()){
            n = queue.poll();
            currentLevel = list.poll();
            if (n.left != null){
                queue.offer(n.left);
                count = currentLevel+1;
                list.add(count);
            }
            if (n.right != null){
                queue.offer(n.right);
                count = currentLevel+1;
                list.add(count);
            }

            if(n.left ==null && n.right==null){
                System.out.println("leaf node =" +n.data +" level =" +currentLevel);
                break;
            }
        }

    }


    public void printNodesAtSpecifiedLevel(TreeNode n, int level)
    {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> list = new LinkedList<Integer>();
        queue.offer(n);
        int currentLevel=1;
        list.add(currentLevel);
        int count =0;
        while (!queue.isEmpty()){
            n = queue.poll();
            currentLevel = list.poll();
            //System.out.println(currentLevel);
            if (n.left != null){
                queue.offer(n.left);
                count = currentLevel+1;
                list.add(count);
            }
            if (n.right != null){
                queue.offer(n.right);
                count = currentLevel+1;
                list.add(count);
            }

            if(currentLevel==level){
                System.out.println(n.data);

            }
        }

    }


    //levelorder spiral

    // takes o(n) time and space complexity. recursive method of doing same will take o(n^2) time complexity
    public void levelOrderSpiral(TreeNode treeNode){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(treeNode);
        while (!s1.empty() || !s2.empty()) // we need this while loop bcz lets say S2 had elements and S2 loop is done.
        // but during S2 loop, new elmenets got added to S1. how to print those? so we need this while loop.
        {
            // Print nodes of current level from s1 and push nodes of
            // next level to s2
            while (!s1.empty())
            {
                treeNode = s1.pop();
                System.out.println(treeNode.data);
                // ******* push right before left is pushed
                if(treeNode.right!=null)
                    s2.push(treeNode.right);
                if(treeNode.left!=null)
                    s2.push(treeNode.left);

            }

            while(!s2.empty()){
                treeNode = s2.pop();
                System.out.println(treeNode.data);
                //*********** push left before pushing right
                if(treeNode.left!=null)
                    s1.push(treeNode.left);
                if(treeNode.right!=null)
                    s1.push(treeNode.right);
            }
        }
    }



    //Determines the number of nodes present in the tree
    public int size(TreeNode treeNode) {
        if(treeNode !=null)
            System.out.println("Node data = " + treeNode.data);
        if (treeNode == null){
            System.out.println("node is null");
            return(0);
        }
        else {
			/*System.out.println("calling left node =" +node.data);
			int left = size(node.left);
			System.out.println("calling right node= "+node.data);
			int right = size(node.right);
			System.out.println("left val =" +left+ "right val=" +right);
			System.out.println("returning sum = "+(left+right+1));
			return left+right+1;*/
            return(size(treeNode.left) + 1 + size(treeNode.right));
        }
    }

    // determines the height of the tree constructed
    public int height (TreeNode treeNode)
    {
        if (treeNode == null)
            return 0;
        return 1 + Math.max(height (treeNode.left), height (treeNode.right));
    }

    //diameter of a tree is the max number of nodes between any two leaf nodes
    // this can be via root node or not via root node also
    public int diametre(TreeNode treeNode)
    {
        if(treeNode ==null)
            return 0;
        else
        {
            return Math.max( (height(treeNode.left)+height(treeNode.right)+1), Math.max( diametre(treeNode.left), diametre(treeNode.right) ) );
        }
    }


    // find all the nodes at the distance of K above root node
    public void kDistanceAboveNode(TreeNode root, int data, int k) {
        System.out.println("distance of a node");
        int level = getlevel(data, root);
        int total_lev = level - k;
        kDistanceKfromRootNode(root,k);
    }

    // print all the nodes which are at k distance from root
    public void kDistanceKfromRootNode(TreeNode root, int k) {
        if (root == null)
            return ;
        if (k == 0) {
            System.out.println("Kth distance above node = "+root.data);
        }
        else{
            kDistanceKfromRootNode(root.left,  k-1);
            kDistanceKfromRootNode(root.right, k-1);
        }

    }

    // print nodes that are at k distance from leaf nodes
    public void KdistancefromLeafNodes(TreeNode treeNode, ArrayList path, int k){
        if(treeNode ==null)
        {
            return;
        }
        path.add(treeNode.data);

        if(treeNode.left==null && treeNode.right==null)
        {
            int i=path.size()-1-k; // here we are subracting total number of elements in that row - distance from the leaf node.
            System.out.println(path.get(i));
        }
        else
        {
            KdistancefromLeafNodes(treeNode.left,new ArrayList(path), k);
            KdistancefromLeafNodes(treeNode.right,new ArrayList(path), k);
        }
    }

    // print all the nodes that are at a distance K from given node
    public void kdistancefromNode(TreeNode n, int k, TreeNode root)
    {
        System.out.println("kdistance from node = "+n.data );
        int lev = getlevel(n.data, root);
        System.out.println("lev = "+lev);
        int totalLevel = k+lev;
        System.out.println("total level ="+totalLevel);
        kDistanceKfromRootNode(root, totalLevel);
    }

    public void findDistanceBtwnTwoNodes(TreeNode a, TreeNode b){
        // distance(a, root) + distance(b, root) - 2* distance(root, lca)
    }

    public int getlevel(int data, TreeNode root){
        return getLevelOfNode(data, root, 1);
    }


    public int getLevelOfNode(int n, TreeNode root, int level){
        if(root == null)
            return 0;

        if(root.data == n){
            return level;
        }
		/*
		 * This method will search for the element in left subtree. if it has a found then it returns
		 * else searches in right sub tree
		int downlevel = getLevelOfNode(n, root.left, level+1);
		if(downlevel!=0)
			return downlevel;

		else
			return getLevelOfNode(n, root.right, level+1);*/
        // in short the above one can be written as
        return getLevelOfNode(n, root.left, level+1)| getLevelOfNode(n, root.right, level+1);
    }


    //counts the number of leaf nodes in the tree
    public int countleafnode (TreeNode treeNode){

        if(treeNode ==null){
            return 0;
        }
        if(treeNode.left==null && treeNode.right==null ){
            return 1;
        }
        else
            return countleafnode(treeNode.left) + countleafnode(treeNode.right);
    }

    // print all the leaf nodes
    public void printLeafNodes (TreeNode treeNode)
    {

        if(treeNode ==null){
            return;
        }
        if(treeNode.left==null && treeNode.right==null ){
            System.out.println(treeNode.data);
        }
        else
            printLeafNodes(treeNode.left);
        printLeafNodes(treeNode.right);
    }

    //print all root to leaf node paths
    public void printAllRootToLeafPaths(TreeNode treeNode, ArrayList path)
    {
        if(treeNode ==null)
        {
            return;
        }
        path.add(treeNode.data);

        if(treeNode.left==null && treeNode.right==null)
        {
            System.out.println(path);
            int sum=0;
            for(int i=0;i<path.size();i++)
                sum= sum + (int)path.get(i);
            System.out.println(sum);
            return;
        }
        else
        {
            printAllRootToLeafPaths(treeNode.left,new ArrayList(path));
            printAllRootToLeafPaths(treeNode.right,new ArrayList(path));
        }
    }


    public void  rootToLeafSum(int val, TreeNode treeNode){
        if(treeNode ==null){
            return;
        }
        val = val+ treeNode.data;
        if(treeNode.left==null && treeNode.right==null){
            System.out.println(val);
        }else{
            rootToLeafSum(val, treeNode.left);
            rootToLeafSum(val, treeNode.right);
        }
    }

    // prints the max sum from root to leaf
    public int maxRootToLeafSum(TreeNode treeNode)
    {
        if(treeNode ==null)
            return 0;
        return Math.max( maxRootToLeafSum(treeNode.left) , maxRootToLeafSum(treeNode.right) ) + treeNode.data ;
    }

    // prints mirror of a tree
    public void mirror(TreeNode treeNode)
    {
        if (treeNode ==null)
            return;
        else
        {
            TreeNode temp;

            /* do the subtrees */
            mirror(treeNode.left);
            mirror(treeNode.right);

            /* swap the pointers in this node */
            temp        = treeNode.left;
            treeNode.left  = treeNode.right;
            treeNode.right = temp;
        }
    }

    //find an element path from root in a tree using DFS logic
    public TreeNode finddfs(TreeNode treeNode, int target) {
        if(treeNode == null || treeNode.data == target) {
            System.out.println(treeNode.data);
            return treeNode;
        }
        if(treeNode.data > target) {
            System.out.println(treeNode.data);
            return finddfs(treeNode.left, target);
        } else {
            System.out.println(treeNode.data);
            return finddfs(treeNode.right, target);
        }
    }


    // find lowest common ancestor of t1 and t2 in a BST
    public TreeNode findLca(TreeNode treeNode, int t1, int t2)
    {
        if(treeNode == null) {
            return null;
        }
        if(treeNode.data > t2 && treeNode.data > t1) { // if both are lesser than node data. hence use and operand
            // both targets are left
            return findLca(treeNode.left, t1, t2);
        } else if (treeNode.data < t2 && treeNode.data < t1) {
            // both targets are right
            return findLca(treeNode.right, t1, t2);
        } else {
            // either we are diverging or both targets are equal
            // in both cases so we've found the LCA
            // check for actual existence of targets here, if you like
            return treeNode;
        }
    }

    // find the lowest common ancestor of t1 and t2 in a BT

    public TreeNode findLCABT(TreeNode treeNode, int t1, int t2){
        if(treeNode ==null)
            return null;
        if(treeNode.data==t1 || treeNode.data ==t2) // use "OR" operand if either one of them are equal to data.
            // both cannot be equal to node data. hence use "OR operand".
            return treeNode;

        TreeNode lca_left = findLCABT(treeNode.left, t1, t2);
        TreeNode lca_right = findLCABT(treeNode.right, t1, t2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (lca_left!=null && lca_right!=null)
            return treeNode;
        else{
            // else check which is not null. the one which is not null has both the target values
            if(lca_left!=null)
                return lca_left;
            else
                return lca_right;
        }
    }

    // construct BST from inorder and postorder arrays given
    //http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/

    /**
     * the idea here is, in postorder, the last element will be the root element of tree
     * in inorder, find this root value and now the elements present in the left of the root element are the elements of left of root
     * and the elemtns present to the right of this node will be the right side elements of the root
     *
     */

    public TreeNode convertInorderPostOrderBST(int arrIn[], int arrPost[]){
        int inStart = 0;
        int inEnd = arrIn.length-1;
        int postStart =0;
        int postEnd = arrPost.length-1;

        return buildTreeInPost(arrIn, inStart, inEnd, arrPost, postStart, postEnd);
    }

    public TreeNode buildTreeInPost(int arrIn[], int inStart, int inEnd, int arrPost[], int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = arrPost[postEnd];
        TreeNode root = new TreeNode(rootValue); // make the last element of postorder array as root

        int k=0;
        for(int i=0; i< arrIn.length; i++)
        {
            if(arrIn[i]==rootValue)
            {
                k = i; // find out the rootnode position in inorder array
                break;
            }
        }
        // build left side of the root node.
        // start will be inStart while end will be K-1
        root.left = buildTreeInPost(arrIn, inStart, k-1, arrPost, postStart, postStart+k-(inStart+1));
        // Becuase k is not the length, it is need to -(inStart+1) to get the length
        root.right = buildTreeInPost(arrIn, k+1, inEnd, arrPost, postStart+k-inStart, postEnd-1);
        // postStart+k-inStart = postStart+k-(inStart+1) +1

        return root;
    }


    //convert an inroder and preorder aray into bst

    public TreeNode buildTreeInPre(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootVal = pre[preStart]; // first element in the preorder traversal array will be the root element
        int rootIndex = 0;

        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == rootVal){
                rootIndex = i; // get the index of root elemnt in inroder array
                break;
            }
        }

        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeInPre(pre, preStart+1, preStart+len, in, inStart, rootIndex-1);
        root.right = buildTreeInPre(pre, preStart+len+1, preEnd, in, rootIndex+1, inEnd);

        return root;
    }



    // find difference in even and odd level nodes
    public int getLevelDiff(TreeNode root)
    {
        // Base case
        if (root == null)
            return 0;

        // Difference for root is root's data - difference for left subtree
        // - difference for right subtree
        return root.data - getLevelDiff(root.left) - getLevelDiff(root.right);
    }




    // to delete a tree, it must be done using postorder traversal method.
    //because child must be deleted before parent node deltion.
    // NOTE: THIS IS NOT DELETING ROOT NODE. NEED TO HANDLE THAT. REFER GFG
    public void deleteTree(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        deleteTree(treeNode.left);
        deleteTree(treeNode.right);
        System.out.println("deleting node =" + treeNode.data);
        treeNode =null;
    }




    // NOTE: CHECK GEEKSFORGEEKS FOR PROPER METHOD
    //http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
//	public int verticalTraversal(Node root, int level, boolean leftCall){
//		if(root!=null){
//			level = verticalTraversal(root.right,++level, true);
//			if(treeMap.get(level)!=null){
//				ArrayList x = treeMap.get(level) ;
//				x.add(root.data);
//				treeMap.put(level, x);
//			}else{
//				al = new ArrayList<>();
//				al.add(root.data);
//				treeMap.put(level, al);
//			}
//			verticalTraversal(root.left,--level,false);
//			return level;
//		}else if(leftCall){
//			return --level;
//		}else{
//			return ++level;
//		}
//	}

    /**
     * Basically root element will start with hd=0.
     * if the element is at right, +1 to the hd of parent.
     * if element is at left, then -1 to the hd value of its parents.
     * now all the elements which has same hd value are at the same vertical line
     */
    static void getVerticalOrder(TreeNode root, int hd,
                                 TreeMap<Integer,ArrayList<Integer>> m)
    {
        // Base case
        if(root == null)
            return;

        //get the vector list at 'hd'
        ArrayList<Integer> get =  m.get(hd);

        // Store current node in map 'm'
        if(get == null)
        {
            get = new ArrayList<>();
            get.add(root.data);
        }
        else
            get.add(root.data);

        m.put(hd, get);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd-1, m);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd+1, m);
    }

    //	public int diametre(Node node, int d)
    //	{
    //		if(node==null)
    //			return 0;
    //
    //		lh=diametre(node.left, d);
    //		rh=diametre(node.right, d);
    //
    //		if(lh+rh+1>d)
    //			d=lh+rh+1;
    //
    //		return findMax(lh, rh)+1;
    //	}



    public int maxPathSum(TreeNode treeNode)
    {
        if(treeNode ==null)
            return 0;
        else
        {
            return Math.max( (maxRootToLeafSum(treeNode.left)+maxRootToLeafSum(treeNode.right)+ treeNode.data), Math.max( maxPathSum(treeNode.left), maxPathSum(treeNode.right) ) );
        }
    }



    public boolean heightBalanced(TreeNode treeNode){

        if(treeNode ==null) return true;
        int lh = height(treeNode.left);
        int rh= height(treeNode.right);

        int diff = Math.abs(lh-rh);
        if(diff<=1 && heightBalanced(treeNode.left)&& heightBalanced(treeNode.right))
            return true;

        return false;

    }


    public boolean hasSum(TreeNode treeNode, int sum, ArrayList paths)
    {
        boolean boolVal = false;

        if (treeNode == null)
            return boolVal;

        else
        {
            //System.out.println(node.data);
            paths.add(treeNode.data);
            int intermediateSum = sum - treeNode.data;
            if ( intermediateSum == 0 && treeNode.left == null && treeNode.right == null ){
                System.out.println(paths);
                return true;
            }
            if(treeNode.left!=null){
                boolVal = boolVal ||hasSum(treeNode.left, intermediateSum, new ArrayList(paths));
            }
            if(treeNode.right!=null){
                boolVal = boolVal || hasSum(treeNode.right, intermediateSum, new ArrayList(paths));
            }

            return boolVal;
        }
    }

    // doesnt holds good for BST. holds good only for BT
    public int childsumprop(TreeNode treeNode){
        int ls=0, rs=0;
        if(treeNode ==null){
            return 0;
        }
        if(treeNode.left!=null)
            ls= treeNode.left.data;
        else
            ls = 0;

        if(treeNode.right!=null)
            rs = treeNode.right.data;
        else
            rs =0;

        int sum =  ls+rs;
        if(treeNode.data == sum){
            childsumprop(treeNode.left);
            childsumprop(treeNode.right);
            return 1;
        }
        else
            return 0;
    }

    // find the path from root to leaf whoes sum matches to the specified integer
    public boolean pathToSum(TreeNode n, int sum) {
        System.out.println("overridden data=");
        boolean leafNode = false;
        if(n.left==null && n.right==null)
            leafNode = true;

        if (null != n) {
            sum -= n.data;
            System.out.println("sum=" +sum);
            boolean found = pathToSum(n.left, sum);

            if (!found) {
                found = pathToSum(n.right, sum);
            }
            if (found) {
                System.out.println(n.data);
                return found;
            }
        }
        if((0 == sum ) && (leafNode==true))
            return true ;
        else
            return false;
    }



    public void printRightView(TreeNode treeNode, int level){

        if(treeNode ==null){
            //System.out.println("node is null");
            return;
        }
        System.out.println("node data= "+ treeNode.data +"level= "+level);
        if(max< level){
            System.out.println(treeNode.data);
            if(max<level){
                max = level; // idea is to store the max level reached in some dummy variable. And then print the node value only if max is lesser to level.
            }
        }
        printRightView(treeNode.right, level+1); // if you want right view, then iterate right first
        printRightView(treeNode.left, level+1);
    }

    public void printLeftView(TreeNode treeNode, int level){
        //System.out.println("refLevel= "+refLevel +"level= "+level);
        if(treeNode ==null){
            //System.out.println("node is null");
            return;
        }
        if(max< level){
            System.out.println(treeNode.data);
            if(max<level){
                max = level;
            }
        }
        printLeftView(treeNode.left, level+1); // if you want left view, then iterate left first
        printLeftView(treeNode.right, level+1);
    }

    public void rightview(TreeNode n){
        System.out.println("rightview");
        printRightView(n,1);
    }


    //http://algorithms.tutorialhorizon.com/print-the-bottom-view-of-the-binary-tree/
    public TreeNode BottomView(TreeNode root, int level) {
        if (root == null)
            return null;
        ht.put(level, root.data); // keep updating the recently visited node.
        System.out.println("level = "+level +" root data= "+root.data);
        TreeNode x = BottomView(root.left, --level);
        if (x == null) {
            level++;
        }
        return BottomView(root.right, ++level);
    }

    public void display() {   // print the bottom view.

        Set<Integer> keys = ht.keySet();
        for (Integer key : keys) {
            System.out.print("Keys = "+key + " ");
            System.out.print(ht.get(key) + " ");
            System.out.println(" ");
        }
    }


    public TreeNode topView(TreeNode root, int level) {
        if (root == null)
            return null;
        if (ht.containsKey(level)) {

        } else {// print only the first element at each level in vertical order.
            System.out.print(root.data + "   ");
            ht.put(level, root.data);
        }

        TreeNode x = topView(root.left, --level);
        if (x == null) {
            level++;
        }
        return topView(root.right, ++level);

    }

    public TreeNode VerticalView(TreeNode root, int level) {
        if (root == null)
            return null;
        if (map.containsKey(level)) {
            LinkedList list = map.get(level);
            list.add(root.data);
            map.put(level, list);
        } else {// print only the first element at each level in vertical order.
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(root.data);
            map.put(level, list);
        }

        TreeNode x = VerticalView(root.left, --level);
        if (x == null) {
            level++;
        }
        return VerticalView(root.right, ++level);

    }

    public void printVerticalView(){
        //for(int i=0; i<map.size(); i++){
        System.out.println(map.values());
        //}
    }
    public void printDiagonalView(TreeNode treeNode){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            System.out.print(treeNode.data);
            System.out.print(" ");

            while(treeNode !=null){
                //System.out.println(node.left.data);
                if(treeNode.right!=null){
                    System.out.print(treeNode.right.data);
                    System.out.print(" ");
                }
                if(treeNode.left!=null)
                    queue.add(treeNode.left);
                treeNode = treeNode.right;
            }

        }

    }

    public void printPerimenterofTree(){
        // print left right view nodes and then print all leaf nodes. this gives the perimenter
    }

    //Remove all nodes which don’t lie in any path with sum>= k
    public TreeNode removePathsWithSumNOTK(TreeNode root, int sum)
    {
        System.out.println("removepath sum ="+Math.abs(sum));
        if(root==null){
            return null;
        }

        root.left = removePathsWithSumNOTK(root.left, sum - root.data);
        root.right = removePathsWithSumNOTK(root.right, sum - root.data);

        if(root.left==null && root.right==null){
            System.out.println("inside leafcase");
            if(root.data <Math.abs(sum)){
                System.out.println("removing root" +root.data);
                root =null;
            }
        }
        return root;
    }

    boolean printAncestors(TreeNode treeNode, int target) {

        /* base cases */
        if (treeNode == null) {
            return false;
        }

        if (treeNode.data == target) {
            return true;
        }

		/* If target is present in either left or right subtree of this node,
        then print this node */
        if (printAncestors(treeNode.left, target)
                || printAncestors(treeNode.right, target)) {
            System.out.print(treeNode.data + " ");
            return true;
        }

        /* Else return false */
        return false;
    }

    /* Given a binary tree, print its nodes in reverse level order */
    boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // Both roots are NULL, trees isomorphic by definition
        if (n1 == null && n2 == null) {
            return true;
        }

        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.data != n2.data) {
            return false;
        }

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been "Flipped".
        // Both of these subtrees have to be isomorphic, hence the &&
        // Case 2: The subtrees rooted at these nodes have been "Flipped"
        return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
                || (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
    }



    public boolean findIfIdentical(TreeNode first, TreeNode second){

        if(first ==null && second ==null){
            return true;
        }
        if(first!=null && second!=null){
            return (first.data== second.data &&
                    findIfIdentical(first.left, second.left) &&
                    findIfIdentical(first.right, second.right));
        }
        return false;
    }

    // finds if two trees are structurally same.
    public boolean findIfStructIdentical(TreeNode first, TreeNode second){
        if(first==null && second==null)
            return true;
        if(first!=null && second!=null && findIfStructIdentical(first.left, second.left) &&
                findIfStructIdentical(first.right, second.right)){
            return true;
        }
        return false;
    }

    boolean areMirror(TreeNode a, TreeNode b)
    {
        /* Base case : Both empty */
        if (a == null && b == null)
            return true;

        // If only one is empty
        if (a == null || b == null)
            return false;

		/* Both non-empty, compare them recursively
	           Note that in recursive calls, we pass left
	           of one tree and right of other tree */
        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }

    public int findSum(TreeNode root){
        if(root == null)
            return 0;
        return findSum(root.left) + root.data + findSum(root.right);
    }
    // checks if sum of all elements at left subtree is equal to sum of all elements at right subtree
    public boolean isSumTree(TreeNode treeNode){
        int ls=0, rs=0;
        if(treeNode ==null || (treeNode.left==null && treeNode.right==null) )
            return true;

        ls = findSum(treeNode.left);
        rs = findSum(treeNode.right);

        if((treeNode.data== ls+rs) && isSumTree(treeNode.left) && isSumTree(treeNode.right)){
            return true;
        }
        return false;
    }


    // find if second is a subtree of first tree
    public boolean isSubTree(TreeNode first, TreeNode second){

        if(second==null)
            return true;
        if(first==null)
            return false;
        if(findIfIdentical(first, second))
            return true;
        return (isSubTree(first.left, second)|| isSubTree(first.right, second));

    }

    public void findPredecessorInorder(int data, TreeNode pre, TreeNode treeNode){
        // maximum value in the left subtree becomes its predecessor.
        // Base case
        if (treeNode == null)  return ;
        // If key is present at root
        if (treeNode.data == data)
        {
            // the maximum value in left subtree is predecessor
            if (treeNode.left != null)
            {
                TreeNode tmp = treeNode.left;
                while (tmp.right!=null)
                    tmp = tmp.right;
                pre = tmp;
            }

            System.out.println(pre.data);
        }else if(data> treeNode.data){
            pre=root;
            findPredecessorInorder(data, pre, treeNode.right);
        }else{
            pre=root;
            findPredecessorInorder(data, pre, treeNode.left);
        }

    }

    public void findSuccessorInOrder(int data, TreeNode suc, TreeNode treeNode){
        // the minimum value in right subtree is successor
        // Base case
        if (treeNode == null)  return ;
        // If key is present at root
        if (treeNode.data == data)
        {
            // the minimum value in right subtree is successor
            if (treeNode.right != null)
            {
                TreeNode tmp = treeNode.left;
                while (tmp.left!=null)
                    tmp = tmp.right;
                suc = tmp;
            }

            System.out.println(suc.data);
        }else if(data> treeNode.data){
            suc=root;
            findPredecessorInorder(data, suc, treeNode.right);
        }else{
            suc=root;
            findPredecessorInorder(data, suc, treeNode.left);
        }

    }

    void printkdistanceNodeDown(TreeNode treeNode, int k)
    {
        // Base Case
        if (treeNode == null || k < 0)
            return;

        // If we reach a k distant node, print it
        if (k == 0)
        {
            System.out.print(treeNode.data);
            System.out.println("");
            return;
        }

        // Recur for left and right subtrees
        printkdistanceNodeDown(treeNode.left, k - 1);
        printkdistanceNodeDown(treeNode.right, k - 1);
    }

    // Prints all nodes at distance k from a given target node.
    // The k distant nodes may be upward or downward.This function
    // Returns distance of root from target node, it returns -1
    // if target node is not present in tree rooted with root.
    int printkdistanceNode(TreeNode treeNode, TreeNode target, int k)
    {
        // Base Case 1: If tree is empty, return -1
        if (treeNode == null)
            return -1;

        // If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if (treeNode.data == target.data)
        {
            printkdistanceNodeDown(treeNode, k);
            return 0;
        }

        // Recur for left subtree
        int dl = printkdistanceNode(treeNode.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1)
        {

            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from
            // target
            if (dl + 1 == k)
            {
                System.out.print(treeNode.data);
                System.out.println("");
            }

            // Else go to right subtree and print all k-dl-2 distant nodes
            // Note that the right child is 2 edges away from left child
            else
                printkdistanceNodeDown(treeNode.right, k - dl - 2);

            // Add 1 to the distance and return value for parent calls
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left
        // subtree
        int dr = printkdistanceNode(treeNode.right, target, k);
        if (dr != -1)
        {
            if (dr + 1 == k)
            {
                System.out.print(treeNode.data);
                System.out.println("");
            }
            else
                printkdistanceNodeDown(treeNode.left, k - dr - 2);
            return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
    }

    boolean isSibling(TreeNode treeNode, TreeNode a, TreeNode b)
    {
        // Base case
        if (treeNode == null)
            return false;

        return ((treeNode.left == a && treeNode.right == b) ||
                (treeNode.left == b && treeNode.right == a) ||
                isSibling(treeNode.left, a, b) ||
                isSibling(treeNode.right, a, b));
    }
    int level(TreeNode treeNode, TreeNode ptr, int lev)
    {
        // base cases
        if (treeNode == null)
            return 0;

        if (treeNode == ptr)
            return lev;

        // Return level if Node is present in left subtree
        int l = level(treeNode.left, ptr, lev + 1);
        if (l != 0)
            return l;

        // Else search in right subtree
        return level(treeNode.right, ptr, lev + 1);
    }

    boolean isCousin(TreeNode treeNode, TreeNode a, TreeNode b)
    {
        // 1. The two Nodes should be on the same level
        //       in the binary tree.
        // 2. The two Nodes should not be siblings (means
        //    that they should not have the same parent
        //    Node).
        return ((level(treeNode, a, 1) == level(treeNode, b, 1)) &&
                (!isSibling(treeNode, a, b)));
    }
}




public class MyBST {

    public static void main(String args[])
    {
        Bst bst=new Bst();
        TreeNode root = new TreeNode(50);
        bst.root = root;
        ArrayList arr=new ArrayList();
        int arr1[] = {1,2,3,4,5,6,7,8,9};

        /*bst.sortedArrayToBST(arr1);*/

        System.out.println("Building tree with root value " + root.data);
        bst.insert(root, 10);
        bst.insert(root, 32);
        bst.insert(root, 60);
        bst.insert(root, 77);
        bst.insert(root, 70);
        bst.insert(root, 80);
        bst.insert(root, 90);
        bst.insert(root, 20);
        bst.insert(root, 35);
        bst.insert(root, 15);
        bst.insert(root, 25);
        bst.insert(root, 33);
        bst.insert(root, 40);
        //bst.printkdistanceNode(bst.root, new Node(3), 2);
        //bst.KdistancefromLeafNodes(bst.root, new ArrayList(), 2);
//        bst.deleteNodeTree(bst.root, 30);
//        System.out.println();
        bst.printPreorder(bst.root);
        System.out.println("======================================");
        bst.printInOrder(bst.root);
        System.out.println("======================================");
        System.out.println(Arrays.toString(bst.postOrderTraversalStack(bst.root).toArray()));
    }
}