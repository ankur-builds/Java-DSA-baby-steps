/*
 * Copyright (c) 2021.
 * File : Sort.java
 * Author : Ankur
 * Last modified : 2/4/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] input){
        System.out.println(Arrays.toString(input));
        splitArray(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    static void splitArray(int[] input, int start, int end){
        if(start==end)
            return;

        int mid = (start+end)/2;
        splitArray(input, start, mid);
        splitArray(input, mid+1, end);
        mergeArray(input, start, mid, end);
    }

    static void mergeArray(int[] input, int start, int mid, int end){
        int[] output = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(input[i]<input[j])
                output[k++] = input[i++];
            else
                output[k++] = input[j++];
        }

        while(i<=mid){
            output[k++] = input[i++];
        }

        while(j<=end){
            output[k++] = input[j++];
        }

        if (end + 1 - start >= 0)
            System.arraycopy(output, 0, input, start, end + 1 - start);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,8,5,6,10,2,9,7};
        mergeSort(arr);
    }
}
