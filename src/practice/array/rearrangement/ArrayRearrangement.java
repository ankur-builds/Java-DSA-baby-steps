/*
 * Copyright (c) 2020.
 * File : ArrayRearrangement.java
 * Author : Ankur
 * Last modified : 5/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.rearrangement;

import java.util.Arrays;

// https://www.geeksforgeeks.org/rearrange-array-arri/
public class ArrayRearrangement {
    public static void rearrange(int[] arr){
        int[] output = new int[arr.length];
        for(int i = 0; i<arr.length; ++i){
            output[i] = -1;
        }

        for(int x : arr){
            if(x>=0 && x<arr.length)
                output[x] = x;
        }

        System.out.println("Input : " + Arrays.toString(arr));
        System.out.println("Rearranged output : " + Arrays.toString(output));
    }

    // https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
    public static void reverse(int[] arr){
        for(int i = 0; i<arr.length/2; ++i){
            int temp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Reversed array : " + Arrays.toString(arr));
    }

    // Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
    // https://www.geeksforgeeks.org/rearrange-array-arri-arrj-even-arri/
    public static void oddEven(int[] arr){
        Arrays.sort(arr);
        int[] output = new int[arr.length];
        int indx = 1;

        // Even
        for(int i = 1; i<arr.length; i = i+2){
            if(arr.length%2==0)
                output[arr.length-i] = arr[arr.length-indx];
            else
                output[arr.length-i-1] = arr[arr.length-indx];
            indx++;
        }

        // Odd
        for(int i = 0; i<arr.length; i = i+2){
            output[i] = arr[arr.length-indx];
            indx++;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args) {
        int[] arr = {-1, -2, 6, 1, 9, 3, 2, -1, 4, -1};
        rearrange(arr);
        reverse(arr);
        oddEven(arr);

        System.out.println();
        int[] arr1 = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        rearrange(arr1);
        reverse(arr1);
        oddEven(arr1);

        System.out.println();
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        oddEven(arr2);
    }
}
