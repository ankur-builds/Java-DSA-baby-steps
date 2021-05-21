/*
 * Copyright (c) 2021.
 * File : ValidString.java
 * Author : Ankur
 * Last modified : 21/5/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package problems.hackerrank.interviewKit;

import java.io.*;
import java.util.*;

// Hackerrank : Sherlock and Valid String
public class ValidString {
    public static String isValid(String s) {
        // Write your code here
        int[] freq = new int[26];

        // Get frequency
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        // Get number of characters with x frequency
        Map<Integer, Integer> val = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int f : freq){
            if(f == 0)
                continue;
            else if (f<min){
                min = f;
            } else if(f>max)
                max = f;

            val.put(f, val.getOrDefault(f,0)+1);
            if(val.size()>2)
                return "NO";
        }

        if (val.size()==2){
            // There can be only two set of values possible here.
            // For string to be valid, one of set should contian only 1 element hence
            // check for Math.abs(max-min)==1 is not required
            if((val.get(min) == 1) || (val.get(max) == 1))
                return "YES";
            else
                return "NO";
        } else
            // Same frequency for all characters
            return "YES";
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println(isValid("a"));
    }
}

