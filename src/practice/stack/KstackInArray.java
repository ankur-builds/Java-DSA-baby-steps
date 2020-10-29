/*
 * Copyright (c) 2020.
 * File : KstackInArray.java
 * Author : Ankur
 * Last modified : 29/10/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class KstackInArray {
    Stack<Integer>[] stk;
    int[] arr;
    int nextIndx = 0;

    KstackInArray(int stkSize, int arrSize){
        System.out.println("Stack size : " + stkSize + " array size : " + arrSize);
        stk = new Stack[stkSize];
        arr = new int[arrSize];

        for(int i = 0; i<stkSize; ++i){
            stk[i] = new Stack<>();
        }
    }
    void push(int stkNum, int data){
        if(nextIndx==arr.length || stkNum>=stk.length)
            return;

        System.out.print(data + " ");
        stk[stkNum].push(nextIndx);
        arr[nextIndx++] = data;
    }

    int pop(int stkNum){
        if(stkNum>=stk.length || stk[stkNum].isEmpty())
            return -1;
        else
            return arr[stk[stkNum].pop()];
    }

    public static void main(String[] args) {
        KstackInArray kvar = new KstackInArray(
                ThreadLocalRandom.current().nextInt(3,5),
                ThreadLocalRandom.current().nextInt(10,15));

        System.out.print("Input : ");
        for(int i = 0; i<kvar.arr.length; ++i){
            kvar.push(ThreadLocalRandom.current().nextInt(0,kvar.stk.length), // nextInt range >> [start, end)
                    ThreadLocalRandom.current().nextInt(25, 100));
        }

        System.out.print("\nOutput : ");
        for(int i = 0; i<kvar.stk.length; ++i){
            while(true){
                int k = kvar.pop(i);
                if(k==-1)
                    break;
                System.out.print(k + " ");
            }

            System.out.println();
        }
    }
}
