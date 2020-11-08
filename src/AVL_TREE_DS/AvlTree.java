package AVL_TREE_DS;

public class AvlTree implements Tree{
    private Node root;


    private Node rightRotation(Node node){
        System.out.println("Rotating to the right on node: " + node);
        Node newNode = node.getLeftNode();
        Node tempNode = newNode.getRightNode();

        newNode.setRightNode(node);
        node.setLeftNode(tempNode);

        node.setHeight( Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        newNode.setHeight( Math.max(height(newNode.getLeftNode()), height(newNode.getRightNode())) + 1);

        return newNode;

    }
    private Node leftRotation(Node node){
        System.out.println("Rotating to the left on node: " + node);
        Node newNode = node.getRightNode();
        Node tempNode = newNode.getLeftNode();

        newNode.setLeftNode(node);
        node.setRightNode(tempNode);

        node.setHeight( Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        newNode.setHeight( Math.max(height(newNode.getLeftNode()), height(newNode.getRightNode())) + 1);

        return newNode;
    }
    public int height(Node node ){
        if(node == null){
            return -1;
        }
        return node.getHeight();
    }

    public int getBalance(Node node){
        if(node == null) return 0;
        return height(node.getLeftNode()) - height(node.getRightNode());
    }
    @Override
    public void insert(int data) {
        root = insert(root, data);
    }
    private Node insert(Node node, int data){

        if (node == null) {
            return new Node(data);
        }

        if (data < node.getData()) {
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        return settleViolation(data, node);
    }

    @Override
    public void traverse() {
        if(root == null){
            return;
        }
        inOrderTraversal(root);
    }

    @Override
    public void delete(int data) {
        root = delete(root, data);
    }

    private void inOrderTraversal(Node node ){
        if(node == null)  return;
        inOrderTraversal(node.getLeftNode());
        System.out.println(node);
        inOrderTraversal(node.getRightNode());
    }

    private Node settleViolation(int data, Node node){
        int balance = getBalance(node);

        //LL rotation
        if(balance > 1 && data < node.getLeftNode().getData()){
            return rightRotation(node);
        }
        //RR rotation
        if(balance < -1 && data > node.getRightNode().getData()){
            return leftRotation(node);
        }
        //LR rotation
        if(balance > 1 && data > node.getLeftNode().getData()){
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }
        //RL rotation
        if(balance < -1 && data < node.getRightNode().getData()){
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }
        return node;
    }
    private Node delete(Node node, int data) {

        if (node == null)
            return node;

        // first we have to look for the node we want to get rid of
        if (data < node.getData()) {  // data smaller than given node's data -> go to the left recursively
            node.setLeftNode(delete(node.getLeftNode(), data));
        } else if (data > node.getData()) { // data greater than given node's data -> go to the right recursively
            node.setRightNode(delete(node.getRightNode(), data));
        } else {  // we have found the node we want to remove !!!

            if (node.getLeftNode() == null && node.getRightNode() == null) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            if (node.getLeftNode() == null) {
                System.out.println("Removing the right child...");
                Node tempNode = node.getRightNode();
                node = null;
                return tempNode;
            } else if (node.getRightNode() == null) {
                System.out.println("Removing the left child...");
                Node tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }

            // this is the node with two children case !!!
            System.out.println("Removing item with two children...");
            Node tempNode = getPredecessor(node.getLeftNode());

            node.setData(tempNode.getData());
            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        // have to check on every delete operation whether the tree has become unbalanced or not !!!
        return settleDeletion(node);
    }

    private Node settleDeletion(Node node) {

        int balance = getBalance(node);

        // OK, we know the tree is left heavy BUT it can be left-right heavy or left-left heavy
        if (balance > 1) {

            // left right heavy situation: left rotation on parent + right rotation on grandparent
            if (getBalance(node.getLeftNode()) < 0) {
                node.setLeftNode(leftRotation(node.getLeftNode()));
            }

            // this is the right rotation on grandparent ( if left-left heavy, thats single right rotation is needed
            return rightRotation(node);
        }

        // OK, we know the tree is right heavy BUT it can be left-right heavy or right-right heavy
        if (balance < -1) {
            // right - left heavy so we need a right rotation ( on parent!!! ) before left rotation
            if (getBalance(node.getRightNode()) > 0) {
                node.setRightNode(rightRotation(node.getRightNode()));
            }

            // left rotation on grand parent
            return leftRotation(node);
        }

        return node;
    }
    private Node getPredecessor(Node node) {

        Node predecessor = node;

        while (predecessor.getRightNode() != null)
            predecessor = predecessor.getRightNode();

        return predecessor;
    }
}
