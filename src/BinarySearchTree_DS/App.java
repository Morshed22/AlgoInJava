package BinarySearchTree_DS;

public class App {
    public static void main(String[] args) {
//        Tree<Person> bst = new BinarySearchTree<>();
//        bst.insert(new Person("Bokul", 39));
//        bst.insert(new Person("kad", 34));
//        bst.insert(new Person("JK", 000));
//        bst.insert(new Person("Fj", 34));
//        bst.insert(new Person("ALLL", 234));
//        bst.insert(new Person("IKN", 39));

   Tree<Integer> bst1 = new BinarySearchTree<>();
        bst1.insert(2);
        bst1.insert(55);
        bst1.insert(67);
        bst1.insert(12);
        bst1.insert(11);

//
//        Tree<Integer> bst2 = new BinarySearchTree<>();
//        bst2.insert(2);
//        bst2.insert(55);
//        bst2.insert(6);
//        bst2.insert(12);
//        bst2.insert(11);
//
//        TreeCompareHelper<Integer> treeCompareHelper = new TreeCompareHelper();
//        System.out.println(treeCompareHelper.compareTrees(bst1.getRoot(), bst2.getRoot()));
      bst1.traversal();
      System.out.println();
     System.out.println(bst1.getTheKthSmallest(bst1.getRoot(),3));
    }
}
