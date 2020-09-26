/*
 * Copyright (c) 2020.
 * File : Stack.java
 * Author : Ankur
 * Last modified : 15/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

public class Stack {
    Node root;

    static class Node{
        int data;
        Node next;

        Node (int d){
            data = d;
            next = null;
        }
    }

    void push(int data) {
        Node temp = root;
        root = new Node(data);
        root.next = temp;
    }

    int pop(){
        int value = 0;
        if(root!=null) {
            value = root.data;
            root = root.next;
        }
        return value;
    }

    int peep(){
        if(root!=null)
            return root.data;
        else return 0;
    }

    boolean isEmpty(){
        return (root==null);
    }

    int search(int key){
        Node n = root;
        int count = 0;
        while(n!=null){
            ++count;
            if(n.data==key)
                return count;

            n = n.next;
        }

        return -1;
    }

    int size(){
        Node n = root;
        int length = 0;
        while(n!=null){
            ++length;
            n = n.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println("Size : " + st.size());
        System.out.println("Index from top : " + st.search(20));
        System.out.println("Is stack empty : " + st.isEmpty() + ", top : " + st.peep());
        System.out.println(st.pop() + " " + st.pop());
        System.out.println("Is stack empty : " + st.isEmpty());
    }
}
