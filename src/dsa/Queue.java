/*
 * Copyright (c) 2020.
 * File : Queue.java
 * Author : Ankur
 * Last modified : 15/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

public class Queue {
    Node front;
    Node end;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }

    }
    void enqueue(int d){
        if(front == null) {
            front = new Node(d);
            end = front;
        } else {
            // Here unlike stack we are adding new node at the end.
            end.next = new Node(d);
            end = end.next;
        }
    }

    int dequeue(){
        if(front==null) {
            end = null;
            return 0;
        }
        int value = front.data;
        front = front.next;
        return value;
    }

    int front(){
        return front.data;
    }

    int rear(){
        return end.data;
    }

    boolean isEmpty(){
        return front==null;
    }

    int size(){
        Node n = front;
        int count = 0;
        while(n!=null){
            ++count;
            n = n.next;
        }
        return count;
    }
    public static void main(String[] args) {
        Queue qu = new Queue();
        qu.enqueue(10);
        qu.enqueue(20);
        qu.enqueue(30);
        qu.enqueue(40);

        System.out.println("Length : " + qu.size());
        System.out.println("Is Queue empty : " + qu.isEmpty());

        System.out.println("Front : " + qu.front() + " Rear : " + qu.rear());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());

        System.out.println("Is Queue empty : " + qu.isEmpty());
    }
}
