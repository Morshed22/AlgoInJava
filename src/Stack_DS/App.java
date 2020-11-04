package Stack_DS;

public class App {
    public static void main(String[] args) {
      Stack<String> stack = new Stack<>();
      stack.push("Hello");
      stack.push("how");
      stack.push("ok");
      while (!stack.isEmpty()){
          System.out.println(stack.pop());
      }

        StackWithArray<Integer> stackWithArray = new StackWithArray<>();
        stackWithArray.push(10);
        stackWithArray.push(20);
        stackWithArray.push(30);
        while (!stackWithArray.isEmpty()){
            System.out.println(stackWithArray.pop());
        }
    }
}
