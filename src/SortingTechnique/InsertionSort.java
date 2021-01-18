package SortingTechnique;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {12, 7, -5,-77, 102};
        showArray(nums);
    }
    private static void showArray(int[] nums){
        for(int i = 1; i < nums.length; i++){
           int  j = i-1;
           int x = nums[i];
           while (j >= 0 && nums[j] > x){
               swap(nums, j,j+1);
               j--;
           }
           nums[j+1] = x;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
