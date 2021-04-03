/*
 * Copyright (c) 2021.
 * File : QuickSort.java
 * Author : Ankur
 * Last modified : 3/4/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.sorting;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int[] input, int start, int end){
        if(start<end) {
            // Partition the array around pivot
            int mid = partition(input, start, end);
            // Keep partitioning on left and right hand side
            quickSort(input, start, mid - 1);
            quickSort(input, mid + 1, end);
        }
    }

    static int swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return j;
    }

    static int partition(int[] input, int pivot, int end){
        for(int start = pivot+1; start<end; ){
            if(input[start]<input[pivot])
                start++;
            if(input[end]>=input[pivot])
                end--;

            if(input[start] > input[pivot] && input[end]<input[pivot]){
                swap(input, start, end);
                start++;
                end--;
            }
        }

        // One element is not compared and that is when start == end
        if(input[pivot]>input[end])
            return swap(input, pivot, end);
        else
            return swap(input, pivot, end-1);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,8,5,6,6,10,2,9,7};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
