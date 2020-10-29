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

public class QToStack {
    Queue<Integer> q1 = new LinkedList<>();

    void push(int d) {
        Queue<Integer> q2 = new LinkedList<>();
        q2.add(d);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        q1 = q2;
    }

    int pop() {
        if(!q1.isEmpty())
            return q1.poll();
        else
            return -1;
    }

    public static void main(String[] args) {
        QToStack temp = new QToStack();

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
    }
}
