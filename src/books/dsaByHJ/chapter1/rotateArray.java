/*
 * Copyright (c) 2021.
 * File : rotateArray.java
 * Author : Ankur
 * Last modified : 15/3/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package books.dsaByHJ.chapter1;

import java.util.Arrays;

// Problem : Rotate Array by K positions
public class rotateArray {
    public static int[] rotateLeft(int[] input, int k){
        int[] output = new int[input.length];
        for(int i = 0; i<input.length; ++i){
            if(i-k < 0)
                output[input.length-(k-i)] = input[i];
            else
                output[i-k] = input[i];
        }

        return output;
    }

    public static int[] rotateRight(int[] input, int k){
        int[] output = new int[input.length];
        for(int i = 0; i<input.length; ++i){
            if(i+k >= input.length)
                output[i+k - input.length] = input[i];
            else
                output[i+k] = input[i];
        }

        return output;
    }
    public static void main(String[] args) {
        int[] abc = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(rotateLeft(abc, 2)));
        System.out.println(Arrays.toString(rotateRight(abc,2)));

    }
}
