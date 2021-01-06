package TST;

public class App {
    public static void main(String[] args) {
        TST tst = new TST();
        tst.put("apple", 1);
        tst.put("banana", 2);

        System.out.println(tst.get("apple"));
    }



}
