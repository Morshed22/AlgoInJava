package Queue_DS;

public class App {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.enqueue(20);
        integerQueue.enqueue(40);
        integerQueue.enqueue(30);

        System.out.println(integerQueue.size());
        while (!integerQueue.isEmpty()){
            System.out.println(integerQueue.dequeue());
        }

    }
}
