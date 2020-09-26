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
    public static void main(String[] args) {
        Stack<String> var = new Stack<>();
        Collections.addAll(var, "Lets", "try", "to", "convert", "stack", "to", "queue");

        Iterator it = var.iterator();
        System.out.print("Stack to Queue : ");
        while(it.hasNext())
            System.out.print(it.next() + " ");

        System.out.println();
        System.out.print("Original Stack : ");
        while(!var.isEmpty())
            System.out.print(var.pop()+" ");
    }
}
