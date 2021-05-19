/*
 * Copyright (c) 2021.
 * File : CountingSort.java
 * Author : Ankur
 * Last modified : 19/5/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1, 8, 6, 5};

        int[] count = new int[9];
        int[] output = new int[input.length];

        for (int j : input) {
            count[j]++;
        }

        System.out.println(Arrays.toString(count));

        int indx = 0, val = 0, i = 0;
        while(i<output.length){
            if(count[indx]!=val){
                output[i++] = indx;
                val++;
            } else {
                val = 0;
                indx++;
            }
        }

        System.out.println(Arrays.toString(output));
    }
}
