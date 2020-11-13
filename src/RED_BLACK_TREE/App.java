package RED_BLACK_TREE;

public class App {
    public static void main(String[] args) {
        Tree redBlackTree = new  RedBlackTree();

        redBlackTree.insert(10);
        redBlackTree.insert(15);
       redBlackTree.insert(13);
       //.insert(10);

         redBlackTree.traverse();
    }
}
