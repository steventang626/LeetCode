/**
 * Definition for a QuadTree node.
 */
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

public class Solution {
    /**
     * Time O(NlogN)
     * @param grid
     * @return
     */
    public Node construct(int[][] grid) {
        return constructNode(grid, 0, 0, grid.length);
    }

    public Node constructNode(int[][] grid, int startX, int startY, int length) {
        int leftUpX = startX, leftUpY = startY;
        int leftDownX = startX + length / 2, leftDownY = startY;
        int rightUpX = startX, rightUpY = startY + length / 2;
        int rightDownX = startX + length / 2, rightDownY = startY + length / 2;

        Node topLeft = checkIsLeaf(grid, leftUpX, leftUpY, length / 2);
        Node topRight = checkIsLeaf(grid, rightUpX, rightUpY, length / 2);
        Node bottomLeft = checkIsLeaf(grid, leftDownX, leftDownY, length / 2);
        Node bottomRight = checkIsLeaf(grid, rightDownX, rightDownY, length / 2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
        && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        } else {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public Node checkIsLeaf(int[][] grid, int x, int y, int length) {
        int origin = grid[x][y];
        boolean isLeaf = true;
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (grid[i][j] != origin) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) {
            return new Node(origin == 1, true, null, null, null, null);
        } else {
            return constructNode(grid, x, y, length);
        }
    }

    public Node constructNode2(int[][] grid, int startX, int startY, int length) {
        if (length <= 0) {
            return null;
        }
        int halfLength = length / 2;
        for (int i = startX; i < startX + length; i++) {
            for (int j = startY; j < startY + length; j++) {
                if (grid[i][j] != grid[startX][startY]) {
                    return new Node(true, false, constructNode2(grid, startX, startY, halfLength),
                            constructNode2(grid, startX, startY + halfLength, halfLength),
                            constructNode2(grid, startX + halfLength, startY, halfLength),
                            constructNode2(grid, startX + halfLength, startY + halfLength, halfLength));
                }
            }
        }
        return new Node(grid[startX][startY] == 1, true, null, null, null, null);
    }

    /**
     * Time O(N), but in LeetCode this method is slower
     * @param grid
     * @return
     */
    public Node construct2(int[][] grid) {
        Node[][] nodeGrid = new Node[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                nodeGrid[i][j] = new Node(grid[i][j] == 1, true, null, null, null, null);
            }
        }
        int length = nodeGrid.length;
        Node[][] newNodeGrid;
        while (length > 1) {
            length = length / 2;
            newNodeGrid = new Node[length][length];
            for (int i = 0; i < length * 2; i = i + 2) {
                for (int j = 0; j < length * 2; j = j + 2) {
                    if (nodeGrid[i][j].isLeaf && nodeGrid[i + 1][j].isLeaf
                            && nodeGrid[i][j + 1].isLeaf && nodeGrid[i + 1][j + 1].isLeaf
                            && nodeGrid[i][j].val == nodeGrid[i + 1][j].val
                            && nodeGrid[i + 1][j].val == nodeGrid[i][j + 1].val
                            && nodeGrid[i + 1][j + 1].val == nodeGrid[i][j].val) {
                        newNodeGrid[i / 2][j / 2] = new Node(nodeGrid[i][j].val, true, null, null, null, null);
                    } else {
                        newNodeGrid[i / 2][j / 2] = new Node(true, false, nodeGrid[i][j], nodeGrid[i][j + 1],
                                nodeGrid[i + 1][j], nodeGrid[i + 1][j + 1]);
                    }
                }
            }
            nodeGrid = newNodeGrid;
        }
        return nodeGrid[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        Node result = new Solution().construct2(grid);
    }

}
