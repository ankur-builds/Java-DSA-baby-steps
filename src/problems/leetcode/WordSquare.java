/*
 * Copyright (c) 2020.
 * File : WordSquare.java
 * Author : Ankur
 * Last modified : 18/7/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package problems.leetcode;

import java.util.List;

public class WordSquare {
    public void printAllWordSquares(List<String> S) {

    }

    public boolean isWordSquare(String str){
        return true;
    }

    public static void main(String[] args) {

    }
}

/*
Problem Statement 1 : Find all possible word squares from list of word
Given a set of words (without duplicates), find all word squares you can build from them.
A sequence of words forms a valid word square if the kth row and column read the exact same string,
where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word
reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
1. There are at least 1 and at most 1000 words.
2. All words will have the exact same length.
3. Word length is at least 1 and at most 5.
4. Each word contains only lowercase English alphabet a-z.

Solution : printAllWordSquares(List<String> S)

Problem Statement 2 : Check if word squares can be generated from given string
Input : ballarealeadlady
Output : true

Same constraints as above problem

Solution : isWordSquare(String S)
 */