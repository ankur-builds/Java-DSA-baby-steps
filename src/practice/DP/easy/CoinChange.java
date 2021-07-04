/*
 * Copyright (c) 2021.
 * File : CoinChange.java
 * Author : Ankur
 * Last modified : 4/7/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.DP.easy;

public class CoinChange {
    static int tabulation(int[] coin, int sum){
        int[][] table = new int[coin.length+1][sum+1];

        for(int i = 0; i<=coin.length; ++i) {
            table[i][0] = 1;
        }

        for(int j = 1; j<=sum; ++j){
            table[0][j] = 0;
        }

        for(int i =1; i<=coin.length; ++i){
            for(int j = 1; j<=sum; ++j){
                if(coin[i-1]>j)
                    table[i][j] = table[i-1][j];
                else
                    table[i][j] = table[i-1][j] + table[i][j-coin[i-1]];
            }
        }

        return table[coin.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(tabulation(arr, 5));
    }
}
