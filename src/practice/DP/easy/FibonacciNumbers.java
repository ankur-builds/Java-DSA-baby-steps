/*
 * Copyright (c) 2021.
 * File : FibonacciNumbers.java
 * Author : Ankur
 * Last modified : 12/6/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.DP.easy;

public class FibonacciNumbers {
    // Fn = Fn-1 + Fn-2
    static long fib(int n){
        long a = 0, b = 1, c = 0;
        for(int i = 2; i<=n; ++i){
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(9));
        System.out.println(fib(12));
        System.out.println(fib(24));
        System.out.println(fib(50));
        System.out.println(fib(70));
        System.out.println(fib(90));
    }
}
