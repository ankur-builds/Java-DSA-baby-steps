/*
 * Copyright (c) 2020.
 * File : NextGreaterElement.java
 * Author : Ankur
 * Last modified : 2/11/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class NextGreaterElement {
    static void nextGreaterElement_BruteForce(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            boolean flag = true;
            for (int j = i + 1; j < arr.length && flag; ++j) {
                if (arr[i] < arr[j]) {
                    System.out.print(arr[j] + " ");
                    flag = false;
                }
            }
            if (flag)
                System.out.print("-1 ");
        }
    }

    // Must watch => https://www.youtube.com/watch?v=NXOOYYwpbg4
    static void nextGreaterToRight(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> output = new Stack<>();

        for (int i = arr.length - 1; i >= 0; --i) {
            if (stk.isEmpty()) {
                output.push(-1);
            } else if (arr[i] < stk.peek()) {
                output.push(stk.peek());
            } else {
                while (!stk.isEmpty() && arr[i] >= stk.peek()) {
                    stk.pop();
                }
                if (stk.isEmpty())
                    output.push(-1);
                else
                    output.push(stk.peek());
            }
            stk.push(arr[i]);
        }

        while (!output.isEmpty())
            System.out.print(output.pop() + " ");
    }

    static void nextGreaterToLeft(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> output = new LinkedList<>();

        for (int j : arr) {
            if (stk.isEmpty()) {
                output.add(-1);
            } else if (j < stk.peek()) {
                output.add(stk.peek());
            } else {
                while (!stk.isEmpty() && j >= stk.peek()) {
                    stk.pop();
                }
                if (stk.isEmpty())
                    output.add(-1);
                else
                    output.add(stk.peek());
            }
            stk.push(j);
        }

        while (!output.isEmpty())
            System.out.print(output.poll() + " ");
    }

    static void nextSmallerToRight(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> output = new Stack<>();

        for (int i = arr.length - 1; i >= 0; --i) {
            if (stk.isEmpty())
                output.push(-1);
            else if (arr[i] > stk.peek())
                output.push(stk.peek());
            else {
                while (!stk.isEmpty() && arr[i] <= stk.peek())
                    stk.pop();

                // There are two cases when above while loop will end. Handle it
                if (stk.isEmpty())
                    output.push(-1);
                else
                    output.push(stk.peek());
            }
            stk.push(arr[i]);
        }

        while (!output.isEmpty())
            System.out.print(output.pop() + " ");
    }

    static void nextSmallerToLeft(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> output = new LinkedList<>();

        for (int j : arr) {
            if (stk.isEmpty()) {
                output.add(-1);
            } else if (j > stk.peek()) {
                output.add(stk.peek());
            } else {
                while (!stk.isEmpty() && j <= stk.peek()) {
                    stk.pop();
                }
                if (stk.isEmpty())
                    output.add(-1);
                else
                    output.add(stk.peek());
            }
            stk.push(j);
        }

        while (!output.isEmpty())
            System.out.print(output.poll() + " ");
    }

    public static void main(String[] args) {
        int[] input = new int[20];
        System.out.print("Input : ");
        for (int i = 0; i < 20; ++i) {
            input[i] = ThreadLocalRandom.current().nextInt(1, 100);
            System.out.print(input[i] + " ");
        }

        System.out.println("\n------- NGE Brute Force ------------");
        nextGreaterElement_BruteForce(input);
        System.out.println("\n------- NGE to Right ------------");
        nextGreaterToRight(input);
        System.out.println("\n------- NGE to Left ------------");
        nextGreaterToLeft(input);
        System.out.println("\n------- NSE to Right ------------");
        nextSmallerToRight(input);
        System.out.println("\n------- NSE to Left ------------");
        nextSmallerToLeft(input);
    }
}
