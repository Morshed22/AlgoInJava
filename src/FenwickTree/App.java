package FenwickTree;

// for learning  below here is the link
//https://www.youtube.com/watch?v=aAALKHLeexw

public class App {
    public static void main(String[] args) {
        int [] numbs = {3,2,-1,6,5,4,-1,3,7,2,3};
        FenwickTree fenwickTree = new FenwickTree(numbs);
        System.out.println(fenwickTree.rangeSum(8,10));
    }
}
