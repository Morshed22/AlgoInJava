package SortingTechnique;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {12, 7, -5,-77, 102};
        showArray(nums);
    }
    private static void showArray(int[] nums){
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 0; j<nums.length-1-i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
