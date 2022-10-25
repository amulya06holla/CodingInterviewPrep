Note to self:
1. when you delete nodes in a tree, deletion process will be in post-order. That is to say, when you delete a node, you will delete its left child and its right child before you delete the node itself.
2. Also, post-order is widely use in mathematical expression. It is easier to write a program to parse a post-order expression (https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/)
3. "top-down" recursive solution can be considered as a kind of preorder traversal and "bottom-up" solution can be postorder traversal.
4. Top-down and Bottom up approaches:
    a. if you know the value that can be passed on to child nodes and if we know some parameters to know the value needed at root, then go for top-down
    b. if you know the answer of its children, can you calculate the answer of that node then go for bottom-up.