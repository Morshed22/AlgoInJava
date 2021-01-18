package SortingTechnique;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int [] outPutNums = new int[nums.length];
        radixSort(nums,outPutNums);
        System.out.println(Arrays.toString(nums));
    }

    private static void radixSort(int [] nums, int [] outPutNums){
        int m = Arrays.stream(nums).max().getAsInt();

        for(int exp = 1; m/exp > 0; exp*=10 ){
            doOperation(nums, outPutNums, exp);
        }
    }
    private static void doOperation(int [] nums,int [] output, int exp){
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (int i = 0; i < nums.length; i++)
            count[(nums[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (int i = 0; i < nums.length; i++)
            nums[i] = output[i];

    }

}
