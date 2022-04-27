package interviewbit;

import lombok.Getter;
import lombok.Setter;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems on Binary Trees.
 */
public class BinaryTree {

    private static class TreeNode {

        /**
         * The value of the node.
         */
        @Getter @Setter
        private int val;

        /**
         * The left child of the Node.
         */
        @Getter @Setter
        private TreeNode left;

        /**
         * The right child of the Node.
         */
        @Getter @Setter
        private TreeNode right;

        /**
         * TreeNode constructor with no children;
         * @param val The value of the new node.
         */
        TreeNode(int val) {
            this(val, null, null);
        }

        /**
         * TreeNode constructor with children.
         * @param val The value of the new node.
         * @param left The left child of the node.
         * @param right The right child of the node.
         */
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        /**
         * Given an array of arrays of Integers, constructs a Tree and returns the TreeNode of the root.
         * @param treeArray An array of arrays that represent a Tree of TreeNodes in the format
         *      [node #, value, left child #, right child #]
         * @return The root of the newly constructed tree
         */
        static TreeNode constructTree(Integer[][] treeArray) {
            TreeNode[] tree = new TreeNode[treeArray.length];
            for (int i = 0; i < treeArray.length; i++) {
                tree[i] = new TreeNode(treeArray[i][1]);
            }
            for (int i = 0; i < treeArray.length; i++) {
                tree[i].setLeft(tree[treeArray[i][2]]);
                tree[i].setRight(tree[treeArray[i][3]]);
            }
            return tree[0];
        }
    }

    /**
     * Given an input tree in array form, returns the maximum sum path in that tree.
     * @param treeArray An array of arrays that represent a Tree of TreeNodes in the format
     *          [node #, value, left child #, right child #]
     * @return The maximum sum path in the tree.
     */
    public int maxSumPath(Integer[][] treeArray) {
        if (treeArray != null) {
            return maxSumPath(TreeNode.constructTree(treeArray));
        }
        return 0;

    }

    /**
     * Given the root TreeNode of a tree, returns the maximum sum path in that tree.
     *
     * @param root The root of some Tree.
     * @return The maximum sum path in the tree.
     */
    public int maxSumPath(TreeNode root) {
        if (root != null) {
            return 0;
        }
        return 0;

    }
}
