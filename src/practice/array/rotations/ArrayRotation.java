/*
 * Copyright (c) 2020.
 * File : ArrayRotation.java
 * Author : Ankur
 * Last modified : 5/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.rotations;

import java.util.Arrays;

// Problem Statement : https://www.geeksforgeeks.org/array-rotation/
public class ArrayRotation {
    // Approach 1 : TC - O(n), SC - O(n)
    public static int[] rotate(int[] arr, int d){
        int[] temp = new int[arr.length];
        for(int i = 0; i<arr.length; ++i){
            if(i-d<0){
                temp[arr.length+i-d] = arr[i];
            } else {
                temp[i-d] = arr[i];
            }
        }

        return temp;
    }

    // Approach 2 : Rotate one at a time. TC - O(n*d), SC - O(1)
    static void leftRotate(int[] arr, int d)
    {
        for (int i = 0; i < d; i++)
            leftRotateByOne(arr);
    }

    static void leftRotateByOne(int[] arr)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < arr.length - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    // Approach 3 : Find GCD and rotate by set. TC - O(n), SC - O(1)
    static int gcd(int a, int b){
        if(b==0)
            return a;
        else return gcd(a, a%b);
    }

    static void rotateBySet(int[] arr, int d){
        d = d % arr.length;
        int j, k, temp;
        int g_c_d = gcd(d, arr.length);
        for (int i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];

            j = i;
            while (true) {
                k = j + d; // Calculate the index by adding offset
                if (k >= arr.length)
                    k = k - arr.length;
                if (k == i)
                    break;

                // Update ith element of corresponding set with ith element of next set
                arr[j] = arr[k];

                // Move on to next set
                j = k;
            }

            // Update ith element of last set
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8,9};
        System.out.println("Input : " + Arrays.toString(arr));

        System.out.println("Approach 1 : " + Arrays.toString(rotate(arr, 3)));

        leftRotate(arr, 3);
        System.out.println("Approach 2 : " + Arrays.toString(arr));

        rotateBySet(arr, 3);
        System.out.println("Approach 3 : " + Arrays.toString(arr));
    }
}
