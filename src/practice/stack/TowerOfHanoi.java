/*
 * Copyright (c) 2020.
 * File : TowerOfHanoi.java
 * Author : Ankur
 * Last modified : 7/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Stack;

// https://www.youtube.com/watch?v=l45md3RYX7c
public class TowerOfHanoi {
    void recursiveSolution(int n, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> helper){
        if(n==1){
            source.pop();
            destination.push(n);
            return;
        }

        recursiveSolution(n-1, source, helper, destination);
        source.pop();
        destination.push(n);
        recursiveSolution(n-1, helper, destination, source);
    }

    /*
    1. Calculate the total number of moves required i.e. "pow(2, n)
            - 1" here n is number of disks.
    2. If number of disks (i.e. n) is even then interchange destination pole and auxiliary pole.
    3. for i = 1 to total number of moves:
            if i%3 == 1:
            legal movement of top disk between source pole and destination pole
            if i%3 == 2:
            legal movement top disk between source pole and auxiliary pole
            if i%3 == 0:
            legal movement top disk between auxiliary pole and destination pole
    */
    /*
    void iterativeSolution(int n){
        if(n%2==0)
            pushElement(helper);
        else
            pushElement(destination);

        // For every pop from source, I have to rearrange two stacks
        while(!source.isEmpty()){
            pushElement(source.pop());
            while
        }
    }
    */

    public static void main(String[] args) {
        TowerOfHanoi input = new TowerOfHanoi();
        Stack<Integer> source = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        for(int i = 10; i>0; --i){
            source.push(i);
        }

        input.recursiveSolution(10, source, destination, new Stack<>());

        System.out.print("Destination : ");
        while(!destination.isEmpty())
            System.out.print(destination.pop() + " ");


    }
}
