package Stack_DS;

public class StackWithArray<T>{
    private T[] stack;
    private int numberOfItems;

    public StackWithArray() {
        this.stack = ((T[]) new Object[1]);
    }
    public void push(T newData){
        if (numberOfItems == this.stack.length){
            resize(2*this.stack.length);
        }
        this.stack[numberOfItems++] = newData;
    }
    public boolean isEmpty(){
        return  this.numberOfItems == 0;
    }
    public T pop(){
        T itemTop = this.stack[--numberOfItems];
        this.stack[numberOfItems] = null;
        if(numberOfItems > 0 && numberOfItems == this.stack.length/4){
            resize(this.stack.length/2);
        }
        return itemTop;
    }
    public int size(){
        return this.numberOfItems;
    }
    private void resize(int capacity){
        T[] stackCopy = ((T[]) new Object[capacity]);
        for (int i = 0; i < numberOfItems; i++){
            stackCopy[i] = this.stack[i];
        }
        this.stack = stackCopy;
    }
}
