package LinekedList_DS;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.insert(10);
        list.insert(-3);
        list.insert(9);
        list.insert(100);
        list.insert(11);

        System.out.println(list.size());
        list.traverseList();
        System.out.println();
       System.out.println(list.getMiddleNode());
       list.reverseList();
       list.traverseList();
    }
}
