/*
 * Copyright (c) 2021.
 * File : RearrangeArray.java
 * Author : Ankur
 * Last modified : 21/8/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.rearrangement;

import java.util.Arrays;

public class RearrangeArray {
    static boolean rightRotate(int[] arr, int start, int end){
        if(end==arr.length)
            return true;

        int temp = arr[end];
        for(int i = end; i>start; --i)
            arr[i] = arr[i-1];

        arr[start] = temp;
        return false;
    }

    // Rearrange array in alternating positive & negative items with O(1) extra space
    // https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
    static void alternatePositiveNegative(int[] arr){
        boolean stopRotation = false;
        for(int i = 0; i<arr.length; ++i){
            boolean flag = true;
            int end = i;
            if(i%2==0 && arr[i]>=0) {
                end++;
                while(flag && end<arr.length){
                    if(arr[end]<0)
                        flag = false;
                    else
                        end++;
                }
                stopRotation = rightRotate(arr, i,end);
            }else if(i%2!=0 && arr[i]<0) {
                end++;
                while(flag && end<arr.length){
                    if(arr[end]>=0)
                        flag = false;
                    else
                        end++;
                }
                stopRotation = rightRotate(arr, i,end);
            }

            if(stopRotation) break;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        alternatePositiveNegative(arr);

        int[] arr1 = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        alternatePositiveNegative(arr1);
    }
}
