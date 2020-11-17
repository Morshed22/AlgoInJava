package Heap_DS;

public class CheckMinHeap {

    public static void main(String[] args) {
        System.out.println(isMinHeap(new int[]{10,14,19,26,31,43,27,44,35,33,35}));
    }
    private static boolean isMinHeap(int [] heap){
        for(int i = 0; i < (heap.length-2)/2; i++){
           if (heap[i] > heap[2*i+1] || heap[i] > heap[2*i+2]){
               return false;
           }
        }
        return true;
    }

}
