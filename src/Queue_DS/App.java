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



        //Queue with Stack implementation

        QueueWithStack queueWithStack = new QueueWithStack();
        queueWithStack.enqueue(100);
        queueWithStack.enqueue(300);
        queueWithStack.enqueue(900);

        System.out.println(queueWithStack.dequeue());


        //Queue with single stack

        QueueWithSingleStack queueWithSingleStack = new QueueWithSingleStack();
        queueWithSingleStack.enqueue(888);
        queueWithSingleStack.enqueue(999);
        queueWithSingleStack.enqueue(444);

        System.out.println(queueWithSingleStack.dequeue());
    }
}
