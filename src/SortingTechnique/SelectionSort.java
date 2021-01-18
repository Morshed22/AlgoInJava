package SortingTechnique;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {12, 7, -5,-77, 102};
        showArray(nums);
    }
    private static void showArray(int[] nums){
        int i,j, k;
        for( i = 0; i < nums.length-1; i++){
           for(j=k=i; j< nums.length; j++){
               if(nums[j] < nums[k]){
                   k = j;
               }
           }
            swap(nums, i, k);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
