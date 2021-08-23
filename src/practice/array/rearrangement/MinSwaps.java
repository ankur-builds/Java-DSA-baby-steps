/*
 * Copyright (c) 2021.
 * File : MinSwaps.java
 * Author : Ankur
 * Last modified : 23/8/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.rearrangement;

public class MinSwaps {
    // Minimum swaps required to bring all elements less than or equal to k together
    // https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
    static int swaps(int[] arr, int pivot){
        int start = 0, end = arr.length-1, pos = 0, count = 0;

        for(int i = 0; i<arr.length; ++i){
            if(arr[i]==pivot) {
                pos = i;
                break;
            }
        }

        while(start<end) {
            while (arr[start] <= pivot) {
                start++;
            }

            while (arr[end] >= pivot) {
                end--;
            }

            if(start<end) {
                swap(arr, start, end);
                count++;
            }
        }

        if(pos>start)
            swap(arr, start, pos);
        else
            swap(arr, end, pos);

        return count+1;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 5, 8, 7, 4};
        System.out.println(swaps(arr, 5));

        int[] arr1= {2, 1, 5, 6, 3};
        System.out.println(swaps(arr1, 3));
    }
}
