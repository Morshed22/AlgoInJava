package Queue_DS;

public class Queue<T extends Comparable<T>>{
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public boolean isEmpty(){
       return this.head == null;
    }
    public void enqueue( T data){
        count++;
        if (isEmpty()){
            Node <T> newNode = new Node<>(data);
            this.head = newNode;
            this.tail = this.head;
        }else{
            Node <T> newNode = new Node<>(data);
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }
    public int size(){
        return this.count;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }else {
              this.count--;
            T dataToDequeue = this.head.getData();
            this.head = this.head.getNextNode();
            if (isEmpty()){
                this.tail = null;
            }
            return  dataToDequeue;
        }
    }

}
