/*
 * Copyright (c) 2020.
 * File : StackUsingPriorityQ.java
 * Author : Ankur
 * Last modified : 30/10/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class StackUsingPriorityQ {
    static class Pair{
        int data;
        int count;
        Pair(int d, int c){
            data = d;
            count = c;
        }
    }

    // The comparator logic is the key here. Its easy to get confused here.
    Queue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return (o1.count < o2.count ? 1 : -1); // Descending order. Last entered first then first entered
        }
    });

    int count = 0;

    void push(int d){
        q.add(new Pair(d, ++count));
    }

    int pop(){
        assert q.peek() != null;
        return q.poll().data;
    }

    boolean isEmpty(){
        return q.isEmpty();
    }

    int size(){
        return q.size();
    }

    int top(){
        assert q.peek() != null;
        return q.peek().data; // Try reversing comparator operator to see how head element of queue changes.
    }

    public static void main(String[] args) {
        StackUsingPriorityQ variable = new StackUsingPriorityQ();

        System.out.print("Input : ");
        for(int i = 1; i<=10; ++i){
            int k = ThreadLocalRandom.current().nextInt(5,25);
            System.out.print(k + " ");
            variable.push(k);
        }

        System.out.println();
        System.out.println("Is stack empty? " + (variable.isEmpty()? "Yes" : "No"));
        System.out.println("Stack size : " + variable.size());
        System.out.println("Top of stack : " + variable.top());

        System.out.print("Output : ");
        for(int i = 1; i<=10; ++i){
            System.out.print(variable.pop() + " ");
        }

        System.out.println();
        System.out.println("Is stack empty? " + (variable.isEmpty()? "Yes" : "No"));
    }
}
