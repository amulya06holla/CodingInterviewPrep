package com.leet.trees;

import com.leet.linkedList.ListNode;

import java.util.*;

public class TreesPractise {
    public static ArrayList<ArrayList<Integer>> listRes = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        TreesPractise bst=new TreesPractise();
        int arr1[] = {10,32,20,30,40,35,60,77,70,80};
        //int arr1[] = {1,3,2,4,5,6,7,8};
        //int arr1[] = {2147483647};
        TreeNode root=new TreeNode(50);
        for(int i=0; i<arr1.length; i++){
            bst.insert(root, arr1[i]);
        }
        bst.levelOrderPrintAtEachLevelAlongWithLevelNumber(root);
        //bst.invertTree(root);
        System.out.println("----------------------------------------");
        bst.preOrderRecu(root);
        System.out.println();
        bst.inOrder(root);
        System.out.println();
        bst.postOrder(root);
        System.out.println("=========+++++++++++=================");
        System.out.println(bst.kthSmallest(root, 1));
        bst.findLeaves(root);
    }

    // creating BST
    public void insert(TreeNode treeNode, int value)
    {
        if (value < treeNode.val)
        {
            if (treeNode.left != null) {
                insert(treeNode.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of "
                        + treeNode.val);
                treeNode.left = new TreeNode(value);
            }
        }
        else if (value > treeNode.val)
        {
            if (treeNode.right != null) {
                insert(treeNode.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + treeNode.val);
                treeNode.right = new TreeNode(value);
            }
        }

    }

