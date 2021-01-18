package SortingTechnique;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int [] nums = {1,44, 56, 8,3,53,99};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void countSort(int [] nums){
        int max = 0;
        int min = 0;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int [] countArray = new int[max-min+1];

        for(int i = 0; i<nums.length; i++){
            countArray[nums[i]-min]++;
        }
        int z = 0;
        for(int i = min; i<= max; i++){
            while (countArray[i-min] > 0){
               nums[z] = i;
               z++;
               countArray[i-min]--;
            }
        }

    }
}
