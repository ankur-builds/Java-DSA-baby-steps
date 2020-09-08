/*
 * Copyright (c) 2020.
 * File : KthSmallest.java
 * Author : Ankur
 * Last modified : 5/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.statistics;

import java.util.*;

public class KthSmallest {

    public static void main(String[] args) {
        int[] arr = {4,3,1,9,7,2,6,5};

        // Approach - 1. Sort and return kth smallest
        Arrays.sort(arr);
        System.out.println(arr[5]); // k = 5

        // Approach - 2. Min-heap

        // Approach - 3. Quick select
        /*
        Use quick sort algorithm to partition the array such that left side contains
        k-1 items. Return pivot instead of further sorting it.
         */
    }
}
