/*
 * Copyright (c) 2021.
 * File : MoveZeroes.java
 * Author : Ankur
 * Last modified : 23/8/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.rearrangement;

import java.util.Arrays;

public class MoveZeroes {
    // Move all zeroes to end of array https://www.geeksforgeeks.org/move-zeroes-end-array/
    static void move(int[] arr){
        int indx = 0;
        for(int i = 0; i<arr.length; ++i){
            if(arr[i]>0)
                arr[indx++] = arr[i];
        }

        while(indx<arr.length){
            arr[indx++] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        move(arr);
    }
}
