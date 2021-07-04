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
        if(indxA==0||indxB==0)
            return 0;

        if(A[indxA-1]==B[indxB-1])
            return 1+recursionII(A,B,indxA-1, indxB-1);
        else
            return Math.max(recursionII(A,B, indxA, indxB-1), recursionII(A,B,indxA-1, indxB));
    }

    public static void main(String[] args) {
        String A = "ABCDEF";
        String B = "AECDGH";
        System.out.println(recursion(A.toCharArray(), B.toCharArray(),0,0));
        System.out.println(recursionII(A.toCharArray(), B.toCharArray(), A.length(), B.length()));
    }
}
