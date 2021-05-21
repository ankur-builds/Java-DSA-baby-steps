/*
 * Copyright (c) 2021.
 * File : CountingInversions.java
 * Author : Ankur
 * Last modified : 19/5/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package problems.hackerrank.interviewKit;

import java.util.ArrayList;
import java.util.List;

public class CountingInversions {
    static long count = 0;
    /*
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countInversions(List<Integer> arr) {
        // Write your code here
        count = 0;
        mergeSort(arr, 0, arr.size()-1);
        System.out.println(arr);
        return count;
    }

    static void mergeSort(List<Integer> arr, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr,mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(List<Integer> arr, int start, int mid, int end){
        int[] output = new int[end-start+1];
        int left = start, right = mid+1;
        int indx = 0;
        while(left<=mid && right<=end){
            int leftVal = arr.get(left), rightVal = arr.get(right);
            if(leftVal<=rightVal){
                output[indx++] = leftVal;
                left++;
            } else{
                count += mid+1-left;
                output[indx++] = rightVal;
                right++;
            }
        }

        while(left<=mid){
            output[indx++] = arr.get(left++);
        }

        while(right<=end){
            output[indx++] = arr.get(right++);
        }

        for(int i : output){
            arr.set(start++, i);
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2); arr.add(1); arr.add(3); arr.add(1); arr.add(2);

        System.out.println(countInversions(arr)==4);
    }
}
