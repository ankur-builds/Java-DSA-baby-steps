/*
 * Copyright (c) 2021.
 * File : CountTrees.java
 * Author : Ankur
 * Last modified : 2/4/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.tree;

public class CountTrees {
    static int countTrees(int numNodes){
        if(numNodes<= 1)
            return 1;

        int sum = 0;
        for(int i = 1; i<= numNodes; ++i){
            int countLeftTrees = countTrees(i-1);
            int countRightTrees = countTrees(numNodes-1);

            sum = sum+countLeftTrees*countRightTrees;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countTrees(2));
        System.out.println(countTrees(3));
        System.out.println(countTrees(4));
        System.out.println(countTrees(5));
    }
}
