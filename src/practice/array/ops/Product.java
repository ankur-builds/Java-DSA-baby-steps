/*
 * Copyright (c) 2020.
 * File : Product.java
 * Author : Ankur
 * Last modified : 9/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.ops;
/*
Input : [5,6,10]
Output : [60, 50, 30]
 */
public class Product {
    public static void main(String[] args) {
        long prod = 1;
        int idx = -1;
        boolean allZero = false;
        int[] arr = {4, 1, 2, 3, 0, 5, 6, 7, 8, 9};
        for (int i = 0; i < 10; ++i) {
            if (arr[i] == 0) {
                if (idx != -1) {
                    allZero = true;
                    break;
                } else idx = i;
                continue;
            }
            prod *= arr[i];
        }
        for (int i = 0; i < 10; ++i) {
            if (allZero) {
                System.out.println("Prod " + i + ": " + 0);
                continue;
            }
            if (arr[i] != 0 && idx == -1)
                System.out.println("Prod " + i + ": " + prod / arr[i]);
            else if (arr[i] != 0 && idx != -1)
                System.out.println("Prod " + i + ": " + 0);
            else System.out.println("Prod " + i + ": " + prod);
        }
    }
}
