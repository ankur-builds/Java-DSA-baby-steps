/*
 * Copyright (c) 2020.
 * File : DynamicProgramming.java
 * Author : Ankur
 * Last modified : 30/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

/*
 Here will take example of 0-1 Knapsack problem. Given weights and values
 of n items, put these items in a knapsack of capacity W to get the maximum
 total value in the knapsack.
 */
public class DynamicProgramming {
    static int max(int a, int b){
        return (a>b)?a:b;
    }

    // Here a particular subproblem is computed twice. Time complexity : 2^n
    public static int recursionMethod(int capacity, int[] weight, int[] value, int n){
        // System.out.printf("capacity, n : %d,%d \n", capacity, n);
        // Base Case
        if(n == 0 || capacity == 0)
            return 0;

        /*
            We are iterating from n-1 to 0 here.
            If weight of n-1th element is more than capacity
            then don't include it, iterate over the next item
         */
        if (weight[n-1] > capacity)
            return recursionMethod(capacity, weight, value, n-1);
        else
            /*
            Return maximum of two cases :-
            (1) When nth element is included
            (2) When nth element is not included
             */
            return max(value[n-1] +
                    recursionMethod(capacity- weight[n-1], weight, value, n-1),
                    recursionMethod(capacity, weight, value, n-1));
    }

    /*
    Dynamic Programming Approach
    Recomputations of same subproblems can be avoided by constructing a
    temporary array K[][] in bottom-up manner.
    Watch this video => https://www.youtube.com/watch?v=8LusJS5-AGo
     */
    public static int dynamicProgrammingMethod(int capacity, int[] weight, int[] value, int n){
        int[][] table = new int[n+1][capacity+1];
        System.out.println("\nDynamic Programming Method");
        for(int row = 1; row<=n; ++row){
            for(int column = 1; column<=capacity; ++column){
                if(row==0 || column==0)
                    table[row][column] = 0;
                else if(weight[row-1]>column)
                    table[row][column] = table[row-1][column];
                else
                    table[row][column] = max(value[row-1] +
                                    table[row-1][column - weight[row-1]], // current weight - [number of items left][weight left]
                            table[row-1][column]);
            }
        }

        return table[n][capacity];
    }
    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(recursionMethod(W, wt, val, n));
        System.out.println(dynamicProgrammingMethod(W,wt,val,n));
    }
}
