/*
 * Copyright (c) 2020.
 * File : CelebrityProblem.java
 * Author : Ankur
 * Last modified : 3/11/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

public class CelebrityProblem {
    int[][] matrix;

    CelebrityProblem(int[][] input){
        matrix = input;
    }
    boolean haveAcquaintance(int i, int j){
        return matrix[i][j] == 1;
    }

    int findCelebrity(){
        int top = 0;

        for(int i = 1; i<matrix.length; ++i){
            if(!haveAcquaintance(i,top))
                top = i;
        }

        for(int i = 0; i<matrix[top].length; ++i){
            if(matrix[top][i]==1)
                return -1;
        }
        return top;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0} };

        CelebrityProblem input = new CelebrityProblem(matrix);
        System.out.println(input.findCelebrity());

        int[][] matrix2 = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0} };

        input = new CelebrityProblem(matrix2);
        System.out.println(input.findCelebrity());
    }
}
