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
    static int findLargestIndex(int[] arr){
        int left = 0, right = arr.length-1, mid = 0;

        while(left<=right){
            mid = (left+right)/2;

            if(mid==0 || mid==arr.length-1)
                return mid;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid]>=arr[mid-1] && arr[mid]>=arr[left])
                left = mid+1;
            else
                right = mid-1;
        }

        return mid;
    }

    static int findSmallestIndex(int[] arr){
        int left = 0, right = arr.length-1, mid = 0;

        while(left<=right){
            mid = (left+right)/2;
            if(mid==0 || mid==arr.length-1)
                return mid;

            // Identify key
            if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]){
                return mid;
            } else if (arr[left]<arr[right] || arr[mid]<=arr[left]){ // Identify where to iterate next
                right = mid-1;
            } else
                left = mid+1;
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8,9,1,2};
        System.out.print(findSmallestIndex(arr) + " : ");
        System.out.println(findLargestIndex(arr));

        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        System.out.print(findSmallestIndex(arr1) + " : ");
        System.out.println(findLargestIndex(arr1));

        int[] arr2 = {5,6,7,8,9,1,2,3,4};
        System.out.print(findSmallestIndex(arr2) + " : ");
        System.out.println(findLargestIndex(arr2));

        int[] arr3 = {9,1,2,3,4,5,6,7,8};
        System.out.print(findSmallestIndex(arr3) + " : ");
        System.out.println(findLargestIndex(arr3));
    }
}
