package Queue_DS;


import java.util.Stack;

public class QueueWithStack {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueWithStack(){
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }
    public void enqueue(int item){
        this.enqueueStack.push(item);
    }
    public int dequeue(){
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        if (dequeueStack.isEmpty()){
            while (!enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }
}
