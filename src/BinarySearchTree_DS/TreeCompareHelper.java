package BinarySearchTree_DS;

public class TreeCompareHelper<T extends Comparable<T>> {
    public boolean compareTrees(Node<T> node1, Node<T>node2){
        //we have to check the base case (it may be leaf node so we have to use ==)
        if(node1 == null || node2 == null){
            return node1 == node2;
        }
        //if the values within the nodes are not same we return false(trees are not the same)
        if(node1.getData().compareTo(node2.getData()) !=0) return false;
        //the left subtree value AND the right subtree values must match as well !!!
        return compareTrees(node1.getLeftChild(), node2.getLeftChild())  && compareTrees(node1.getRightChild(), node2.getRightChild());
    }
}
