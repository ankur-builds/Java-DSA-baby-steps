/*
 * Copyright (c) 2021.
 * File : CatalanNumbers.java
 * Author : Ankur
 * Last modified : 12/6/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.DP.easy;

// Problem Statement : https://www.geeksforgeeks.org/program-nth-catalan-number/
public class CatalanNumbers {
    // C0 = 1, C1 = 1, C2 = C0C1 + C1C0, C3 = C0C2 + C1C1+ C2C0, C4 = C0C3+C1C2+C2C1+C3C0....

    static int findCatalanNumberR(int n){
        if(n==0)
            return 1;

        int catalan = 0;
        for(int i = 0; i<n; ++i)
            catalan += findCatalanNumberR(i)* findCatalanNumberR(n-1-i);

        return catalan;
    }

    static int findCatalanNumberD(int n, int[] c){
        if(n==0)
            return 1;

        if(c[n]!=0)
            return c[n];

        int catalan = 0;
        for(int i = 0; i<n; ++i) {
            catalan += findCatalanNumberR(i) * findCatalanNumberR(n - 1 - i);
        }

        return c[n] = catalan;
    }

    public static void main(String[] args) {
        System.out.println(findCatalanNumberR(3));
        System.out.println(findCatalanNumberR(4));
        System.out.println(findCatalanNumberR(5));

        int[] c = new int[5];
        System.out.println(findCatalanNumberD(4,c));
    }
}
