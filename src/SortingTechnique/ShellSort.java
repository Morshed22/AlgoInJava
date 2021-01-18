package SortingTechnique;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {12, 7, -5,-77, 102};
        shelSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void shelSort(int[] nums){
        for(int gap = nums.length/2; gap > 0;  gap/=2){
            for(int i = gap; i < nums.length; i++){
                int j = i;
                while ((j >=gap) && (nums[j-gap]>nums[j])){
                    swap(nums, j, j-gap);
                    j = j-gap;
                }
            }
        }
    }
    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
