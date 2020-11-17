package Heap_DS;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(10);
        heap.insert(100);
        heap.insert(-10);

        heap.heapSort();

        System.out.println();
        System.out.println(heap.getMax());


        //Heap Conversation
        HeapConverter heapConverter = new HeapConverter(new int[] {210, 100, 23,2,5});
       int minHeap[] = heapConverter.transform();
       for (int i = 0; i < minHeap.length; i++){
           System.out.print(minHeap[i] + " ");
       }

    }
}
