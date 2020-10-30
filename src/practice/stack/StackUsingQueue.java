/*
 * Copyright (c) 2020.
 * File : QToStack.java
 * Author : Ankur
 * Last modified : 29/10/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();

    // Using two queues
    void push(int d) {
        Queue<Integer> q2 = new LinkedList<>();
        q2.add(d);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        q1 = q2;
    }

    // Using only one queue
    void push2(int d) {
        int len = q1.size();
        q1.add(d);
        for(int i =0; i<len; ++i){
            int x = q1.poll();
            q1.add(x);
        }
    }

    int pop() {
        if(!q1.isEmpty())
            return q1.poll();
        else
            return -1;
    }

    public static void main(String[] args) {
        StackUsingQueue temp = new StackUsingQueue();

        System.out.println("Stack using two queues");
        System.out.print("Input : ");
        for (int i = 1; i <= 10; ++i) {
            int k = ThreadLocalRandom.current().nextInt(5, 25);
            System.out.print(k + " ");
            temp.push(k);
        }

        System.out.print("\nOutput : ");
        for (int i = 1; i <= 10; ++i) {
            System.out.print(temp.pop() + " ");
        }

        System.out.println("\n\nStack using only one queue");
        System.out.print("Input : ");
        for (int i = 1; i <= 10; ++i) {
            int k = ThreadLocalRandom.current().nextInt(5, 25);
            System.out.print(k + " ");
            temp.push2(k);
        }

        System.out.print("\nOutput : ");
        for (int i = 1; i <= 10; ++i) {
            System.out.print(temp.pop() + " ");
        }
    }
}
