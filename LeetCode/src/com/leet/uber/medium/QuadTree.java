package com.leet.uber.medium;

public class QuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    //Time: O(N^2), Space: O(logN)
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length - 1, grid.length - 1);
    }

    /**
     * sx: starting x,
     * sy: starting y,
     * ex: end x,
     * ey: end y,
     */
    private Node helper(int[][] grid, int sx, int sy, int ex, int ey) {
        if (sx == ex && sy == ey) {
            return new Node(grid[ex][ey] == 1, true, null, null, null, null);
        }
        int midx = sx + (ex - sx) / 2, midy = sy + (ey - sy) / 2;
        Node topLeft = helper(grid, sx, sy, midx, midy);
        Node topRight = helper(grid, sx, midy + 1, midx, ey);
        Node bottomLeft = helper(grid, midx + 1, sy, ex, midy);
        Node bottomRight = helper(grid, midx + 1, midy + 1, ex, ey);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                return new Node(topLeft.val, true, null, null, null, null);
            }
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
