/*
 * Copyright (c) 2020.
 * File : ConvertIntoQueue.java
 * Author : Ankur
 * Last modified : 14/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ConvertIntoQueue {
    Stack<Integer> original = new Stack<>();
    Stack<Integer> duplicate = new Stack<>();

    void enqueue(int data){
        original.push(data);
    }

    int dequeue(){
        int x;
        duplicate.clear();
        while(!original.isEmpty()){
            duplicate.push(original.pop()); // First at top of stack
        }

        x = duplicate.pop();
        original.clear();
        while(!duplicate.isEmpty()){
            original.push(duplicate.pop());
        }

        return x;
    }
    public static void main(String[] args) {
        ConvertIntoQueue k = new ConvertIntoQueue();
        System.out.print("Input : ");
        for(int i = 1; i<=10; ++i){
            int val = ThreadLocalRandom.current().nextInt(5,45);
            System.out.print(val + " ");
            k.enqueue(val);
        }

        System.out.print("\nOutput : ");
        for (int i = 1; i<=10; ++i){
            System.out.print(k.dequeue()+" ");
        }
    }
}
