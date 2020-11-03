package Arrays_Interview;

public class RepeatedIntegersProblem {
    public static void main(String[] args) {
        findDuplicated();
    }

    static void findDuplicated(){
        int arr[] = new int[] {2, 3, 1, 2, 4,3};

        for(int i = 0; i < arr.length; i++){
           if  (arr[Math.abs(arr[i])] > 0){
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
           }else{
               System.out.println(Math.abs(arr[i]) + " is repetition");
           }
        }
    }
}
