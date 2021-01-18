package SortingTechnique;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 1,2,3,1,2,3 };
        int [] tempArray = new int[nums.length];
        mergeSort(nums,tempArray,0, nums.length-1);
        //System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(tempArray));
    }

    private static void mergeSort(int nums[],  int tempNums[], int low,  int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(nums, tempNums,low,mid);
            mergeSort(nums, tempNums,mid+1,high);
            merging(nums,tempNums,low,mid,high);
        }
    }
    private static void merging(int nums[],  int tempNums[], int low, int mid, int high){
        int i = low; int j = mid+1 ; int k = low;
       // int tempNums[] = new int[nums.length];
        while (i<= mid && j <= high){
            if(nums[i] < nums[j]){
                tempNums[k++] = nums[i++];
            }else {
                tempNums[k++] = nums[j++];
            }
        }
        for(; i<= mid; i++){
            tempNums[k++] = nums[i++];
        }
        for(; j<= high; j++){
            tempNums[k++] = nums[j++];
        }
        for( i = low; i<= high; i++ ){
            nums[i] = tempNums[i];
        }
    }

}
