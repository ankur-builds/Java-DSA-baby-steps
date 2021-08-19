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

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args) {
        int[] arr = {-1, -2, 6, 1, 9, 3, 2, -1, 4, -1};
        rearrange(arr);

        int[] arr1 = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        rearrange(arr1);
    }
}
