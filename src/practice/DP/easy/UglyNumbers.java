/*
 * Copyright (c) 2021.
 * File : UglyNumbers.java
 * Author : Ankur
 * Last modified : 12/6/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.DP.easy;

import java.util.TreeSet;

// Problem Statement : https://www.geeksforgeeks.org/ugly-numbers/
public class UglyNumbers {
    // Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
    static int findUglyNumber(int n){
        TreeSet<Integer> s = new TreeSet<>();

        int count = 0, uglyNumber = 0;
        s.add(1);
        while(count!=n){
            uglyNumber = s.pollFirst();

            s.add(uglyNumber*2);
            s.add(uglyNumber*3);
            s.add(uglyNumber*5);
            count++;
        }

        return uglyNumber;
    }

    static int dynamicProgramming(int n){
        int nexta = 1, nextb = 1, nextc = 1;
        int a = 0, b = 0, c = 0;

        int[] table = new int[n];

        for(int i = 0; i<n; ++i){
            table[i] = Math.min(nexta, Math.min(nextb, nextc));

            if(table[i]==nexta)
                nexta = table[a++]*2;

            if(table[i]==nextb)
                nextb = table[b++]*3;

            if(table[i]==nextc)
                nextc = table[c++]*5;
        }

        return table[n-1];
    }

    public static void main(String[] args) {
        // TreeSet approach takes O(nlogn) time.
        System.out.println(findUglyNumber(1));
        System.out.println(findUglyNumber(7));
        System.out.println(findUglyNumber(10));
        System.out.println(findUglyNumber(15));
        System.out.println(findUglyNumber(150));



        System.out.println("------");
        // Dynamic Programming approach takes O(n) time.
        System.out.println(dynamicProgramming(1));
        System.out.println(dynamicProgramming(7));
        System.out.println(dynamicProgramming(10));
        System.out.println(dynamicProgramming(15));
        System.out.println(dynamicProgramming(150));
    }
}
