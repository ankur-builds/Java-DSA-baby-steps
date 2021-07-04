/*
 * Copyright (c) 2021.
 * File : LargestCommonSubsequence.java
 * Author : Ankur
 * Last modified : 4/7/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.DP.easy;

public class LargestCommonSubsequence {
    // Subsequence is discontinuous sequence of characters that are common in both strings.
    static int recursion(char[] A, char[] B, int indxA, int indxB){
        if(indxA==A.length || indxB==B.length)
            return 0;

        if(A[indxA]==B[indxB])
            return Math.max(1+recursion(A,B,indxA+1, indxB+1), recursion(A,B,indxA, indxB+1));
        else
            return Math.max(recursion(A,B,indxA, indxB+1), recursion(A,B,indxA+1,indxB));
    }

    static int recursionII(char[] A, char[] B, int indxA, int indxB){
        // For base condition >> think of smallest valid input
        if(indxA==0||indxB==0)
            return 0;

        if(A[indxA-1]==B[indxB-1])
            return 1+recursionII(A,B,indxA-1, indxB-1);
        else
            return Math.max(recursionII(A,B, indxA, indxB-1), recursionII(A,B,indxA-1, indxB));
    }

    static int max = 0;
    static int LCS(char[] A, char[] B, int indxA, int indxB, int[][] table){
        // For base condition >> think of smallest valid input
        if(indxA==0||indxB==0)
            return 0;

        if(table[indxA][indxB]!=-1)
            return table[indxA][indxB];

        if(A[indxA-1]==B[indxB-1])
            table[indxA][indxB] = 1+ LCS(A,B,indxA-1, indxB-1, table);
        else
            table[indxA][indxB] = Math.max(LCS(A,B, indxA, indxB-1, table),
                    LCS(A,B,indxA-1, indxB, table));

        if(table[indxA][indxB]>max)
            max = table[indxA][indxB];

        return table[indxA][indxB];
    }

    static int memoization(char[] A, char[] B){
        int[][] table = new int[A.length+1][B.length+1];

        max = 0;
        for(int i = 0; i<=A.length; ++i){
            for(int j = 0; j<=B.length; ++j)
                table[i][j] = -1;
        }

        LCS(A,B,A.length, B.length, table);

        return max;
    }

    public static void main(String[] args) {
        String A = "ABCDEF";
        String B = "AECDGH";
        System.out.println(recursion(A.toCharArray(), B.toCharArray(),0,0));
        System.out.println(recursionII(A.toCharArray(), B.toCharArray(), A.length(), B.length()));
        System.out.println(memoization(A.toCharArray(), B.toCharArray()));
    }
}
