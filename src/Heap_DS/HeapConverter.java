package Heap_DS;

public class HeapConverter {
    private int[] heap;

    public HeapConverter(int[] heap) {
        this.heap = heap;
    }
    public int[] transform(){
        for(int i = (heap.length-2)/2; i >= 0; i--){
          heapify(i);
        }
        return this.heap;
    }
    private void heapify(int index){
        int leftIndex = 2*index + 1;
        int rightIndex = 2*index + 2;

        int smallest = index;

        if (leftIndex < heap.length && heap[leftIndex] < heap[index]){
            smallest = leftIndex;
        }
        if (rightIndex < heap.length && heap[rightIndex] < heap[smallest]){
            smallest = rightIndex;
        }
        if(index != smallest){
            swap(index, smallest);
            heapify(smallest);
        }
    }
    private void swap(int index, int parentIndex){
        int temp = this.heap[index];
        this.heap[index]=this.heap[parentIndex];
        this.heap[parentIndex] = temp;
    }
}
