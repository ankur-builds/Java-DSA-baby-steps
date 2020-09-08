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

public class ArrayRotation {
    public static int[] rotate(int[] arr, int d, int n){
        int[] temp = new int[n];
        for(int i = 0; i<n; ++i){
            if(i+d+1 > n){
                temp[i] = arr[d+i-n];
            } else {
                temp[i] = arr[d+i];
            }
        }

        return temp;
    }

    static void leftRotate(int[] arr, int d, int n)
    {
        for (int i = 0; i < d; i++)
            leftRotateByOne(arr, n);
    }

    static void leftRotateByOne(int[] arr, int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    static int gcd(int a, int b){
        if(b==0)
            return a;
        else return gcd(a, a%b);
    }

    static void rotateBySet(int[] arr, int d, int n){
        d = d % n;
        int j, k, temp;
        int g_c_d = gcd(d, n);
        for (int i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];

            j = i;
            while (true) {
                k = j + d; // Calculate the index by adding offset
                if (k >= n)
                    k = k - n;
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

        // Approach 1. O(n), O(n)
        arr = rotate(arr, 3, arr.length);
        for(int x : arr){
            System.out.print(x + " ");
        }

        // Approach 2. O(n*d), O(1)
        leftRotate(arr, 3, arr.length);
        System.out.println();
        for(int x : arr){
            System.out.print(x + " ");
        }

        // Approach 3. O(n), O(1)
        rotateBySet(arr, 3, arr.length);
        System.out.println();
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
