/*
 * Copyright (c) 2021.
 * File : MaxAreaOfHistogram.java
 * Author : Ankur
 * Last modified : 20/4/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Stack;

public class MaxAreaInHistogram {

    // Count the blocks larger than current bar to the left
    private int[] numBlocks_l(int[] input){
        int[] lblocks = new int[input.length];
        Stack<Integer> stk = new Stack<>();

        for(int indx = 0; indx<input.length; ++indx){
            if(stk.isEmpty()){
                // Only true for indx = 0
                lblocks[indx] = 0;
            } else {
                while(!stk.isEmpty()){
                    if(input[stk.peek()]<input[indx]) {
                        // Our search ends here, we can't backtrack anymore in stack
                        lblocks[indx] = indx-stk.peek()-1; // -1 coz we want to exclude element at top of stack
                        break;
                    }else {
                        stk.pop();
                    }
                }

                if(stk.isEmpty())
                    lblocks[indx] = indx; // current indx - start indx(0)
            }
            stk.push(indx); // Add current element to stack so as to compare with next element
        }
        return lblocks;
    }

    // Count the blocks larger than current bar to the right
    private int[] numBlocks_r(int[] input){
        int[] rblocks = new int[input.length];
        Stack<Integer> stk = new Stack<>();

        for(int indx = input.length-1; indx>=0; --indx){
            if(stk.isEmpty()){
                // Only true for indx = input.length-1
                rblocks[indx] = 0;
            } else {
                while(!stk.isEmpty()){
                    if(input[stk.peek()]<input[indx]) {
                        // Our search ends here, we can't backtrack anymore in stack
                        rblocks[indx] = stk.peek()-indx-1; // -1 coz we want to exclude element at top of stack
                        break;
                    }else {
                        stk.pop();
                    }
                }

                if(stk.isEmpty())
                    rblocks[indx] = input.length-1-indx; // last index - current index
            }
            stk.push(indx); // Add current element to stack so as to compare with next element
        }
        return rblocks;
    }

    public void calculateMaxArea(int[] input){
        // Count the blocks larger than current bar to the left
        int[] lblocks = numBlocks_l(input);

        // Count the blocks larger than current bar to the right
        int[] rblocks = numBlocks_r(input);

        int max = 0;
        for(int i = 0; i<input.length; ++i){
            max = Math.max(max, input[i]*(rblocks[i]+lblocks[i]+1));
        }

        System.out.println("Maximum area of histogram : " + max);
    }
    public static void main(String[] args) {
        MaxAreaInHistogram input = new MaxAreaInHistogram();
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        input.calculateMaxArea(arr);
    }
}
