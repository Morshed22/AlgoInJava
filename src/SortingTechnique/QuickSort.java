package SortingTechnique;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {12, 7, -5,-77, 102};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    private static void quickSort(int [] nums, int low, int high){
        if (low >= high) return;
        int pivot =  partition(nums, low,high);
        quickSort(nums, low, pivot-1);
        quickSort(nums, pivot+1, high);

    }
    private static int partition(int [] nums, int low, int high){
        int pivotIndex = (low+high)/2;
        swap(nums, pivotIndex, high);
        int i = low;

        for(int j = low; j <= high; j++ ){
            if(nums[j] <= nums[high]){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }
    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
