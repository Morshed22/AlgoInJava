package Queue_DS;

import java.util.Stack;

public class QueueWithSingleStack {

    private Stack<Integer> stack;

    public QueueWithSingleStack() {
        this.stack = new Stack<>();
    }

    public void enqueue(int item){
        this.stack.push(item);
    }


//    50
//    40
//    30
//    20
//    10->
    //using recursion or call stack memory to handle the state.
    public int dequeue(){
        if(stack.size() == 1){
            return stack.pop();
        }
        int item  = stack.pop();

        int lastDequeueItem = dequeue();

        enqueue(item);

        return lastDequeueItem;
    }
}