// TRAVERSALS
    // preorder
    public void preOrderRecu(TreeNode node){
        if(node!=null){
            System.out.print(node.val+ " ");
            preOrderRecu(node.left);
            preOrderRecu(node.right);
        }
    }

    //postorder
    public void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val+" ");
        }
    }

    //inorder
    public void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.val+" ");
            inOrder(node.right);
        }
    }

    // level order
    public void levelOrder(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            System.out.print(n.val+" ");
            if(n.left!=null){
                q.offer(n.left);
            }
            if(n.right!=null){
                q.offer(n.right);
            }
        }
        System.out.println();
    }

    // reverse level order
    public void reverseLevelOrder(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            System.out.print(n.val+" ");
            if(n.right!=null){
                q.offer(n.right);
            }
            if(n.left!=null){
                q.offer(n.left);
            }
        }
        System.out.println();
    }

    // spiral level order
    public void spiralLevelOrder(TreeNode node){
        if(node==null) return;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(node);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> temp = new LinkedList<Integer>();
            while(!s1.isEmpty()){
                TreeNode t = s1.pop();
                //System.out.print(t.val+" ");
                temp.add(t.val);
                if(t.left!=null)
                    s2.push(t.left);
                if(t.right!=null)
                    s2.push(t.right);
            }
            res.add(temp);
            //System.out.println();
            temp = new LinkedList<Integer>();
            while(!s2.isEmpty()){
                TreeNode t = s2.pop();
                //System.out.print(t.val+" ");
                temp.add(t.val);
                if(t.right!=null)
                    s1.push(t.right);
                if(t.left!=null)
                    s1.push(t.left);
            }
            res.add(temp);
           // System.out.println();
        }
    }

    // level order traversal and print values at each level and also print the level number
    public void levelOrderPrintAtEachLevelAlongWithLevelNumber(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        q.offer(null);
        int level=0;
        List<Integer> output = new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n==null && !output.isEmpty()){
                System.out.println(Arrays.toString(output.toArray())+" level="+level++);
                output = new LinkedList<>();
                q.offer(null);
            }
            else{
                if(n!=null) {
                    if (n.left != null) {
                        q.offer(n.left);
                    }
                    if (n.right != null) {
                        q.offer(n.right);
                    }
                    output.add(n.val);
                }
            }
        }
        System.out.println();
    }

    //can follow above method to get level of node using level order traversal or use below method which is a recurrsive solution
    public int getLevelOfNode(int n, TreeNode root, int level){
        if(root == null)
            return 0;

        if(root.val == n){
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

    // determines the height of the tree constructed
    // in this approach, we are getting to know the depth of the left and then right and then calculate the overall height.
    // in this approach, depth is calculated from bottom most or leaf. so here the leaf node will have depth of 1.
    //https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/534/#bottom-up-solution
    public int heightBottomUp (TreeNode treeNode)
    {
        if (treeNode == null)
            return 0;
        return 1 + Math.max(heightBottomUp (treeNode.left), heightBottomUp (treeNode.right));
    }

    // topDown way of finding the height of a tree. here we are giving the depth value of each node as we traverse so that that value can be used to calculate the value of the next node.
    private int answer = 0;
    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    //diameter of a tree is the max number of nodes between any two leaf nodes
    // this can be via root node or not via root node also
    public int diametre(TreeNode treeNode)
    {
        if(treeNode ==null)
            return 0;
        else
        {
            return Math.max( (heightBottomUp(treeNode.left)+heightBottomUp(treeNode.right)+1), Math.max( diametre(treeNode.left), diametre(treeNode.right) ) );
        }
    }

    public int minHeightofATree (TreeNode treeNode)
    {
        if (treeNode == null)
            return 0;
        if(treeNode.left==null && treeNode.right==null)
            return 1;

        int minDepth = Integer.MAX_VALUE;
        if(treeNode.left!=null)
            minDepth = Math.min(minHeightofATree(treeNode.left), minDepth);
        if(treeNode.right!=null)
            minDepth = Math.min(minHeightofATree(treeNode.right), minDepth);

        return minDepth+1;
    }

    //total number of nodes
    public int size (TreeNode treeNode)
    {
        if (treeNode == null)
            return 0;
        return 1 + size (treeNode.left)+ size (treeNode.right);
    }

    //https://leetcode.com/problems/inorder-successor-in-bst/
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                // the left most value in the right subtree is the inorder successor.
                succ = root;   // when you go to the left of BST, only then there is a possiblity to find
                // a value lesser than root but greater than p value.(successor)

                root = root.left;
            }
        }
        return succ;
    }

    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        while (root != null) {
            if (p.val >= root.val) {
                prev = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return prev;
    }

    // find mirror of a tree or invert the given tree.
    public static TreeNode invertTree(TreeNode root){
        if(root==null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    // different views of a tree

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            for (int i = 0; i <n; i++) {
                TreeNode temp = queue.poll();
                if (i == n)
                    list.add(temp.val); // add the data only if it is the last object in that level.
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

        return list;
    }

    public static List<Integer> LeftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == 0)
                    list.add(temp.val); // add the data only if it is the first object in that level.
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

        return list;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int res=0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == 0 && temp.right==null && temp.left==null)
                    res=res+temp.val;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

        return res;
    }

    public void findPaths(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        if(root!=null) list.add(root.val);
        if(root.left==null && root.right==null){
            listRes.add(list);
            System.out.println(Arrays.toString(list.toArray()));
        }else {
            findPaths(root.left, new ArrayList<>(list));
            findPaths(root.right, new ArrayList<>(list));
        }
    }

    public static boolean isSubPath(ListNode head, TreeNode root) {
        ListNode temp = head;
        ArrayList<Integer> listNodes = new ArrayList<>();
        while(temp!=null){
            listNodes.add(temp.val);
            temp = temp.next;
        }
        for(ArrayList<Integer> list: listRes){
            if(Collections.indexOfSubList(list, listNodes)>-1){
                return true;
            }
            }
        return false;
        }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return areSymmetricTrees(root, root);
    }

    private boolean areSymmetricTrees(TreeNode a, TreeNode b) {
        if(a==null && b==null) return true;
        if(a==null||b==null) return false;
        return (a.val==b.val) && areSymmetricTrees(a.right, b.left) && areSymmetricTrees(a.left, b.right);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum = targetSum-root.val;
        if(root.left==null && root.right==null)
            return targetSum == 0;
        return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);

    }

    public static boolean isSubTree(TreeNode s,TreeNode t) {
        return  s!=null && ( isSubtreeOfEachOther(s,t) || isSubTree(s.left,t) || isSubTree(s.right,t));
    }
    public static boolean isSubtreeOfEachOther(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        return root.val==subRoot.val && isSubtreeOfEachOther(root.left, subRoot.left) && isSubtreeOfEachOther(root.right, subRoot.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((p==null && q!=null) || (p!=null && q==null)) return false;
        return (p.val==q.val)&& isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    Map<Integer, String> mapString = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findSum(root,map);
        String[] res = mapString.get(max).split(",");
        int[] result = new int[res.length];
        for(int i=0; i<res.length; i++){
            result[i]=Integer.parseInt(res[i]);
        }
        return result;
    }

    private int findSum(TreeNode treeNode, Map<Integer, Integer> map) {
            if (treeNode == null)
                return 0;
           // if(treeNode.right==null && treeNode.left==null) return treeNode.val;
            int lsum= findSum (treeNode.left,map);
            int rsum= findSum (treeNode.right,map);
            int sum=treeNode.val+lsum+rsum;
            System.out.println(treeNode.val+ " " +sum);
            int val = 0;
            List<Integer> list = null;
            if(map.containsKey(sum)){
                val = map.get(sum)+1;
            }else{
                val = 1;
            }
            //map.put(sum, val);
            if(mapString.get(val)!=null)
                mapString.put(val,mapString.get(val)+","+ sum);
            else
                mapString.put(val,""+sum);
            max = Math.max(val,max);
            return sum;
    }
    private int maxSum =0;
    public int maxPathSum(TreeNode root) {
        findPathSums(root, new ArrayList<>());
        System.out.println("maxSum="+maxSum);
        return maxSum;
    }

    private void findPathSums(TreeNode root, ArrayList<Integer> list) {
        if(root==null) return ;
        list.add(root.val);
        if(root.left==null && root.right==null){
            System.out.println(Arrays.toString(list.toArray()));
            int sum =0;
            for(int i=0; i<list.size();i++){
                sum = sum+list.get(i);
            }
            maxSum = Math.max(sum,maxSum);
        }else{
            findPathSums(root.left, new ArrayList<>(list));
            findPathSums(root.right, new ArrayList<>(list));
        }
    }

    public int secondMin = Integer.MAX_VALUE;
    public int firstMin = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        findSecondMin(root);
        if (secondMin==Integer.MAX_VALUE) return -1;
        return secondMin;
    }

    public void findSecondMin(TreeNode root){
        if(root!=null){
            firstMin= Math.min(firstMin, root.val);
            if(firstMin!=Integer.MAX_VALUE && root.val!=firstMin){
                if(root.val<=secondMin){
                    secondMin = root.val;
                }
            }
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean sameLevel=false;
        int parentx=-1, parenty=-1;

        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int level=0;
        List<Integer> output = new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n==null && !output.isEmpty()){
                // System.out.println(Arrays.toString(output.toArray())+" level="+level++);
                if(output.contains(x) && output.contains(y)){
                    sameLevel = true;
                    break;
                }
                output = new LinkedList<>();
                q.offer(null);
            }
            else{
                if(n!=null) {
                    if (n.left != null) {
                        q.offer(n.left);
                        if(n.left.val==x) parentx = n.val;
                        if(n.left.val==y) parenty = n.val;
                    }
                    if (n.right != null) {
                        q.offer(n.right);
                        if(n.right.val==x) parentx = n.val;
                        if(n.right.val==y) parenty = n.val;
                    }
                    output.add(n.val);
                }
            }
        }
        if(sameLevel && parentx!=parenty) return true;
        return false;

    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestorBST(root.right, p, q);
        }else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestorBST(root.left, p, q);
        }else if(p.val==root.val || q.val==root.val){
            return root;
        }else if((p.val>root.val && q.val<root.val)||(p.val<root.val && q.val>root.val)){
            return root;
        }
        return null;
    }

    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestorBT(root.left, p, q);
        TreeNode right = lowestCommonAncestorBT(root.right, p, q);

        if (left != null && right != null)
            return root;
        else {
            if (left != null)
                return left;
            else
                return right;
        }


    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTTest(root, null, null);
    }

    private boolean isValidBSTTest(TreeNode root, Integer minValue, Integer maxValue) {
        if(root==null) return true;
        if(minValue!=null && root.val<=minValue || maxValue!=null && root.val>=maxValue) return false;
        return isValidBSTTest(root.left, minValue, root.val) && isValidBSTTest(root.right, root.val, maxValue);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key) root.left= deleteNode(root.left,key);
        else if(root.val<key) root.right= deleteNode(root.right,key);
        else if(root.val==key){
            if(root.left==null && root.right==null) return null;
            else if(root.left==null && root.right!=null) return root.right;
            else if(root.right==null && root.left!=null) return root.left;
            else{
                ////////////THIS IS THE IMPORTNAT STEP
                root.val = findMin(root.right).val;
                root.right = deleteNode(root.right, root.val); // keep replacing the value till the end of node is reached.
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root ==null) return true;
        int lh = heightBottomUp(root.left);
        int rh= heightBottomUp(root.right);

        int diff = Math.abs(lh-rh);
        if(diff<=1 && isBalanced(root.left)&& isBalanced(root.right))
            return true;
        return false;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTreeFromArray(nums, 0, nums.length-1);
    }

    private TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if(left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTreeFromArray(nums, left, mid-1);
        root.right = constructTreeFromArray(nums, mid+1, right);
        return root;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return root;
        if(root.val==val) return root;
        if(val<root.val) return searchBST(root.left, val);
        if(val> root.val) return searchBST(root.right, val);
        return root;
    }

   // https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(TreeNode root) {
        return findSumRootToLeaf(root, "", 0);
    }

    private int findSumRootToLeaf(TreeNode root, String sum, int total) {
        if(root==null) return total;
        sum=sum+root.val;
        if(root.left==null && root.right==null){
            total = total+Integer.parseInt(sum);
            sum ="";
            return total;
        }
        total = findSumRootToLeaf(root.left, sum, total);
        total= findSumRootToLeaf(root.right, sum, total);
        return total;
    }

    //https://leetcode.com/problems/binary-tree-upside-down/
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)
            return null;
        return upsideDownTree(root, null);
    }

    private TreeNode upsideDownTree(TreeNode cur, TreeNode parent){
        TreeNode newRoot = cur;
        if(cur.left != null){
            newRoot = upsideDownTree(cur.left, cur);
        }
        if(parent != null){
            cur.left = parent.right;
            cur.right = parent;
            parent.left = null;
            parent.right = null;
        }
        return newRoot;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val);                // visit the root
                if (cur.left != null) {
                    q.offer(cur.left);              // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.offer(cur.right);             // push right child to queue if it is not null
                }
            }
            ans.addFirst(subAns);
        }
        return ans;
    }

    public Node treeToDoublyList(Node root) {
        if( root == null) return root;
        Node dummy = new Node();
        Node prev = dummy;
        Stack<Node> stack = new Stack();
        Node curr = root;

        while(!stack.isEmpty()|| curr != null){
            while(curr!= null){
                stack.push(curr);
                curr= curr.left;
            }

            curr = stack.pop();
            prev.right = curr;
            curr.left = prev;
            prev = curr;
            curr = curr.right;
        }
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        rootToLeafPaths(root, "", list);
        return list;
    }

    private void rootToLeafPaths(TreeNode root, String s, List<String> list) {
        if(root==null) return;
        if(s.isEmpty())
            s = s+"->"+root.val;
        else
            s = s+root.val;
        if(root.left==null && root.right==null){
            list.add(s);
            s="";
        }
        rootToLeafPaths(root.left, s, list);
        rootToLeafPaths(root.right, s, list);
    }


    //https://leetcode.com/problems/binary-tree-paths/
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        rootToLeafPathsSum(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void rootToLeafPathsSum(TreeNode root, int sum, int targetSum, List<Integer> list, List<List<Integer>> res) {
        if(root==null) return;
        sum= sum+root.val;
        list.add(root.val);
        if(root.left==null && root.right==null){
           if(sum==targetSum){
                res.add(list);
           }
        }
        rootToLeafPathsSum(root.left, sum, targetSum, new ArrayList<>(list), res);
        rootToLeafPathsSum(root.right, sum, targetSum, new ArrayList<>(list), res);
    }

    //https://leetcode.com/problems/find-leaves-of-binary-tree/
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> findLeaves(TreeNode root) {
            levels(root);
            return res;
    }

        private static int levels(TreeNode root){
            if(root == null) return -1;

            int depth = Math.max(levels(root.left), levels(root.right)) +1; // we are setting the levels of a tree in descending order. i.e. leaf nodes will have its levels set as 0.
            // so the level of the root or any node is determined by the max depth between right and left.
            if(depth >= res.size()){
                res.add(new ArrayList<>()); // basically if there are no list available for a specific node, then a new list is added.
            }

            res.get(depth).add(root.val);  // now add the element to the respective level's list.
            return depth;
        }


    private int findSumRootToLeafBinary(TreeNode root, String sum, int total) {
        if(root==null) return total;
        sum=sum+root.val;
        if(root.left==null && root.right==null){
            total = total+Integer.parseInt(sum, 2);
            sum ="";
            return total;
        }
        total = findSumRootToLeafBinary(root.left, sum, total);
        total= findSumRootToLeafBinary(root.right, sum, total);
        return total;
    }

    //https://leetcode.com/problems/construct-string-from-binary-tree/
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }

    static int diff=0;
    public int findTilt(TreeNode root) {
        findTiltValue(root, 0);
        return diff;
    }
    public int findTiltValue(TreeNode root, int sum){
        if (root == null)
            return 0;
        // if(treeNode.right==null && treeNode.left==null) return treeNode.val;
        int lsum= findTiltValue (root.left, sum);
        int rsum= findTiltValue (root.right, sum);
        diff=diff+Math.abs(lsum-rsum);
        sum=root.val+lsum+rsum;
        System.out.println(root.val+ " " +sum);
        return sum;
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    //https://leetcode.com/problems/binary-tree-pruning/solution/
    public boolean containsOne(TreeNode node) {
        if (node == null) return false;

        // Check if any node in the left subtree contains a 1.
        boolean leftContainsOne = containsOne(node.left);

        // Check if any node in the right subtree contains a 1.
        boolean rightContainsOne = containsOne(node.right);

        // If the left subtree does not contain a 1, prune the subtree.
        if (!leftContainsOne) node.left = null;

        // If the right subtree does not contain a 1, prune the subtree.
        if (!rightContainsOne) node.right = null;

        // Return true if the current node, its left or right subtree contains a 1.
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }

//https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
    private List<Integer> allSums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        // long is a 64-bit integer.
        long totalSum = treeSum(root);
        long best = 0;
        for (long sum : allSums) {
            best = Math.max(best, sum * (totalSum - sum));
        }
        // We have to cast back to an int to match return value.
        return (int)(best % 1000000007);

    }

    private int treeSum(TreeNode subroot) {
        if (subroot == null) return 0;
        int leftSum = treeSum(subroot.left);
        int rightSum = treeSum(subroot.right);
        int totalSum = leftSum + rightSum + subroot.val;
        allSums.add(totalSum);
        return totalSum;
    }


    public boolean findTarget(TreeNode root, int k) {
        if(root== null) return false;
        return findTargetinBST(root, k, new ArrayList<Integer>());
    }

    private boolean findTargetinBST(TreeNode root, int k, List<Integer> list) {
        if(root==null) return false;
        int temp = k-root.val;
        if(list.contains(temp)) return true;
        list.add(root.val);
        return findTargetinBST(root.left, k, list) || findTargetinBST(root.right, k, list);
    }

    //https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/
    public boolean isValidSerialization(String preorder) {
        // number of available slots
        int slots = 1;

        int n = preorder.length();
        for(int i = 0; i < n; ++i) {
            if (preorder.charAt(i) == ',') {
                // one node takes one slot
                --slots;

                // no more slots available
                if (slots < 0) return false;

                // non-empty node creates two children slots
                if (preorder.charAt(i - 1) != '#') slots += 2;
            }
        }

        // the last node
        slots = (preorder.charAt(n - 1) == '#') ? slots - 1 : slots + 1;
        // all slots should be used up
        return slots == 0;
    }


    //https://leetcode.com/problems/equal-tree-partition/
        Stack<Integer> seen;
        public boolean checkEqualTree(TreeNode root) {
            seen = new Stack();
            int total = sum(root);
            seen.pop();
            if (total % 2 == 0)
                for (int s: seen)
                    if (s == total / 2)
                        return true;
            return false;
        }

        public int sum(TreeNode node) {
            if (node == null) return 0;
            seen.push(sum(node.left) + sum(node.right) + node.val);
            return seen.peek();
        }
}
