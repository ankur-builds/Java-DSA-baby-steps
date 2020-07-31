/*
 * Copyright (c) 2020.
 * File : LongestSubstring.java
 * Author : Ankur
 * Last modified : 20/7/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package problems.leetcode;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i<n-1;++i){
            for(int j = i+1;j<n; ++j){
                String test = s.substring(i,j);
                int[] arr = new int[26];
                for(int k = 0; k<j-i; ++k) {
                    if(arr[(int)test.charAt(k) - (int)'a']!=0) {
                        if(k > max)
                            max = k;
                        break;
                    } else
                        arr[(int)test.charAt(k) - (int)'a']++;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
/*
Problem Statement : Length of longest substring without repeating characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */