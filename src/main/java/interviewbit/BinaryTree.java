package interviewbit;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems on Binary Trees.
 */
public class BinaryTree {

    private static class TreeNode {

        /**
         * Given an array of arrays of Integers, constructs a Tree and returns the TreeNode of the root.
         * @param treeArray An array of arrays that represent a Tree of TreeNodes in the format
         *      [node #, value, left child #, right child #]
         * @return The root of the newly constructed tree
         */
        static TreeNode constructTree(Integer[][] treeArray) {
            return null;
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
