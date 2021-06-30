/*
 * Copyright (c) 2021.
 * File : SubsetSum.java
 * Author : Ankur
 * Last modified : 26/6/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.DP.easy;

public class SubsetSum {
    static boolean recursion(int[] arr, int indx, int total){
        if(indx==arr.length)
            return false;

        if(arr[indx]==total || total==0)
            return true;

        if(arr[indx] > total)
            return recursion(arr, indx+1, total);
        else
            return recursion(arr, indx+1, total-arr[indx]) || recursion(arr, indx+1, total);
    }

    static boolean tabulation(int[] arr, int total){
        boolean[][] table = new boolean[arr.length+1][total+1];

        for(int i = 0; i<=arr.length; ++i){
            table[0][i] = false;
            table[i][0] = true;
        }

        for(int i = 1; i<=arr.length; ++i){
            for(int j = 1; j<=total; ++j){
                if(arr[i-1]>j)
                    table[i][j] = table[i-1][j];
                else
                    table[i][j] = table[i-1][j-arr[i-1]] || table[i-1][j];
            }
        }

        return table[arr.length][total];
    }

    static boolean equalSumPartition(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        if (sum%2 !=0)
            return false;

        return tabulation(arr, sum/2);
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        System.out.println(recursion(set,0,60));
        System.out.println(tabulation(set,60));

        System.out.println("Equal Sum Partition possible : " + equalSumPartition(set));
    }
}
