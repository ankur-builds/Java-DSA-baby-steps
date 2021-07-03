/*
 * Copyright (c) 2021.
 * File : KnapsackProblem.java
 * Author : Ankur
 * Last modified : 11/6/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.DP;

// Knapsack is basically a choice problem where we decide whether we want to choose an item or not.
public class KnapsackProblem {
    static int recursiveSolution(int[] val, int[] wt, int n, int W){
        if(n==0 || W == 0)
            return 0;

        if(wt[n-1]>W)
            return recursiveSolution(val, wt, n-1, W);
        else
            return Math.max((val[n-1] + recursiveSolution(val, wt, n-1, W-wt[n-1])),
                            recursiveSolution(val, wt, n-1, W));

    }

    static int memoSolution(int[] val, int[] wt, int n, int W, int[][] table){
        if(n==0 || W ==0)
            return 0;

        if(table[n][W]!=-1)
            return table[n][W];

        if(wt[n-1]>W)
            return table[n][W] = memoSolution(val, wt, n-1, W, table);
        else
            return table[n][W] = Math.max(val[n-1]+memoSolution(val, wt, n-1, W-wt[n-1], table),
                                    memoSolution(val, wt, n-1, W, table));
    }

    /**
     * If you see the major difference between memo-ization and tabulation is that in tabulation we are evaulating
     * max profit if we choose a particular item for ALL capacities while in memo-ization we consider only valid
     * capacities.
     *
     * So we are dealing with extra cases here in tabulation. Downside of memo-ization is that it can lead to stack overflow
     */
    static int tabulationSolution(int[] val, int[] wt, int W){
        int[][] table = new int[val.length+1][W+1];

        // Store maximum value for all capacities if an item is chosen or not
        for(int item = 1; item<=val.length; ++item){
            for(int capacity = 1; capacity<=W; ++capacity){
                if(wt[item-1]>capacity)
                    table[item][capacity] = table[item-1][capacity];
                else
                    table[item][capacity] = Math.max(val[item-1]+table[item-1][capacity-wt[item-1]],
                            table[item-1][capacity]);
            }
        }

        return table[val.length][W];
    }

    static int unboundedKnapsackProblem(int[] wt, int[] val, int W){
        int[][] table = new int[val.length+1][W+1];

        for(int i = 1; i<=val.length; ++i){
            for(int j = 1; j<=W; ++j){
                if(wt[i-1]>j)
                    table[i][j] = table[i-1][j];
                else
                    table[i][j] = Math.max(table[i-1][j], val[i-1]+table[i][j-wt[i-1]]);
            }
        }

        return table[val.length][W];
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120, 150, 180, 200, 240};
        int[] weight = {10, 20, 30, 10, 5, 25, 30};
        int capacity = 60;

        // Print maximum value that can be obtained by putting certain items in a knapsack of capacity W
        System.out.println("Plain Recursive -> " + recursiveSolution(value, weight, value.length, capacity));
        int[][] memoTable = new int[value.length+1][capacity+1];
        for(int i = 0; i<=value.length; ++i){
            for(int j = 0; j<=capacity; ++j)
                memoTable[i][j] = -1;
        }
        System.out.println("Memo-ization -> " + memoSolution(value, weight, value.length, capacity, memoTable));
        System.out.println("Tabulation -> " + tabulationSolution(value, weight, capacity));
        System.out.println("Unbounded Knapsack -> " + unboundedKnapsackProblem(weight, value, capacity));
    }
}
