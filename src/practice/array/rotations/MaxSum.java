/*
 * Copyright (c) 2021.
 * File : MaxSum.java
 * Author : Ankur
 * Last modified : 19/8/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.rotations;

// Problem Statement : https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/
public class MaxSum {
    public static int maxSum(int[] arr){
        int sum = 0, current = 0;
        for(int i =0; i<arr.length; ++i){
            sum += arr[i];
            current += i*arr[i];
        }

        int max = current, rotation = 0;
        for(int i = 0; i<arr.length-1; ++i){
            current -= (sum-arr.length*arr[i]);
            if(current>max) {
                max = current;
                rotation = i+1;
            }
        }

        System.out.println("Maximum sum at rotation : " + rotation);
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {8, 3, 1 ,2};
        System.out.println(maxSum(arr));

        int[] arr1 = {3, 2, 1};
        System.out.println(maxSum(arr1));

        int[] arr2 = {1,2,3,4,100,99,98,97,96,95};
        System.out.println(maxSum(arr2));
    }
}
