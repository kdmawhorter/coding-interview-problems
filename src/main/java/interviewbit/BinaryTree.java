package interviewbit;

import com.sun.source.tree.Tree;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems on Binary Trees. Since I constructed the
 * BinaryTree myself (since I'm not in the InterviewBit editor), I chose to push a lot of the functionality to the
 * TreeNode class. The specified interface from the question is still followed. I would normally just extend the class
 * but since I'm writing both as classes within BinaryTree I felt it a bit contrived.
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
        @Getter
        private TreeNode left;

        /**
         * The right child of the Node.
         */
        @Getter
        private TreeNode right;

        /**
         * The parent of the Node.
         */
        @Getter @Setter
        private TreeNode parent;

        /**
         * Highest Path Sum Branch including the node and its contents downstream.
         */
        @Getter @Setter
        private int highestSum;

        private boolean leftHasRun;
        private boolean rightHasRun;

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
            this.parent = null;

            leftHasRun = true;
            rightHasRun = true;

            highestSum = 0;
        }

        void setLeft(TreeNode left) {
            this.left = left;
            leftHasRun = false;
            left.setParent(this);
        }

        void setRight(TreeNode right) {
            this.right = right;
            rightHasRun = false;
            right.setParent(this);
        }

        boolean hasNoChildren() {
            return left==null && right==null;
        }

        boolean canRun() {
            return rightHasRun && leftHasRun;
        }

        void updateChildRan(TreeNode child) {
            if (left==child) {
                leftHasRun = true;
            } else if (right==child) {
                rightHasRun = true;
            }
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
                Integer leftIdx = treeArray[i][2];
                Integer rightIdx = treeArray[i][3];
                if (leftIdx!=null) {
                    tree[i].setLeft(tree[leftIdx]);
                }
                if (rightIdx!=null) {
                    tree[i].setRight(tree[rightIdx]);
                }
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
    public Integer maxSumPath(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> treeNodeQueue = findLeaves(root);

            Integer highestSum = null;

            while(!treeNodeQueue.isEmpty()) {
                TreeNode thisNode = treeNodeQueue.poll();

                int thisVal = thisNode.getVal();
                int leftSum = (thisNode.getLeft()!=null) ? thisNode.getLeft().getHighestSum() : 0;
                int rightSum = (thisNode.getRight()!=null) ? thisNode.getRight().getHighestSum() : 0;

                int thisSum = thisVal + Math.max(leftSum, 0) + Math.max(rightSum, 0);
                if (highestSum == null) {
                    highestSum = thisSum;
                } else {
                    highestSum = Math.max(highestSum, thisSum);
                }

                thisNode.setHighestSum(Math.max(thisVal, Math.max(thisVal+leftSum, thisVal+rightSum)));

                if (thisNode.getParent()!=null) {
                    thisNode.getParent().updateChildRan(thisNode);
                    if (thisNode.getParent().canRun()) {
                        treeNodeQueue.add(thisNode.getParent());
                    }
                }
            }

            return highestSum;
        }
        return 0;

    }

    /**
     * Returns all nodes reachable from the root that have no children.
     * @param root The root of a Binary Tree.
     * @return All nodes under the root with no children.
     */
    private Queue<TreeNode> findLeaves(TreeNode root) {
        Queue<TreeNode> returnQueue = new LinkedList<>();
        Queue<TreeNode> findLeavesQueue = new LinkedList<>();

        findLeavesQueue.add(root);

        while (!findLeavesQueue.isEmpty()) {
            TreeNode thisNode = findLeavesQueue.poll();

            if (thisNode.hasNoChildren()) {
                returnQueue.add(thisNode);
            } else {
                findLeavesQueue.add(thisNode.getLeft());
                findLeavesQueue.add(thisNode.getRight());
            }
        }
        return returnQueue;
    }
}
