package Heap_DS;

public class Heap {
    private Integer[] heap;
    private int heapSize ;

    public Heap(int size) {
        this.heap = new Integer[Constants.CAPACITY];
    }

    public void insert(int item){
        if(isFull()){
            throw new RuntimeException("Heap is Full");
        }
        this.heap[heapSize] = item;
        heapSize++;
        fixUp(heapSize-1);
    }
    public int getMax(){
        return this.heap[0];
    }
    public int poll(){
        int max = getMax();
        swap(0,heapSize-1);
        this.heapSize--;
        fixDown(0);
        return max;
    }
    public  void heapSort(){
        int size = this.heapSize;
        for(int i = 0; i < size; i++){
            int max = poll();
            System.out.print(max+ " ");
        }
    }
    private void fixDown(int index){
        int indexLeft = 2*index+1;
        int indexRight = 2*index+2;

        int indexLargest = index;
        if(indexLeft < heapSize && heap[indexLeft] > heap[index]){
            indexLargest = index;
        }
        if(indexRight < heapSize && heap[indexRight] > heap[indexLargest]){
            indexLargest = index;
        }

        if(index != indexLargest){
            swap(index,indexLargest);
            fixDown(indexLargest);
        }

    }
    private void fixUp(int index){
        int parentIndex = (index-1)/2;
        while (parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
    }
    private void swap(int index, int parentIndex){
        int temp = this.heap[index];
        this.heap[index]=this.heap[parentIndex];
        this.heap[parentIndex] = temp;
    }
    private boolean isFull(){
        return Constants.CAPACITY == this.heapSize;
    }
}
