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

public class ConvertIntoQueue {
    Stack<Integer> original;
    Stack<Integer> duplicate;

    ConvertIntoQueue(){
        original = new Stack<>();
        duplicate = new Stack<>();
    }
    /*
    Stack -- LIFO
    Queue -- FIFO

    Stack to Queue
    Input : Stack
    Output : FIFO

    Approach 1 : Add element to top of stack.
    While removing use iterator and get first element to return
    May have copy entire stack element except 1st to another stack and retransfer back? O(2*n)
     */
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
        Stack<String> var = new Stack<>();
        Collections.addAll(var, "Lets", "try", "to", "convert", "stack", "to", "queue");

        Iterator<String> it = var.iterator();
        System.out.print("Stack to Queue : ");
        while(it.hasNext())
            System.out.print(it.next() + " ");

        System.out.println();
        System.out.print("Original Stack : ");
        while(!var.isEmpty())
            System.out.print(var.pop()+" ");

        System.out.println();
        System.out.println("Enqueue in time : " + System.nanoTime());
        ConvertIntoQueue k = new ConvertIntoQueue();
        k.enqueue(10);
        k.enqueue(20);
        k.enqueue(30);
        System.out.println("Enqueue end time : " + System.nanoTime());
        System.out.println(k.dequeue() + " " + k.dequeue() + " " + k.dequeue());
        System.out.println("Dequeue end time : " + System.nanoTime());
    }
}
