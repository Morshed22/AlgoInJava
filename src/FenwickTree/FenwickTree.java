package FenwickTree;

public class FenwickTree {
    private int [] fenwickTree;

    public FenwickTree(int[] numbs) {
        this.fenwickTree = new int[numbs.length+1];
        construct(numbs);
    }
    public int rangeSum(int startIndex, int endIndex){
        return sum(endIndex)-sum(startIndex-1);
    }
    private void construct(int [] numbs){
        for (int index = 1; index <= numbs.length; index++){
            update(index,numbs[index-1]);
        }
    }

    private void update(int index, int numb) {
        while (index < this.fenwickTree.length){
            this.fenwickTree[index] += numb;
            index = next(index);
        }
    }
    private int next(int index){
        return index+(index & -index);
    }
    private int parent(int index){
        return index-(index & -index);
    }

    public int sum(int index){
        index ++;
        int sum = 0;
        while (index > 0){
            sum += this.fenwickTree[index];
            index = parent(index);
        }
        return sum;
    }
}
