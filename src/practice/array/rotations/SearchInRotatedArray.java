/*
 * Copyright (c) 2021.
 * File : SearchInRotatedArray.java
 * Author : Ankur
 * Last modified : 21/9/2021
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.rotations;

public class SearchInRotatedArray {
    static int findSmallestIndex(int[] arr){
        int left = 0, right = arr.length-1, mid = 0;

        while(left<=right){
            mid = (left+right)/2;

            if(mid==0 || mid==arr.length-1)
                break;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                break;
            else if(arr[mid] > arr[mid-1])
                left = mid+1;
            else
                right = mid-1;
        }

        return (mid==arr.length-1) ? 0 : mid+1;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8,9,1,2};
        System.out.println(findSmallestIndex(arr));

        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        System.out.println(findSmallestIndex(arr1));

        int[] arr2 = {5,6,7,8,9,1,2,3,4};
        System.out.println(findSmallestIndex(arr2));
    }
}
