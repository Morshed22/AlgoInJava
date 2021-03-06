package LinekedList_DS;

import java.awt.image.PackedColorModel;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
    this.sizeOfList++;
    if (root == null){
        this.root = new Node<>(data);
    }else {
        insertDataAtBeginning(data);
    }
    }

    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;
    }
    private void insertDataAtEnd(T data, Node<T> node){
        if(node.getNextNode() != null){
            insertDataAtEnd(data, node.getNextNode());
        }else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }
    @Override
    public void remove(T data) {
    if(this.root == null) return;
        --sizeOfList;
        if (this.root.getData().compareTo(data) == 0){
            this.root = this.root.getNextNode();
        }else {
           remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while(actualNode != null){
            if(actualNode.getData().compareTo(data) == 0){
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseList() {
        if (this.root == null) return;
        Node<T> actualNode = this.root;
        while (actualNode != null){
            System.out.print(actualNode + " -> ");
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return this.sizeOfList;
    }

    @Override
    public Node<T> getMiddleNode() {
        Node<T> fasterPointer = this.root;
        Node<T> slowerPointer = this.root;
        while (fasterPointer.getNextNode() != null && fasterPointer.getNextNode().getNextNode() != null){
            fasterPointer = fasterPointer.getNextNode().getNextNode();
            slowerPointer = slowerPointer.getNextNode();
        }
        return slowerPointer;
    }

    @Override
    public void reverseList() {
        Node<T> current = this.root;
        Node<T> previous = null;
        Node<T> next = null;
        while (current != null){
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        this.root = previous;
    }
}
