package interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems
 * <a href="https://www.interviewbit.com/problems/distribute-candy/">Distribute Candy</a>.
 */
public class DistributeCandy {

    /**
     * A helper class for {@link DistributeCandy} which serves to represent the input indices for
     * {@link #determineNeededCandies(int[])}. Each index will be represented by a node with the caveat that adjacent
     * indices with the same priority will share a node.<br>
     * <br>
     * Each node has two possible children (left and right). Given two adjacent nodes A then B, if A
     * represents indices with a lower priority than the indices of B, then B will be the right child of A, else A has
     * a higher priority then B and A will be the left child of B. Two nodes will not have equal priorities as they
     * would then be the same node.
     */
    private static class Node {
        private Node leftChild;
        private Node rightChild;

        private boolean queued;

        private final int priority;

        private int remParentCount;
        private int nodeCount;
        private int candyCost;

        /**
         * Node constructor.
         *
         * @param priority The priority of the node.
         */
        Node(int priority) {
            leftChild = null;
            rightChild = null;
            queued = false;
            this.priority = priority;
            remParentCount = 0;
            nodeCount = 1;
            candyCost = 1;
        }

        /**
         * Decrease the count of parents who haven't been assigned candy yet.
         */
        void decParentCount() { remParentCount--; }

        /**
         * Increase the count of parents who haven't been assigned candy yet.
         */
        void incParentCount() { remParentCount++; }

        /**
         * Get whether any parents still have to be assigned candy.
         * @return Whether any parents remain to be assiend candy.
         */
        boolean hasNoRemainingParents() {return remParentCount==0; }

        /**
         * Get the children of the node.
         * @return The children of the node.
         */
        ArrayList<Node> getChildren() {
            ArrayList<Node> childrenList = new ArrayList<>();
            if (leftChild!=null) { childrenList.add(leftChild); }
            if (rightChild!=null) { childrenList.add(rightChild); }
            return childrenList;
        }

        /**
         * Set the left child of the node.
         * @param left The node to be the left child of this node.
         */
        void setLeftChild(Node left) { leftChild=left; }

        /**
         * Set the right child of the node.
         * @param right The node to be the left child of this node.
         */
        void setRightChild(Node right) { rightChild=right; }

        /**
         * Indicates whether all parents of the node (if there are any) have been assigned candy and, thus, this node
         * was able to be queued for processing.
         * @return Whether the node has been queued for processing
         */
        boolean hasNotBeenQueued() { return !queued; }

        /**
         * Sets that this node has been queued for processing.
         */
        void markAsQueued() { queued = true; }

        /**
         * Gets the node priority.
         * @return The priority of the node.
         */
        int getPriority() { return priority; }

        /**
         * Increment the number of indices represented by this node.
         */
        void incNodeCount() { nodeCount++; }

        /**
         * Gets the number of indices represented by this node.
         * @return The number of indices represented by this node.
         */
        int getNodeCount() { return nodeCount; }

        /**
         * Sets the number of candies required by each index represented by this node.
         * @param cost The number of candies to be needed by each node.
         */
        void setCandyCost(int cost) { candyCost = Math.max(cost, candyCost); }

        /**
         * Gets the number of candies required by each index represented by this node.
         * @return The number of candies required by each index represented by this node.
         */
        int getCandyCost() { return candyCost; }
    }


    /**
     * A helper class for {@link DistributeCandy} which serves to represent the tree of {@link Node Nodes} formed by
     * building the nodes from the input indices for {@link #determineNeededCandies(int[])}.
     */
    private static class NodeList {
        private final List<Node> nodes;

        /**
         * NodeList constructor.
         */
        NodeList() { nodes = new ArrayList<>(); }

        /**
         * Gets the ith node from the node array.
         * @param i The index of the node to retrieve.
         * @return The ith node.
         */
        Node getNode(int i) { return nodes.get(i); }

        /**
         * Adds a node to the array of nodes.
         * @param node The node to add.
         */
        void addNode(Node node) { nodes.add(node); }

        /**
         * Gets all the nodes of the NodeList which do not have any parents that have yet to be assigned candy.
         * @return All the nodes of the NodeList which do not have any parents that have yet to be assigned candy.
         */
        Queue<Node> getParentLessNodes() {
            Queue<Node> parentlessNodes = new LinkedList<>();
            for (Node node : nodes) {
                if (node.hasNoRemainingParents() && node.hasNotBeenQueued()) {
                    parentlessNodes.add(node);
                    node.markAsQueued();
                }
            }
            return parentlessNodes;
        }
    }

    // End of helper classes

    private NodeList allNodes;

    public DistributeCandy() {
        allNodes = new NodeList();
    }

    /**
     * Removes all nodes of the node list.
     */
    public void clear() {
        allNodes = new NodeList();
    }


    /**
     * Given a list of integers representing index position priorities, finds the minimum number of candies to be
     * distributed given that each index has more candies than adjacent neighbors with a lower priority rating.
     *
     * @param priorityList An int list which indicates each index position's priority
     * @return An int representing the minimum candies needed to distribute as above
     */
    public int determineNeededCandies(int[] priorityList) {
        buildNodeList(priorityList);
        return accumulateCandiesNeeded();
    }

    /**
     * Traverses the tree, processing all nodes that don't have any parents that need to be assigned candies, starting
     * at all local priority minimums (i.e. roots) and ending when all nodes have been processed.
     *
     * @return The minimum number of candies needed for all the nodes of {@link #allNodes}
     */
    private int accumulateCandiesNeeded() {
        Queue<Node> queue = allNodes.getParentLessNodes();
        Node thisNode;

        int accumulatedCandyCost = 0;

        while (!queue.isEmpty()) {
            thisNode = queue.poll();

            accumulatedCandyCost += (thisNode.getCandyCost() * thisNode.getNodeCount());

            for (Node childNode : thisNode.getChildren()) {
                childNode.decParentCount();
                childNode.setCandyCost(thisNode.getCandyCost()+1);
                if (childNode.hasNoRemainingParents() && childNode.hasNotBeenQueued()) { queue.add(childNode); }
            }
        }

        return accumulatedCandyCost;
    }

    /**
     * Builds a {@link NodeList NodeList} from the input elements of the list of integer priorities.
     *
     * @param priorityList The input list of candy priority of each index.
     */
    private void buildNodeList(int[] priorityList) {
        Node thisNode = new Node(priorityList[0]);
        Node nextNode;
        allNodes.addNode(thisNode);

        for (int i=0; i<priorityList.length-1; i++) {
            if (allNodes.getNode(i).getPriority()==priorityList[i+1]) {
                thisNode.incNodeCount();
                allNodes.addNode(thisNode);
            } else {
                nextNode = new Node(priorityList[i+1]);
                allNodes.addNode(nextNode);
                if (thisNode.getPriority()>nextNode.getPriority()) {
                    nextNode.setLeftChild(thisNode);
                    thisNode.incParentCount();
                } else {
                    thisNode.setRightChild(nextNode);
                    nextNode.incParentCount();
                }
                thisNode = nextNode;
            }
        }

    }
}
