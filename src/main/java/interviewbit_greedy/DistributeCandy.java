package interviewbit_greedy;

import java.util.ArrayList;
import java.util.LinkedList;

public class DistributeCandy {

    static class Node {
        private Node leftChild;
        private Node rightChild;

        private boolean queued;

        private final int priority;

        private int remParentCount;
        private int nodeCount;
        private int candyCost;

        Node(int priority) {
            leftChild = null;
            rightChild = null;
            queued = false;
            this.priority = priority;
            remParentCount = 0;
            nodeCount = 1;
            candyCost = 1;
        }

        public void decParentCount() { remParentCount--; }
        public void incParentCount() { remParentCount++; }
        public boolean hasRemainingParents() {return remParentCount>0; }

        public ArrayList<Node> getChildren() {
            ArrayList<Node> childrenList = new ArrayList<>();
            if (leftChild!=null) { childrenList.add(leftChild); }
            if (rightChild!=null) { childrenList.add(rightChild); }
            return childrenList;
        }
        public void setLeftChild(Node left) { leftChild=left; }
        public void setRightChild(Node right) { rightChild=right; }

        public boolean hasBeenQueued() { return queued; }
        public void markAsQueued() { queued = true; }

        public int getPriority() { return priority; }

        public void incNodeCount() { nodeCount++; }
        public int getNodeCount() { return nodeCount; }
        public void setCandyCost(int cost) { candyCost = Math.max(cost, candyCost); }
        public int getCandyCost() { return candyCost; }

    }

    static class NodeList {
        private final ArrayList<Node> nodes;

        NodeList() { nodes = new ArrayList<>(); }

        public Node getNode(int nodeIndex) { return nodes.get(nodeIndex); }
        public void addNode(Node node) { nodes.add(node); }

        public LinkedList<Node> getParentlessNodes() {
            LinkedList<Node> parentlessNodes = new LinkedList<>();
            for (Node node : nodes) {
                if (!node.hasBeenQueued() && node.remParentCount==0) {
                    parentlessNodes.add(node);
                    node.markAsQueued();
                }
            }
            return parentlessNodes;
        }
    }

    /**
     * Given a list of integers representing index position priorities, finds the minimum number of candies to be
     * distributed given that each index has more candies than adjacent neighbors with a lower priority rating.
     *
     * @param priorityList - An int list which indicates each index position's priority
     * @return An int representing the minimum candies needed to distribute as above
     */
    public int determineNeededCandies(int[] priorityList) {
        NodeList allNodes = new NodeList();

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

        LinkedList<Node> queue = allNodes.getParentlessNodes();

        int accumulatedCandyCost = 0;

        while (!queue.isEmpty()) {
            thisNode = queue.poll();

            accumulatedCandyCost += (thisNode.getCandyCost() * thisNode.getNodeCount());

            for (Node childNode : thisNode.getChildren()) {
                childNode.decParentCount();
                childNode.setCandyCost(thisNode.getCandyCost()+1);
                if (childNode.remParentCount==0) { queue.add(childNode); }
            }
        }

        return accumulatedCandyCost;
    }
}
